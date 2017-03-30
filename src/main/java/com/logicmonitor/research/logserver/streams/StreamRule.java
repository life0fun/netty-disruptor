package com.logicmonitor.research.logserver.streams;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Map;

@JsonAutoDetect
public interface StreamRule {
    String getId();

    StreamRuleType getType();

    String getField();

    String getValue();

    Boolean getInverted();

    String getStreamId();

    String getContentPack();

    String getDescription();

    void setType(StreamRuleType type);

    void setField(String field);

    void setValue(String value);

    void setInverted(Boolean inverted);

    void setContentPack(String contentPack);

    void setDescription(String description);

    Map<String, Object> asMap();
}
