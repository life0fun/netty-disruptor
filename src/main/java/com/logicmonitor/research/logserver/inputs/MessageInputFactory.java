package com.logicmonitor.research.logserver.inputs;

import com.google.common.collect.Maps;
import com.logicmonitor.research.logserver.configuration.Configuration;
import com.logicmonitor.research.logserver.helpers.Tools;

import javax.inject.Inject;
import java.util.Map;

public class MessageInputFactory {
    private final Map<String, MessageInput.Factory<? extends MessageInput>> inputFactories;

    @Inject
    public MessageInputFactory(Map<String, MessageInput.Factory<? extends MessageInput>> inputFactories) {
        this.inputFactories = inputFactories;
    }

    public MessageInput create(String type, Configuration configuration) throws Exception {
        if (inputFactories.containsKey(type)) {
            final MessageInput.Factory<? extends MessageInput> factory = inputFactories.get(type);
            return factory.create(configuration);
        }
        throw new Exception("There is no input of type <" + type + "> registered.");
    }

//    public MessageInput create(InputCreateRequest lr, String user, String nodeId) throws NoSuchInputTypeException {
//        final MessageInput input = create(lr.type(), new Configuration(lr.configuration()));
//        input.setTitle(lr.title());
//        input.setGlobal(lr.global());
//        input.setCreatorUserId(user);
//        input.setCreatedAt(Tools.nowUTC());
//        if (!lr.global())
//            input.setNodeId(nodeId);
//
//        return input;
//    }

    public Map<String, InputDescription> getAvailableInputs() {
        final Map<String, InputDescription> result = Maps.newHashMap();
        for (final Map.Entry<String, MessageInput.Factory<? extends MessageInput>> factories : inputFactories.entrySet()) {
            final MessageInput.Factory<? extends MessageInput> factory = factories.getValue();
            final MessageInput.Descriptor descriptor = factory.getDescriptor();
            final MessageInput.Config config = factory.getConfig();
            final InputDescription inputDescription = new InputDescription(descriptor, config);
            result.put(factories.getKey(), inputDescription);
        }

        return result;
    }
}