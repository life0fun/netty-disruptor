package com.logicmonitor.research.logserver.buffer;


import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.lmax.disruptor.WorkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static com.codahale.metrics.MetricRegistry.name;

public class RawMessageEncoderHandler implements WorkHandler<RawMessageEvent> {
    private static final Logger log = LoggerFactory.getLogger(RawMessageEncoderHandler.class);
    private final Meter incomingMessages;

    @Inject
    public RawMessageEncoderHandler(MetricRegistry metricRegistry) {
        incomingMessages = metricRegistry.meter(name(RawMessageEncoderHandler.class, "incomingMessages"));
    }

    @Override
    public void onEvent(RawMessageEvent event) throws Exception {
        incomingMessages.mark();
        event.setEncodedRawMessage(event.getRawMessage().encode());
        event.setMessageIdBytes(event.getRawMessage().getIdBytes());

        if (log.isTraceEnabled()) {
            log.trace("Serialized message {} for journal, size {} bytes",
                event.getRawMessage().getId(), event.getEncodedRawMessage().length);
        }

        // clear for gc and to avoid promotion to tenured space
        event.setRawMessage(null);
    }
}