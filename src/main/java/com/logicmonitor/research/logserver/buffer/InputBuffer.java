package com.logicmonitor.research.logserver.buffer;

import com.logicmonitor.research.logserver.message.RawMessage;

public interface InputBuffer {
    void insert(RawMessage message);

    long getUsage();
}
