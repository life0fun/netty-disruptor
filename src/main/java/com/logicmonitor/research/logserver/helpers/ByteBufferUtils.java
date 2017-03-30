package com.logicmonitor.research.logserver.helpers;

import java.nio.ByteBuffer;

public abstract class ByteBufferUtils {
    /**
     * Read the given byte buffer into a byte array
     */
    public static byte[] readBytes(ByteBuffer buffer) {
        return readBytes(buffer, 0, buffer.limit());
    }

    /**
     * Read a byte array from the given offset and size in the buffer
     */
    public static byte[] readBytes(ByteBuffer buffer, int offset, int size) {
        final byte[] dest = new byte[size];
        if (buffer.hasArray()) {
            System.arraycopy(buffer.array(), buffer.arrayOffset() + offset, dest, 0, size);
        } else {
            buffer.mark();
            buffer.get(dest);
            buffer.reset();
        }

        return dest;
    }
}
