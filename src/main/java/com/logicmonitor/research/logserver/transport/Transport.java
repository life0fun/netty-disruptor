package com.logicmonitor.research.logserver.transport;

import com.codahale.metrics.MetricSet;
import com.logicmonitor.research.logserver.codecs.CodecAggregator;
import com.logicmonitor.research.logserver.configuration.Configuration;
import com.logicmonitor.research.logserver.configuration.ConfigurationRequest;
import com.logicmonitor.research.logserver.inputs.MessageInput;
import com.logicmonitor.research.logserver.inputs.MisfireException;

public interface Transport {
    void setMessageAggregator(CodecAggregator aggregator);

    void launch(MessageInput input) throws MisfireException;

    void stop();

    MetricSet getMetricSet();

    interface Config {
        ConfigurationRequest getRequestedConfiguration();
    }

    interface Factory<T extends Transport> {
        T create(Configuration configuration);

        Config getConfig();
    }
}