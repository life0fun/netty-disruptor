package com.logicmonitor.research.logserver.streams;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StreamRuleType {
    EXACT(1, "match exactly", "match exactly"),
    REGEX(2, "match regular expression", "match regular expression"),
    GREATER(3, "greater than", "be greater than"),
    SMALLER(4, "smaller than", "be smaller than"),
    PRESENCE(5, "field presence", "be present"),
    CONTAINS(6, "contain", "contain"),
    ALWAYS_MATCH(7, "always match", "always match");

    private final int value;
    private final String shortDesc;
    private final String longDesc;

    StreamRuleType(final int value, final String shortDesc, final String longDesc) {
        this.value = value;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }

    public int toInteger() {
        return value;
    }

    public static StreamRuleType fromInteger(final int numeric) {
        for (final StreamRuleType streamRuleType : StreamRuleType.values()) {
            if (streamRuleType.value == numeric) {
                return streamRuleType;
            }
        }

        return null;
    }

    @JsonCreator
    public static StreamRuleType fromName(final String name) {
        for (final StreamRuleType streamRuleType : StreamRuleType.values()) {
            if (streamRuleType.name().equals(name)) {
                return streamRuleType;
            }
        }

        throw new IllegalArgumentException("Invalid Stream Rule Type specified: " + name);
    }

    public int getValue() {
        return value;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }
}
