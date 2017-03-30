package com.logicmonitor.research.logserver.metrics;

import static com.codahale.metrics.MetricRegistry.name;

public final class GlobalMetricNames {

    private GlobalMetricNames() {}

    public static final String RATE_SUFFIX = "1-sec-rate";

    public static final String INPUT_THROUGHPUT = "throughput.input";

    public static final String OUTPUT_THROUGHPUT = "throughput.output";
    public static final String OUTPUT_THROUGHPUT_RATE = name(OUTPUT_THROUGHPUT, RATE_SUFFIX);

    public static final String INPUT_BUFFER_USAGE = "buffers.input.usage";
    public static final String INPUT_BUFFER_SIZE = "buffers.input.size";

    public static final String PROCESS_BUFFER_USAGE = "buffers.process.usage";
    public static final String PROCESS_BUFFER_SIZE = "buffers.process.size";

    public static final String OUTPUT_BUFFER_USAGE = "buffers.output.usage";
    public static final String OUTPUT_BUFFER_SIZE = "buffers.output.size";

    public static final String JOURNAL_APPEND_RATE = name("journal.append", RATE_SUFFIX);
    public static final String JOURNAL_READ_RATE = name("journal.read", RATE_SUFFIX);
    public static final String JOURNAL_SEGMENTS = "journal.segments";
    public static final String JOURNAL_UNCOMMITTED_ENTRIES = "journal.entries-uncommitted";
    public static final String JOURNAL_SIZE = "journal.size";
    public static final String JOURNAL_SIZE_LIMIT = "journal.size-limit";
    public static final String JOURNAL_UTILIZATION_RATIO = "journal.utilization-ratio";
    public static final String JOURNAL_OLDEST_SEGMENT = "journal.oldest-segment";

}
