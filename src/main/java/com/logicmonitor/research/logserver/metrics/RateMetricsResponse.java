package com.logicmonitor.research.logserver.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RateMetricsResponse {

    public double total;
    public double mean;

    @JsonProperty("one_minute")
    public double oneMinute;

    @JsonProperty("five_minute")
    public double fiveMinute;

    @JsonProperty("fifteen_minute")
    public double fifteenMinute;

}