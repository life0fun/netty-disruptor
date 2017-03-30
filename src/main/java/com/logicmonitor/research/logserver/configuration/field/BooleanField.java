package com.logicmonitor.research.logserver.configuration.field;

import com.logicmonitor.research.logserver.configuration.AbstractConfigurationField;

public class BooleanField extends AbstractConfigurationField {

    public static final String FIELD_TYPE = "boolean";

    private boolean defaultValue;

    public BooleanField(String name, String humanName, boolean defaultValue, String description) {
        super(FIELD_TYPE, name, humanName, description, Optional.OPTIONAL);
        this.defaultValue = defaultValue;
    }

    @Override
    public Object getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public void setDefaultValue(Object defaultValue) {
        if (defaultValue instanceof Boolean) {
            this.defaultValue = (boolean) defaultValue;
        }
    }
}