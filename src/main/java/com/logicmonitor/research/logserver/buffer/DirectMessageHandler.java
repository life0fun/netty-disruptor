package com.logicmonitor.research.logserver.buffer;

import com.lmax.disruptor.WorkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

class DirectMessageHandler implements WorkHandler<RawMessageEvent> {
    private static final Logger log = LoggerFactory.getLogger(DirectMessageHandler.class);

//    private final ProcessBuffer processBuffer;

    @Inject
//    public DirectMessageHandler(ProcessBuffer processBuffer) {
//        this.processBuffer = processBuffer;
//    }

    public DirectMessageHandler() {
    }

    @Override
    public void onEvent(RawMessageEvent event) throws Exception {
//        processBuffer.insertBlocking(event.getRawMessage());
        // clear out for gc and to avoid promoting the raw message event to a tenured gen
        System.out.println(String.format("DirectMessageHandler onEvent : %s", event.getRawMessage().toStringUtf8()));
        event.setRawMessage(null);
    }
}