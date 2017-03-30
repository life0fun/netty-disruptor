package com.logicmonitor.research.logserver.transport;

import com.codahale.metrics.MetricSet;
import com.codahale.metrics.Timer;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Callables;
import com.logicmonitor.research.logserver.codecs.CodecAggregator;
import com.logicmonitor.research.logserver.configuration.Configuration;
import com.logicmonitor.research.logserver.configuration.ConfigurationRequest;
import com.logicmonitor.research.logserver.inputs.MessageInput;
import com.logicmonitor.research.logserver.inputs.MisfireException;
import com.logicmonitor.research.logserver.inputs.PacketInformationDumper;
import com.logicmonitor.research.logserver.message.RawMessage;
import org.jboss.netty.bootstrap.Bootstrap;
import org.jboss.netty.bootstrap.ConnectionlessBootstrap;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.FixedReceiveBufferSizePredictorFactory;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.socket.DatagramChannel;
import org.jboss.netty.channel.socket.DefaultDatagramChannelConfig;
import org.jboss.netty.channel.socket.ServerSocketChannelConfig;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import static org.jboss.netty.channel.Channels.fireMessageReceived;

public class NettyTransport implements Transport {
    public static final String CK_BIND_ADDRESS = "bind_address";
    public static final String CK_PORT = "port";
    public static final String CK_RECV_BUFFER_SIZE = "recv_buffer_size";
    public static final int RECV_BUF_SIZE = 1024 * 1024;

    private static final Logger log = LoggerFactory.getLogger(NettyTransport.class);

    private final InetSocketAddress socketAddress;
    private final long recvBufferSize;

    private CodecAggregator aggregator;

    private Bootstrap bootstrap;
    private Channel acceptChannel;

    public NettyTransport() {
        this.socketAddress = new InetSocketAddress("localhost", 8080);
        this.recvBufferSize = RECV_BUF_SIZE;
    }

    private ChannelPipelineFactory getPipelineFactory(final LinkedHashMap<String, Callable<? extends ChannelHandler>> handlerList) {
        return new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                final ChannelPipeline p = Channels.pipeline();
                for (final Map.Entry<String, Callable<? extends ChannelHandler>> entry : handlerList.entrySet()) {
                    p.addLast(entry.getKey(), entry.getValue().call());
                }
                return p;
            }
        };
    }

    @Override
    public void setMessageAggregator(CodecAggregator aggregator) {

    }

    @Override
    public void launch(final MessageInput input) throws MisfireException {
        final LinkedHashMap<String, Callable<? extends ChannelHandler>> handlerList = getBaseChannelHandlers(input);
        final LinkedHashMap<String, Callable<? extends ChannelHandler>> finalHandlers = getFinalChannelHandlers(input);

        handlerList.putAll(finalHandlers);
        try {
            bootstrap = getBootstrap();
            bootstrap.setPipelineFactory(getPipelineFactory(handlerList));

            // sigh, bindable bootstraps do not share a common interface
            int receiveBufferSize;
            if (bootstrap instanceof ConnectionlessBootstrap) {
                acceptChannel = ((ConnectionlessBootstrap) bootstrap).bind(socketAddress);

                final DefaultDatagramChannelConfig channelConfig = (DefaultDatagramChannelConfig) acceptChannel.getConfig();
                receiveBufferSize = channelConfig.getReceiveBufferSize();
            } else if (bootstrap instanceof ServerBootstrap) {
                acceptChannel = ((ServerBootstrap) bootstrap).bind(socketAddress);
                final ServerSocketChannelConfig channelConfig = (ServerSocketChannelConfig) acceptChannel.getConfig();
                receiveBufferSize = channelConfig.getReceiveBufferSize();
            } else {
                log.error("Unknown Netty bootstrap class returned: {}. Cannot safely bind.", bootstrap);
                throw new IllegalStateException("Unknown netty bootstrap class returned: " + bootstrap + ". Cannot safely bind.");
            }

        } catch (Exception e) {
            throw new MisfireException(e);
        }
    }

    @Override
    public void stop() {
        if (acceptChannel != null && acceptChannel.isOpen()) {
            acceptChannel.close();
        }
        if (bootstrap != null) {
            bootstrap.shutdown();
        }
    }

    @Override
    public MetricSet getMetricSet() {
        return null;
    }

    /**
     * Construct a {@link org.jboss.netty.bootstrap.ServerBootstrap} to use with this transport.
     * <p/>
     * Set all the options on it you need to have, but do not set a {@link org.jboss.netty.channel.ChannelPipelineFactory},
     * it will be replaced with the
     * augmented list of handlers returned by getBaseChannelHandlers(inputs.MessageInput)
     *
     * @return a configured ServerBootstrap for this transport
     */
    protected Bootstrap getBootstrap() {
        final ServerBootstrap bootstrap =
            new ServerBootstrap(new NioServerSocketChannelFactory());

        bootstrap.setOption("receiveBufferSizePredictorFactory", new FixedReceiveBufferSizePredictorFactory(8192));
        bootstrap.setOption("receiveBufferSize", 1024*1024);
        bootstrap.setOption("child.receiveBufferSize", 1024*1024);
        bootstrap.setOption("child.keepAlive", 5);

        return bootstrap;
    }

    protected LinkedHashMap<String, Callable<? extends ChannelHandler>> getBaseChannelHandlers(final MessageInput input) {
        LinkedHashMap<String, Callable<? extends ChannelHandler>> handlerList = Maps.newLinkedHashMap();

        handlerList.put("exception-logger", new Callable<ChannelHandler>() {
            @Override
            public ChannelHandler call() throws Exception {
                return new SimpleChannelUpstreamHandler() {
                    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
                    @Override
                    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
                        if ("Connection reset by peer".equals(e.getCause().getMessage())) {
                            log.trace("{} in Input [{}/{}] (channel {})",
                                e.getCause().getMessage(),
                                input.getName(),
                                input.getId(),
                                e.getChannel());
                        } else {
                            log.error("Error in Input [{}/{}] (channel {})",
                                input.getName(),
                                input.getId(),
                                e.getChannel(),
                                e.getCause());
                        }
                        super.exceptionCaught(ctx, e);
                    }
                };
            }
        });

        handlerList.put("packet-meta-dumper", new Callable<ChannelHandler>() {
            @Override
            public ChannelHandler call() throws Exception {
                return new PacketInformationDumper(input);
            }
        });
//        handlerList.put("traffic-counter", Callables.returning(throughputCounter));
        handlerList.put("decoder", () -> new StringDecoder());
        return handlerList;
    }

    /**
     * Subclasses can override this to modify the {@link org.jboss.netty.channel.ChannelHandler channel handlers} at the end of the pipeline.
     * <p/>
     * The default handlers in this group are the aggregation handler (e.g. for chunked GELF via UDP), which can be missing, and the {@link NettyTransport.RawMessageHandler}.
     * <p/>
     * Usually this should not be necessary, only modify them if you have a codec that cannot create a RawMessage for
     * incoming messages at the end of the pipeline.
     * <p/>
     * One valid use case would be to insert debug handlers in the middle of the list, though.
     *
     * @param input
     * @return the list of channel handlers at the end of the pipeline
     */
    protected LinkedHashMap<String, Callable<? extends ChannelHandler>> getFinalChannelHandlers(final MessageInput input) {
        LinkedHashMap<String, Callable<? extends ChannelHandler>> handlerList = Maps.newLinkedHashMap();
        handlerList.put("rawmessage-handler", new Callable<ChannelHandler>() {
            @Override
            public ChannelHandler call() throws Exception {
                return new RawMessageHandler(input);
            }
        });
        return handlerList;
    }

    /**
     * Get the local socket address this transport is listening on after being launched.
     *
     * @return the listening address of this transport or {@code null} if the transport hasn't been launched yet.
     */
    public SocketAddress getLocalAddress() {
        if (acceptChannel == null || !acceptChannel.isBound()) {
            return null;
        }

        return acceptChannel.getLocalAddress();
    }

    private class MessageAggregationHandler extends SimpleChannelHandler {
        private final CodecAggregator aggregator;

        public MessageAggregationHandler(CodecAggregator aggregator) {
            this.aggregator = aggregator;
        }

        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            final Object message = e.getMessage();

            if (message instanceof ChannelBuffer) {
                final ChannelBuffer buf = (ChannelBuffer) message;
                final CodecAggregator.Result result;
                result = aggregator.addChunk(buf);
                final ChannelBuffer completeMessage = result.getMessage();
                if (completeMessage != null) {
                    log.debug("Message aggregation completion, forwarding {}", completeMessage);
                    fireMessageReceived(ctx, completeMessage);
                } else if (result.isValid()) {
                    log.debug("More chunks necessary to complete this message");
                } else {
                    log.debug("Message chunk was not valid and discarded.");
                }
            } else {
                log.debug("Could not handle netty message {}, sending further upstream.", e);
                fireMessageReceived(ctx, message);
            }
        }
    }

    private static class RawMessageHandler extends SimpleChannelHandler {
        private final MessageInput input;

        public RawMessageHandler(MessageInput input) {
            this.input = input;
        }

        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            final Object msg = e.getMessage();

            if (!(msg instanceof ChannelBuffer)) {
                log.error(
                    "Invalid message type received from transport pipeline. Should be ChannelBuffer but was {}. Discarding message.",
                    msg.getClass());
                return;

            }
            final ChannelBuffer buffer = (ChannelBuffer) msg;
            final byte[] payload = new byte[buffer.readableBytes()];
            buffer.toByteBuffer().get(payload, buffer.readerIndex(), buffer.readableBytes());

            final RawMessage raw = new RawMessage(payload, (InetSocketAddress) e.getRemoteAddress());
            input.processRawMessage(raw);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
            log.debug("Could not handle message, closing connection: {}", e);

            if (ctx.getChannel() != null && !(ctx.getChannel() instanceof DatagramChannel)) {
                ctx.getChannel().close();
            }
        }
    }

    public static class Config implements Transport.Config {
        @Override
        public ConfigurationRequest getRequestedConfiguration() {
            final ConfigurationRequest r = new ConfigurationRequest();

            r.addField(ConfigurationRequest.Templates.bindAddress(CK_BIND_ADDRESS));
            r.addField(ConfigurationRequest.Templates.portNumber(CK_PORT, 5555));
            r.addField(ConfigurationRequest.Templates.recvBufferSize(CK_RECV_BUFFER_SIZE, 1024 * 1024));

            return r;
        }
    }

    public static class Factory implements Transport.Factory<NettyTransport> {
        Configuration configuration;

        @Override
        public NettyTransport create(Configuration configuration) {
            this.configuration = configuration;
            return new NettyTransport();
        }

        @Override
        public Transport.Config getConfig() {
            return new Config();
        }
    }

}

