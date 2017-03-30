package com.logicmonitor.research.logserver.configuration.field;

import com.google.common.collect.Maps;
import com.logicmonitor.research.logserver.configuration.AbstractConfigurationField;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DropdownField extends AbstractConfigurationField {

    public static final String FIELD_TYPE = "dropdown";

    private String defaultValue;
    private final Map<String, String> values;

    public DropdownField(String name, String humanName, String defaultValue, Map<String, String> values, Optional isOptional) {
        this(name, humanName, defaultValue, values, null, isOptional);
    }

    public DropdownField(String name, String humanName, String defaultValue, Map<String, String> values, String description, Optional isOptional) {
        super(FIELD_TYPE, name, humanName, description, isOptional);
        this.defaultValue = defaultValue;
        this.values = values;
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
    public Map<String, Map<String, String>> getAdditionalInformation() {
        Map<String, Map<String, String>> result = Maps.newHashMap();
        result.put("values", values);
        return result;
    }

    public static class ValueTemplates {

        public static Map<String, String> timeUnits() {
            Map<String, String> units = Maps.newHashMap();

            for(TimeUnit unit : TimeUnit.values()) {
                String human = unit.toString().toLowerCase(Locale.ENGLISH);
                units.put(unit.toString(), Character.toUpperCase(human.charAt(0)) + human.substring(1));
            }

            return units;
        }

        public static Map<String, String> valueMapFromEnum(Class<? extends Enum> enumClass, Function<Enum, String> valueMapping) {
            return Arrays.stream(enumClass.getEnumConstants()).collect(Collectors.toMap(Enum::toString, valueMapping));
        }

    }

}
