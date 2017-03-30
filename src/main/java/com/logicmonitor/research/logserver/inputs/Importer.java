package com.logicmonitor.research.logserver.inputs;

import com.logicmonitor.research.logserver.configuration.Configuration;
import com.logicmonitor.research.logserver.helpers.Tools;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Importer {
    private static final Logger LOG = LoggerFactory.getLogger(Importer.class);

    private final Map<String, MessageInput> createdInputs = new HashMap<>();

    InputLauncher inputLauncher;
    InputRegistry inputRegistry;
    MessageInputFactory messageInputFactory;


    public Importer(InputLauncher inputLauncher, InputRegistry inputRegistry, MessageInputFactory messageInputFactory) {
        this.inputLauncher = inputLauncher;
        this.inputRegistry = inputRegistry;
        this.messageInputFactory = messageInputFactory;
    }

    private void createInputs(final String bundleId, final Set<Input> inputs, final String userName) throws Exception {
        for (final Input input : inputs) {
            final MessageInput messageInput = createMessageInput(bundleId, input, userName);
            createdInputs.put(messageInput.getId(), messageInput);

            // Launch input. (this will run async and clean up itself in case of an error.)
            inputLauncher.launch(messageInput);
        }
    }

    private MessageInput createMessageInput(final String bundleId, final Input inputDescription, final String userName)
        throws Exception {
//        final Configuration inputConfig = new Configuration(inputDescription.getConfiguration());
        final Configuration inputConfig = new Configuration(new HashMap<String, Object>());
        final DateTime createdAt = Tools.nowUTC();

        final MessageInput messageInput = messageInputFactory.create(inputDescription.getType(), inputConfig);
        messageInput.setTitle(inputDescription.getTitle());
        messageInput.setGlobal(inputDescription.isGlobal());
        messageInput.setCreatorUserId(userName);
        messageInput.setCreatedAt(createdAt);
        messageInput.setContentPack(bundleId);

        messageInput.checkConfiguration();

        // Don't run if exclusive and another instance is already running.
        if (messageInput.isExclusive() && inputRegistry.hasTypeRunning(messageInput.getClass())) {
            LOG.error("Input type <{}> of input <{}> is exclusive and already has input running.",
                messageInput.getClass(), messageInput.getTitle());
        }

//        final String id = inputDescription.getId();
//        final org.graylog2.inputs.Input mongoInput;
//        if (id == null) {
//            mongoInput = inputService.create(buildMongoDbInput(inputDescription, userName, createdAt, bundleId));
//        } else {
//            mongoInput = inputService.create(id, buildMongoDbInput(inputDescription, userName, createdAt, bundleId));
//        }

        // Persist input.
//        final String persistId = inputService.save(mongoInput);
//        messageInput.setPersistId(persistId);
        messageInput.setPersistId("1");
        messageInput.initialize();

//        addStaticFields(messageInput, inputDescription.getStaticFields());
//        addExtractors(messageInput, inputDescription.getExtractors(), userName);

        return messageInput;
    }
}
