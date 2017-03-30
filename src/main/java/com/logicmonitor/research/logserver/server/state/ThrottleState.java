package com.logicmonitor.research.logserver.server.state;

import com.google.common.base.MoreObjects;

public class ThrottleState {
    public long uncommittedJournalEntries;
    public long appendEventsPerSec;
    public long journalSize;
    public long journalSizeLimit;
    public long readEventsPerSec;
    public long processBufferCapacity;

    public ThrottleState() {
    }

    public ThrottleState(ThrottleState o) {
        this.uncommittedJournalEntries = o.uncommittedJournalEntries;
        this.appendEventsPerSec = o.appendEventsPerSec;
        this.journalSize = o.journalSize;
        this.journalSizeLimit = o.journalSizeLimit;
        this.readEventsPerSec = o.readEventsPerSec;
        this.processBufferCapacity = o.processBufferCapacity;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .omitNullValues()
            .add("uncommittedJournalEntries", uncommittedJournalEntries)
            .add("appendEventsPerSec", appendEventsPerSec)
            .add("readEventsPerSec", readEventsPerSec)
            .add("journalSize", journalSize)
            .add("journalSizeLimit", journalSizeLimit)
            .add("pbCapacity", processBufferCapacity)
            .toString();
    }
}
