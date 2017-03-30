package com.logicmonitor.research.logserver.inputs;

import java.util.Map;

public class InputDescription {
    private final MessageInput.Descriptor descriptor;
    private final MessageInput.Config config;

    public InputDescription(MessageInput.Descriptor descriptor, MessageInput.Config config) {
        this.descriptor = descriptor;
        this.config = config;
    }

    public String getName() {
        return descriptor.getName();
    }

    public boolean isExclusive() {
        return descriptor.isExclusive();
    }

    public String getLinkToDocs() {
        return descriptor.getLinkToDocs();
    }

    public Map<String, Map<String, Object>> getRequestedConfiguration() {
        return config.combinedRequestedConfiguration().asList();
    }
}