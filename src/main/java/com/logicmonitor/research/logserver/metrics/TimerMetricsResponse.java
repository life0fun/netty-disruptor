package com.logicmonitor.research.logserver.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimerMetricsResponse {

    public double min;
    public double max;
    public double mean;

    @JsonProperty("std_dev")
    public double stdDev;

    @JsonProperty("95th_percentile")
    public double percentile95th;

    @JsonProperty("98th_percentile")
    public double percentile98th;

    @JsonProperty("99th_percentile")
    public double percentile99th;

}