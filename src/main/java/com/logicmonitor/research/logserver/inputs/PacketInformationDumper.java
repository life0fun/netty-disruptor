package com.logicmonitor.research.logserver.inputs;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketInformationDumper extends SimpleChannelUpstreamHandler {
    private static final Logger LOG = LoggerFactory.getLogger(PacketInformationDumper.class);
    private final Logger sourceInputLog;

    private final String sourceInputName;
    private final String sourceInputId;

    public PacketInformationDumper(MessageInput sourceInput) {
        sourceInputName = sourceInput.getName();
        sourceInputId = sourceInput.getId();
        sourceInputLog = LoggerFactory.getLogger(PacketInformationDumper.class.getCanonicalName() + "." + sourceInputId);
        LOG.debug("Set {} to TRACE for network packet metadata dumps of input {}", sourceInputLog.getName(),
            sourceInput.getUniqueReadableId());
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        try {
            if (sourceInputLog.isTraceEnabled()) {
                final ChannelBuffer message = (ChannelBuffer) e.getMessage();
                sourceInputLog.trace("Recv network data: {} bytes via input '{}' <{}> from remote address {}",
                    message.readableBytes(), sourceInputName, sourceInputId, e.getRemoteAddress());
            }
        } finally {
            super.messageReceived(ctx, e);
        }
    }
}