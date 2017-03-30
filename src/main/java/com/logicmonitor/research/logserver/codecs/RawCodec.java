package com.logicmonitor.research.logserver.codecs;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.logicmonitor.research.logserver.annotations.Codec;
import com.logicmonitor.research.logserver.configuration.Configuration;
import com.logicmonitor.research.logserver.configuration.ConfigurationRequest;
import com.logicmonitor.research.logserver.message.Message;
import com.logicmonitor.research.logserver.message.RawMessage;
import com.logicmonitor.research.logserver.transport.NettyTransport;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Codec(name = "raw", displayName = "Raw String")
public class RawCodec extends AbstractCodec {

    public RawCodec() {
        super(new Configuration(new HashMap<String, Object>()));
    }

    @AssistedInject
    public RawCodec(@Assisted Configuration configuration) {
        super(configuration);
    }

    @Nullable
    @Override
    public Message decode(@Nonnull RawMessage raw) {
        return new Message(new String(raw.getPayload(), StandardCharsets.UTF_8), null, raw.getTimestamp());
    }

    @Nullable
    @Override
    public CodecAggregator getAggregator() {
        return null;
    }

//    @FactoryClass
    public interface Factory extends AbstractCodec.Factory<RawCodec> {
        @Override
        RawCodec create(Configuration configuration);

        @Override
        Config getConfig();

        @Override
        Descriptor getDescriptor();
    }

//    @ConfigClass
    public static class Config extends AbstractCodec.Config {
        @Override
        public void overrideDefaultValues(@Nonnull ConfigurationRequest cr) {
            if (cr.containsField(NettyTransport.CK_PORT)) {
                cr.getField(NettyTransport.CK_PORT).setDefaultValue(5555);
            }
        }
    }

    public static class Descriptor extends AbstractCodec.Descriptor {
        @Inject
        public Descriptor() {
            super(RawCodec.class.getAnnotation(Codec.class).displayName());
        }
    }
}

