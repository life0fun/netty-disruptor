package com.logicmonitor.research.logserver.journal;


import java.util.List;

public interface Journal {
    Entry createEntry(byte[] idBytes, byte[] messageBytes);

    long write(List<Entry> entries);

    long write(byte[] idBytes, byte[] messageBytes);

    List<JournalReadEntry> read(long maximumCount);

    void markJournalOffsetCommitted(long offset);

    class Entry {
        private final byte[] idBytes;
        private final byte[] messageBytes;

        public Entry(byte[] idBytes, byte[] messageBytes) {
            this.idBytes = idBytes;
            this.messageBytes = messageBytes;
        }

        public byte[] getIdBytes() {
            return idBytes;
        }

        public byte[] getMessageBytes() {
            return messageBytes;
        }
    }

    class JournalReadEntry {

        private final byte[] payload;
        private final long offset;

        public JournalReadEntry(byte[] payload, long offset) {
            this.payload = payload;
            this.offset = offset;
        }

        public long getOffset() {
            return offset;
        }

        public byte[] getPayload() {
            return payload;
        }
    }
}
