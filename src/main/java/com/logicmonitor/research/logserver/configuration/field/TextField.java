package com.logicmonitor.research.logserver.configuration.field;

import com.google.common.collect.Lists;
import com.logicmonitor.research.logserver.configuration.AbstractConfigurationField;

import java.util.List;
import java.util.Locale;

public class TextField extends AbstractConfigurationField {
    public static final String FIELD_TYPE = "text";

    public enum Attribute {
        IS_PASSWORD,
        TEXTAREA
    }

    private String defaultValue;

    private final List<String> attributes;

    public TextField(String name, String humanName, String defaultValue, String description, Optional isOptional) {
        this(name, humanName, defaultValue, description, isOptional, new Attribute[0]);
    }

    public TextField(String name, String humanName, String defaultValue, String description, Attribute... attributes) {
        this(name, humanName, defaultValue, description, Optional.NOT_OPTIONAL, attributes);
    }

    public TextField(String name, String humanName, String defaultValue, String description, Optional isOptional, Attribute... attrs) {
        super(FIELD_TYPE, name, humanName, description, isOptional);
        this.defaultValue = defaultValue;

        this.attributes = Lists.newArrayList();
        if (attrs != null) {
            for (Attribute attribute : attrs) {
                this.attributes.add(attribute.toString().toLowerCase(Locale.ENGLISH));
            }
        }
    }

    @Override
    public Object getDefaultValue() {
        return defaultValue;
    }

    @Override
    public void setDefaultValue(Object defaultValue) {
        if (defaultValue instanceof String) {
            this.defaultValue = (String) defaultValue;
        }
    }

    @Override
    public List<String> getAttributes() {
        return attributes;
    }
}

