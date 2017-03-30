package com.logicmonitor.research.logserver.configuration;

import java.util.List;
import java.util.Map;

public interface ConfigurationField {
    enum Optional {
        OPTIONAL,
        NOT_OPTIONAL
    }

    String getFieldType();

    String getName();

    String getHumanName();

    String getDescription();

    Object getDefaultValue();

    void setDefaultValue(Object defaultValue);

    Optional isOptional();

    List<String> getAttributes();

    Map<String, Map<String, String>> getAdditionalInformation();
}
