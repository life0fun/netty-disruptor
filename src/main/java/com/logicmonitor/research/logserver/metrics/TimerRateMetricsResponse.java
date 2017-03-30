package com.logicmonitor.research.logserver.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimerRateMetricsResponse {

    public TimerMetricsResponse time;
    public RateMetricsResponse rate;

    @JsonProperty("duration_unit")
    public String durationUnit;

    @JsonProperty("rate_unit")
    public String rateUnit;

}