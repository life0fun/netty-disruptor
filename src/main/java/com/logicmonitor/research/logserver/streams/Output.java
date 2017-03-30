package com.logicmonitor.research.logserver.streams;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;
import java.util.Map;

@JsonAutoDetect
public interface Output {
    String getId();

    String getTitle();

    String getType();

    String getCreatorUserId();

    Map<String, Object> getConfiguration();

    Date getCreatedAt();

    String getContentPack();
}
