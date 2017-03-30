package com.logicmonitor.research.logserver.configuration;


import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.logicmonitor.research.logserver.configuration.field.BooleanField;
import com.logicmonitor.research.logserver.configuration.field.DropdownField;
import com.logicmonitor.research.logserver.configuration.field.NumberField;
import com.logicmonitor.research.logserver.configuration.field.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

public class ConfigurationRequest {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationRequest.class);
    private static final String WILDCARD_IP_ADDRESS = "0.0.0.0";

    private final Map<String, ConfigurationField> fields = Maps.newLinkedHashMap();

    public ConfigurationRequest() {}

    public void putAll(Map<String, ConfigurationField> fields) {
        this.fields.putAll(fields);
    }

    public void addField(ConfigurationField f) {
        fields.put(f.getName(), f);
    }

    public void addFields(List<ConfigurationField> fields) {
        fields.forEach(this::addField);
    }

    public boolean containsField(String fieldName) {
        return fields.containsKey(fieldName);
    }

    public ConfigurationField getField(String fieldName) {
        return fields.get(fieldName);
    }

    public Map<String, ConfigurationField> getFields() {
        return fields;
    }

    @Deprecated
    public boolean removeField(String fieldName) {
        return fields.remove(fieldName) != null;
    }

    public static ConfigurationRequest createWithFields(ConfigurationField... fields) {
        final ConfigurationRequest configurationRequest = new ConfigurationRequest();
        configurationRequest.addFields(Lists.newArrayList(fields));

        return configurationRequest;
    }

    @JsonValue
    public Map<String, Map<String, Object>> asList() {
        final Map<String, Map<String, Object>> configs = Maps.newLinkedHashMap();

        for (ConfigurationField f : fields.values()) {
            final Map<String, Object> config = Maps.newHashMap();
            config.put("type", f.getFieldType());
            config.put("human_name", f.getHumanName());
            config.put("description", f.getDescription());
            config.put("default_value", f.getDefaultValue());
            config.put("is_optional", f.isOptional().equals(ConfigurationField.Optional.OPTIONAL));
            config.put("attributes", f.getAttributes());
            config.put("additional_info", f.getAdditionalInformation());

            configs.put(f.getName(), config);
        }

        return configs;
    }

    public void check(Configuration configuration) throws ConfigurationException {
        for (ConfigurationField field : fields.values()) {
            if (field.isOptional().equals(ConfigurationField.Optional.NOT_OPTIONAL)) {
                final String type = field.getFieldType();
                log.debug("Checking for non-optional field {} of type {} in configuration", field.getName(), type);
                switch (type) {
                    case BooleanField.FIELD_TYPE:
                        if (!configuration.booleanIsSet(field.getName())) {
                            throw new ConfigurationException("Mandatory configuration field " + field.getName() + " is missing or has the wrong data type");
                        }
                        break;
                    case NumberField.FIELD_TYPE:
                        if (!configuration.intIsSet(field.getName())) {
                            throw new ConfigurationException("Mandatory configuration field " + field.getName() + " is missing or has the wrong data type");
                        }
                        break;
                    case TextField.FIELD_TYPE:
                    case DropdownField.FIELD_TYPE:
                        if (!configuration.stringIsSet(field.getName())) {
                            throw new ConfigurationException("Mandatory configuration field " + field.getName() + " is missing or has the wrong data type");
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unknown field type " + type + ". This is a bug.");
                }
            }
        }
    }

    /**
     * Creates a new Configuration object containing only the
     * fields specified in this request object.
     * @param config original Configuration
     * @return filtered Configuration, not null but might be empty
     */
    @Nonnull
    public Configuration filter(Configuration config) {
        final Map<String, Object> values = Maps.newHashMap();

        for (final ConfigurationField field : fields.values()) {
            final String name = field.getName();
            final String type = field.getFieldType();
            switch (type) {
                case BooleanField.FIELD_TYPE:
                    if (config.booleanIsSet(name)) {
                        values.put(name, config.getBoolean(name));
                    }
                    break;
                case NumberField.FIELD_TYPE:
                    if (config.intIsSet(name)) {
                        values.put(name, config.getInt(name));
                    }
                    break;
                case TextField.FIELD_TYPE:
                case DropdownField.FIELD_TYPE:
                    if (config.stringIsSet(name)) {
                        values.put(name, config.getString(name));
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type " + type + ". This is a bug.");
            }
        }
        return new Configuration(values);
    }

    public static class Templates {

        public static ConfigurationField bindAddress(String name) {
            return new TextField(
                name,
                "Bind address",
                WILDCARD_IP_ADDRESS,
                "Address to listen on. For example 0.0.0.0 or 127.0.0.1."
            );
        }

        public static ConfigurationField portNumber(String name, int port) {
            return new NumberField(
                name,
                "Port",
                port,
                "Port to listen on.",
                NumberField.Attribute.IS_PORT_NUMBER
            );
        }

        public static ConfigurationField recvBufferSize(String name, int size) {
            return new NumberField(
                name,
                "Receive Buffer Size",
                size,
                "The size in bytes of the recvBufferSize for network connections to this input.",
                ConfigurationField.Optional.OPTIONAL,
                NumberField.Attribute.ONLY_POSITIVE
            );
        }

    }

}
