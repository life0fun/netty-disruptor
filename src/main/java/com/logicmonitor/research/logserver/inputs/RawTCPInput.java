package com.logicmonitor.research.logserver.inputs;

import com.codahale.metrics.MetricRegistry;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.logicmonitor.research.logserver.codecs.RawCodec;
import com.logicmonitor.research.logserver.configuration.Configuration;
import com.logicmonitor.research.logserver.server.state.ServerStatus;
import com.logicmonitor.research.logserver.transport.NettyTransport;
import sun.nio.ch.Net;

import javax.inject.Inject;

public class RawTCPInput extends MessageInput {

    private static final String NAME = "Raw/Plaintext TCP";

    @AssistedInject
    public RawTCPInput(@Assisted final Configuration configuration,
                       final NettyTransport.Factory tcpTransportFactory,
                       final RawCodec.Factory rawCodecFactory,
                       final MetricRegistry metricRegistry,
                       //LocalMetricRegistry localRegistry,
                       Config config, Descriptor descriptor, ServerStatus serverStatus) {
        super(metricRegistry,
            configuration,
            tcpTransportFactory.create(configuration),
            rawCodecFactory.create(configuration),
            config, descriptor, serverStatus);
    }

    public interface Factory extends MessageInput.Factory<RawTCPInput> {
        @Override
        RawTCPInput create(Configuration configuration);

        @Override
        Config getConfig();

        @Override
        Descriptor getDescriptor();
    }

    public static class Descriptor extends MessageInput.Descriptor {
        @Inject
        public Descriptor() {
            super(NAME, false, "");
        }
    }

    public static class Config extends MessageInput.Config {
        @Inject
        public Config(NettyTransport.Factory transport, RawCodec.Factory codec) {
            super(transport.getConfig(), codec.getConfig());
        }
    }
}
