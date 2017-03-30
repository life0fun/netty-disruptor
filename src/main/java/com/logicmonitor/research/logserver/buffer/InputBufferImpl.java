package com.logicmonitor.research.logserver.buffer;


import com.codahale.metrics.Gauge;
import com.codahale.metrics.InstrumentedThreadFactory;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.logicmonitor.research.logserver.configuration.BaseConfiguration;
import com.logicmonitor.research.logserver.journal.KafkaJournal;
import com.logicmonitor.research.logserver.message.RawMessage;
import com.logicmonitor.research.logserver.metrics.GlobalMetricNames;
import com.logicmonitor.research.logserver.server.state.ServerStatus;
import kafka.log.LogConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;

import static com.codahale.metrics.MetricRegistry.name;
import static com.logicmonitor.research.logserver.metrics.MetricUtils.constantGauge;
import static com.logicmonitor.research.logserver.metrics.MetricUtils.safelyRegister;

@Singleton
public class InputBufferImpl implements InputBuffer {
    private static final Logger LOG = LoggerFactory.getLogger(InputBufferImpl.class);

    private final RingBuffer<RawMessageEvent> ringBuffer;
    private final Meter incomingMessages;

    @Inject
    public InputBufferImpl(MetricRegistry metricRegistry,
                           BaseConfiguration configuration,
                           Provider<DirectMessageHandler> directMessageHandlerProvider,
                           Provider<RawMessageEncoderHandler> rawMessageEncoderHandlerProvider,
                           Provider<JournallingMessageHandler> spoolingMessageHandlerProvider) {
        final Disruptor<RawMessageEvent> disruptor = new Disruptor<>(
            RawMessageEvent.FACTORY,
            configuration.getInputBufferRingSize(),
            threadFactory(metricRegistry),
            ProducerType.MULTI,
            configuration.getInputBufferWaitStrategy());
        disruptor.setDefaultExceptionHandler(new LoggingExceptionHandler(LOG));

        final int numberOfHandlers = configuration.getInputbufferProcessors();
        if (configuration.isMessageJournalEnabled()) {
            LOG.info("Message journal is enabled.");

            final RawMessageEncoderHandler[] handlers = new RawMessageEncoderHandler[numberOfHandlers];
            for (int i = 0; i < numberOfHandlers; i++) {
                handlers[i] = rawMessageEncoderHandlerProvider.get();
            }
            disruptor.handleEventsWithWorkerPool(handlers).then(spoolingMessageHandlerProvider.get());
        } else {
            LOG.info("Message journal is disabled.");
            final DirectMessageHandler[] handlers = new DirectMessageHandler[numberOfHandlers];
            for (int i = 0; i < numberOfHandlers; i++) {
                handlers[i] = directMessageHandlerProvider.get();
            }
            disruptor.handleEventsWithWorkerPool(handlers);
        }

        ringBuffer = disruptor.start();

        incomingMessages = metricRegistry.meter(name(InputBufferImpl.class, "incomingMessages"));
        safelyRegister(metricRegistry, GlobalMetricNames.INPUT_BUFFER_USAGE, new Gauge<Long>() {
            @Override
            public Long getValue() {
                return InputBufferImpl.this.getUsage();
            }
        });
        safelyRegister(metricRegistry, GlobalMetricNames.INPUT_BUFFER_SIZE, constantGauge(ringBuffer.getBufferSize()));

        LOG.info("Initialized {} with ring size <{}> and wait strategy <{}>, running {} parallel message handlers.",
            this.getClass().getSimpleName(),
            configuration.getInputBufferRingSize(),
            configuration.getInputBufferWaitStrategy().getClass().getSimpleName(),
            numberOfHandlers);
    }

    /**
     * manual constructor.
     * @param metricRegistry
     * @param configuration
     */
    public InputBufferImpl(MetricRegistry metricRegistry,
                           BaseConfiguration configuration,
                           ServerStatus serverStatus) {
        final Disruptor<RawMessageEvent> disruptor = new Disruptor<>(
            RawMessageEvent.FACTORY,
            configuration.getInputBufferRingSize(),
            threadFactory(metricRegistry),
            ProducerType.MULTI,
            configuration.getInputBufferWaitStrategy());
        disruptor.setDefaultExceptionHandler(new LoggingExceptionHandler(LOG));

        final int numberOfHandlers = configuration.getInputbufferProcessors();
        if (configuration.isMessageJournalEnabled()) {
            LOG.info("Message journal is enabled.");

            final RawMessageEncoderHandler[] handlers = new RawMessageEncoderHandler[numberOfHandlers];
            for (int i = 0; i < numberOfHandlers; i++) {
                handlers[i] = new RawMessageEncoderHandler(metricRegistry);
            }
            disruptor.handleEventsWithWorkerPool(handlers)
                .then(new JournallingMessageHandler(metricRegistry, KafkaJournal.factory(metricRegistry, serverStatus), new Semaphore(4)));
        } else {
            LOG.info("Message journal is disabled.");
            final DirectMessageHandler[] handlers = new DirectMessageHandler[numberOfHandlers];
            for (int i = 0; i < numberOfHandlers; i++) {
                handlers[i] = new DirectMessageHandler();
            }
            disruptor.handleEventsWithWorkerPool(handlers);
        }

        ringBuffer = disruptor.start();

        incomingMessages = metricRegistry.meter(name(InputBufferImpl.class, "incomingMessages"));
        safelyRegister(metricRegistry, GlobalMetricNames.INPUT_BUFFER_USAGE, new Gauge<Long>() {
            @Override
            public Long getValue() {
                return InputBufferImpl.this.getUsage();
            }
        });
        safelyRegister(metricRegistry, GlobalMetricNames.INPUT_BUFFER_SIZE, constantGauge(ringBuffer.getBufferSize()));

        LOG.info("Initialized {} with ring size <{}> and wait strategy <{}>, running {} parallel message handlers.",
            this.getClass().getSimpleName(),
            configuration.getInputBufferRingSize(),
            configuration.getInputBufferWaitStrategy().getClass().getSimpleName(),
            numberOfHandlers);
    }

    @Override
    public void insert(RawMessage message) {
        ringBuffer.publishEvent(RawMessageEvent.TRANSLATOR, message);
        incomingMessages.mark();
    }

    @Override
    public long getUsage() {
        return ringBuffer.getBufferSize() - ringBuffer.remainingCapacity();
    }

    private ThreadFactory threadFactory(final MetricRegistry metricRegistry) {
        final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("inputbufferprocessor-%d").build();
        return new InstrumentedThreadFactory(threadFactory, metricRegistry, name(this.getClass(), "thread-factory"));
    }

}
