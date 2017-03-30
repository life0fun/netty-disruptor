package com.logicmonitor.research.logserver.inputs;

import org.joda.time.DateTime;

import java.util.Map;

public interface Input { // extends Persisted {
    String getTitle();

    DateTime getCreatedAt();

    Map<String, Object> getConfiguration();

    Map<String, String> getStaticFields();

    String getType();

    String getCreatorUserId();

    Boolean isGlobal();

    String getContentPack();

    String getNodeId();
}