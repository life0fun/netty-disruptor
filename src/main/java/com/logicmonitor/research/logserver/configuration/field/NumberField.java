package com.logicmonitor.research.logserver.configuration.field;

import com.google.common.collect.Lists;
import com.logicmonitor.research.logserver.configuration.AbstractConfigurationField;
import com.logicmonitor.research.logserver.configuration.ConfigurationField;

import java.util.List;
import java.util.Locale;

public class NumberField extends AbstractConfigurationField {

    public static final String FIELD_TYPE = "number";

    public enum Attribute {
        ONLY_POSITIVE,
        ONLY_NEGATIVE,
        IS_PORT_NUMBER
    }

    private Number defaultValue;

    private final List<String> attributes;

    public NumberField(String name, String humanName, int defaultValue, String description, Optional isOptional) {
        this(name, humanName, defaultValue, description, isOptional, new Attribute[0]);
    }

    public NumberField(String name, String humanName, double defaultValue, String description, Optional isOptional) {
        this(name, humanName, defaultValue, description, isOptional, new Attribute[0]);
    }

    public NumberField(String name, String humanName, int defaultValue, String description, Attribute... attributes) {
        this(name, humanName, defaultValue, description, Optional.NOT_OPTIONAL, attributes);
    }

    public NumberField(String name, String humanName, double defaultValue, String description, Attribute... attributes) {
        this(name, humanName, defaultValue, description, ConfigurationField.Optional.NOT_OPTIONAL, attributes);
    }

    public NumberField(String name, String humanName, int defaultValue, String description, ConfigurationField.Optional isOptional, Attribute... attributes) {
        this(name, humanName, (Number) defaultValue, description, isOptional, attributes);
    }

    public NumberField(String name, String humanName, double defaultValue, String description, ConfigurationField.Optional isOptional, Attribute... attributes) {
        this(name, humanName, (Number) defaultValue, description, isOptional, attributes);
    }

    private NumberField(String name, String humanName, Number defaultValue, String description, ConfigurationField.Optional isOptional, Attribute... attributes) {
        super(FIELD_TYPE, name, humanName, description, isOptional);
        this.defaultValue = defaultValue;

        this.attributes = Lists.newArrayList();
        if (attributes != null) {
            for (Attribute attribute : attributes) {
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
        if (defaultValue instanceof Number) {
            this.defaultValue = (Number) defaultValue;
        }
    }

    @Override
    public List<String> getAttributes() {
        return attributes;
    }
}
