package com.logicmonitor.research.logserver.codecs;


import com.logicmonitor.research.logserver.helpers.Tools;
import com.logicmonitor.research.logserver.inputs.MessageInput;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public final class ChunkMessageChunk {

    /**
     * The start byte of the sequence number
     */
    public static final int HEADER_PART_SEQNUM_START = 10;

    /**
     * The start byte of the sequence count
     */
    public static final int HEADER_PART_SEQCNT_START = 11;

    /**
     * The start byte of the message hash
     */
    public static final int HEADER_PART_HASH_START = 2;

    /**
     * The length of the message hash
     */
    public static final int HEADER_PART_HASH_LENGTH = 8;

    /**
     * The total length of the header.
     */
    public static final int HEADER_TOTAL_LENGTH = 12;

    private String id;
    private byte[] data = new byte[1];
    private int sequenceNumber = -1;
    private int sequenceCount = -1;
    private long arrival = -1L;

    private final ChannelBuffer payload;
    private final MessageInput sourceInput;

    public ChunkMessageChunk(final byte[] payload, MessageInput sourceInput) {
        if (payload.length < HEADER_TOTAL_LENGTH) {
            throw new IllegalArgumentException("This GELF message chunk is too short. Cannot even contain the required header.");
        }
        this.payload = ChannelBuffers.wrappedBuffer(payload);
        this.sourceInput = sourceInput;
        read();
    }

    public ChunkMessageChunk(final ChunkMessage msg, MessageInput sourceInput) {
        this(msg.getPayload(), sourceInput);
    }

    /**
     * The UNIX timestamp when the message chunk arrived in milliseconds.
     *
     * @return the UNIX timestamp when the message chunk arrived in milliseconds.
     * @see System#currentTimeMillis()
     */
    public long getArrival() {
        return this.arrival;
    }

    public String getId() {
        return this.id;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getSequenceCount() {
        return this.sequenceCount;
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public MessageInput getSourceInput() {
        return sourceInput;
    }

    private void read() {
        extractId();
        extractSequenceCount();
        extractSequenceNumber();
        extractData();
        this.arrival = Tools.nowUTC().getMillis();
    }

    private String extractId() {
        if (this.id == null) {
            this.id = ChannelBuffers.hexDump(payload, HEADER_PART_HASH_START, HEADER_PART_HASH_LENGTH);
        }

        return this.id;
    }

    // lol duplication
    private void extractSequenceNumber() {
        if (this.sequenceNumber == -1) {
            final int seqNum = payload.getUnsignedByte(HEADER_PART_SEQNUM_START);
            if (seqNum >= 0) {
                this.sequenceNumber = seqNum;
            } else {
                throw new IllegalStateException("Could not extract sequence number");
            }
        }
    }

    // lol duplication
    private void extractSequenceCount() {
        if (this.sequenceCount == -1) {
            final int seqCnt = payload.getUnsignedByte(HEADER_PART_SEQCNT_START);
            if (seqCnt >= 0) {
                this.sequenceCount = seqCnt;
            } else {
                throw new IllegalStateException("Could not extract sequence count");
            }
        }
    }

    private void extractData() {
        final int length = payload.readableBytes() - HEADER_TOTAL_LENGTH;
        final byte[] buf = new byte[length];

        // The rest of the payload is data.
        payload.getBytes(HEADER_TOTAL_LENGTH, buf, 0, length);

        this.data = buf;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("ID: ");
        sb.append(this.id);
        sb.append("\tSequence: ");
        sb.append(this.sequenceNumber + 1); // +1 for readability: 1/2 not 0/2
        sb.append("/");
        sb.append(this.sequenceCount);
        sb.append("\tArrival: ");
        sb.append(this.arrival);
        sb.append("\tData size: ");
        sb.append(this.payload.readableBytes());

        return sb.toString();
    }

}
