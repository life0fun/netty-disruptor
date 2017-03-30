package com.logicmonitor.research.logserver.codecs;

import com.google.common.base.MoreObjects;
import org.jboss.netty.buffer.ChannelBuffer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface CodecAggregator {

    @Nonnull
    Result addChunk(ChannelBuffer buf);

    final class Result {
        private final ChannelBuffer message;
        private final boolean valid;

        public Result(@Nullable ChannelBuffer message, boolean valid) {
            this.message = message;
            this.valid = valid;
        }

        @Nullable
        public ChannelBuffer getMessage() {
            return message;
        }

        public boolean isValid() {
            return valid;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                .add("message", message)
                .add("valid", valid)
                .toString();
        }
    }
}