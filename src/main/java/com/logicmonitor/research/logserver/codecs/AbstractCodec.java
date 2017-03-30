package com.logicmonitor.research.logserver.codecs;

import com.logicmonitor.research.logserver.configuration.Configuration;
import com.logicmonitor.research.logserver.configuration.ConfigurationField;
import com.logicmonitor.research.logserver.configuration.ConfigurationRequest;
import com.logicmonitor.research.logserver.configuration.field.TextField;
import com.logicmonitor.research.logserver.inputs.Codec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractCodec implements Codec {
    private static final Logger log = LoggerFactory.getLogger(AbstractCodec.class);

    protected final Configuration configuration;

    private String name;

    protected AbstractCodec(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    @Nonnull
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public String getName() {
        // can be a race condition, but we don't care the outcome is always the same
        if (name == null) {
            if (this.getClass().isAnnotationPresent(com.logicmonitor.research.logserver.annotations.Codec.class)) {
                name = this.getClass().getAnnotation(com.logicmonitor.research.logserver.annotations.Codec.class).name();
            } else {
                log.error("Annotation {} missing on codec {}. This is a bug and this codec will not be available.",
                    com.logicmonitor.research.logserver.annotations.Codec.class, this.getClass());
            }
        }
        return name;
    }

    @Nullable
    @Override
    public CodecAggregator getAggregator() {
        return null;
    }

    public abstract static class Config implements Codec.Config {
        @Override
        public ConfigurationRequest getRequestedConfiguration() {
            final ConfigurationRequest configurationRequest = new ConfigurationRequest();

            // TODO implement universal override (in raw message maybe?)
            configurationRequest.addField(new TextField(
                CK_OVERRIDE_SOURCE,
                "Override source",
                null,
                "The source is a hostname derived from the received packet by default. Set this if you want to override " +
                    "it with a custom string.",
                ConfigurationField.Optional.OPTIONAL
            ));

            return configurationRequest;
        }

        @Override
        public void overrideDefaultValues(@Nonnull ConfigurationRequest cr) {
        }
    }

    public static class Descriptor extends Codec.Descriptor {
        public Descriptor(String name) {
            super(name);
        }
    }
}