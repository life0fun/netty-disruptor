package com.logicmonitor.research.logserver.message;


import javax.annotation.Generated;

@Generated("protoc")
public final class JournalMessages {
    private JournalMessages() {}
    public static void registerAllExtensions(
        com.google.protobuf.ExtensionRegistry registry) {
    }
    public interface JournalMessageOrBuilder extends
        // @@protoc_insertion_point(interface_extends:JournalMessage)
        com.google.protobuf.MessageOrBuilder {

        /**
         * <code>optional uint32 version = 1;</code>
         */
        boolean hasVersion();
        /**
         * <code>optional uint32 version = 1;</code>
         */
        int getVersion();

        /**
         * <code>optional fixed64 uuid_time = 2;</code>
         *
         * <pre>
         * uuid, time is upper 64 bits, clockseq is lower 64 bits of the 128 bit uuid value
         * </pre>
         */
        boolean hasUuidTime();
        /**
         * <code>optional fixed64 uuid_time = 2;</code>
         *
         * <pre>
         * uuid, time is upper 64 bits, clockseq is lower 64 bits of the 128 bit uuid value
         * </pre>
         */
        long getUuidTime();

        /**
         * <code>optional fixed64 uuid_clockseq = 3;</code>
         */
        boolean hasUuidClockseq();
        /**
         * <code>optional fixed64 uuid_clockseq = 3;</code>
         */
        long getUuidClockseq();

        /**
         * <code>optional fixed64 timestamp = 4;</code>
         *
         * <pre>
         * milliseconds since Java epoch (1970/01/01 00:00:00.000)
         * </pre>
         */
        boolean hasTimestamp();
        /**
         * <code>optional fixed64 timestamp = 4;</code>
         *
         * <pre>
         * milliseconds since Java epoch (1970/01/01 00:00:00.000)
         * </pre>
         */
        long getTimestamp();

        /**
         * <code>optional .CodecInfo codec = 5;</code>
         */
        boolean hasCodec();
        /**
         * <code>optional .CodecInfo codec = 5;</code>
         */
        JournalMessages.CodecInfo getCodec();
        /**
         * <code>optional .CodecInfo codec = 5;</code>
         */
        JournalMessages.CodecInfoOrBuilder getCodecOrBuilder();

        /**
         * <code>repeated .SourceNode source_nodes = 6;</code>
         *
         * <pre>
         * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
         * </pre>
         */
        java.util.List<JournalMessages.SourceNode> getSourceNodesList();
        /**
         * <code>repeated .SourceNode source_nodes = 6;</code>
         *
         * <pre>
         * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
         * </pre>
         */
        JournalMessages.SourceNode getSourceNodes(int index);
        /**
         * <code>repeated .SourceNode source_nodes = 6;</code>
         *
         * <pre>
         * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
         * </pre>
         */
        int getSourceNodesCount();
        /**
         * <code>repeated .SourceNode source_nodes = 6;</code>
         *
         * <pre>
         * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
         * </pre>
         */
        java.util.List<? extends JournalMessages.SourceNodeOrBuilder> getSourceNodesOrBuilderList();
        /**
         * <code>repeated .SourceNode source_nodes = 6;</code>
         *
         * <pre>
         * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
         * </pre>
         */
        JournalMessages.SourceNodeOrBuilder getSourceNodesOrBuilder(int index);

        /**
         * <code>optional .RemoteAddress remote = 7;</code>
         */
        boolean hasRemote();
        /**
         * <code>optional .RemoteAddress remote = 7;</code>
         */
        JournalMessages.RemoteAddress getRemote();
        /**
         * <code>optional .RemoteAddress remote = 7;</code>
         */
        JournalMessages.RemoteAddressOrBuilder getRemoteOrBuilder();

        /**
         * <code>optional bytes payload = 8;</code>
         */
        boolean hasPayload();
        /**
         * <code>optional bytes payload = 8;</code>
         */
        com.google.protobuf.ByteString getPayload();
    }
    /**
     * Protobuf type {@code journal.JournalMessage}
     */
    public static final class JournalMessage extends
        com.google.protobuf.GeneratedMessage implements
        // @@protoc_insertion_point(message_implements:JournalMessage)
        JournalMessageOrBuilder {
        // Use JournalMessage.newBuilder() to construct.
        private JournalMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }
        private JournalMessage(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

        private static final JournalMessage defaultInstance;
        public static JournalMessage getDefaultInstance() {
            return defaultInstance;
        }

        @java.lang.Override
        public JournalMessage getDefaultInstanceForType() {
            return defaultInstance;
        }

        private final com.google.protobuf.UnknownFieldSet unknownFields;
        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private JournalMessage(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownField(input, unknownFields,
                                extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 8: {
                            bitField0_ |= 0x00000001;
                            version_ = input.readUInt32();
                            break;
                        }
                        case 17: {
                            bitField0_ |= 0x00000002;
                            uuidTime_ = input.readFixed64();
                            break;
                        }
                        case 25: {
                            bitField0_ |= 0x00000004;
                            uuidClockseq_ = input.readFixed64();
                            break;
                        }
                        case 33: {
                            bitField0_ |= 0x00000008;
                            timestamp_ = input.readFixed64();
                            break;
                        }
                        case 42: {
                            JournalMessages.CodecInfo.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                                subBuilder = codec_.toBuilder();
                            }
                            codec_ = input.readMessage(JournalMessages.CodecInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(codec_);
                                codec_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000010;
                            break;
                        }
                        case 50: {
                            if (!((mutable_bitField0_ & 0x00000020) == 0x00000020)) {
                                sourceNodes_ = new java.util.ArrayList<JournalMessages.SourceNode>();
                                mutable_bitField0_ |= 0x00000020;
                            }
                            sourceNodes_.add(input.readMessage(JournalMessages.SourceNode.PARSER, extensionRegistry));
                            break;
                        }
                        case 58: {
                            JournalMessages.RemoteAddress.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                                subBuilder = remote_.toBuilder();
                            }
                            remote_ = input.readMessage(JournalMessages.RemoteAddress.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(remote_);
                                remote_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000020;
                            break;
                        }
                        case 66: {
                            bitField0_ |= 0x00000040;
                            payload_ = input.readBytes();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                    e.getMessage()).setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000020) == 0x00000020)) {
                    sourceNodes_ = java.util.Collections.unmodifiableList(sourceNodes_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return JournalMessages.internal_static_org_graylog2_plugin_journal_JournalMessage_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return JournalMessages.internal_static_org_graylog2_plugin_journal_JournalMessage_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                    JournalMessages.JournalMessage.class, JournalMessages.JournalMessage.Builder.class);
        }

        public static com.google.protobuf.Parser<JournalMessage> PARSER =
            new com.google.protobuf.AbstractParser<JournalMessage>() {
                @java.lang.Override
                public JournalMessage parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                    return new JournalMessage(input, extensionRegistry);
                }
            };

        @java.lang.Override
        public com.google.protobuf.Parser<JournalMessage> getParserForType() {
            return PARSER;
        }

        private int bitField0_;
        public static final int VERSION_FIELD_NUMBER = 1;
        private int version_;
        /**
         * <code>optional uint32 version = 1;</code>
         */
        @java.lang.Override
        public boolean hasVersion() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /**
         * <code>optional uint32 version = 1;</code>
         */
        @java.lang.Override
        public int getVersion() {
            return version_;
        }

        public static final int UUID_TIME_FIELD_NUMBER = 2;
        private long uuidTime_;
        /**
         * <code>optional fixed64 uuid_time = 2;</code>
         *
         * <pre>
         * uuid, time is upper 64 bits, clockseq is lower 64 bits of the 128 bit uuid value
         * </pre>
         */
        @java.lang.Override
        public boolean hasUuidTime() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         * <code>optional fixed64 uuid_time = 2;</code>
         *
         * <pre>
         * uuid, time is upper 64 bits, clockseq is lower 64 bits of the 128 bit uuid value
         * </pre>
         */
        @java.lang.Override
        public long getUuidTime() {
            return uuidTime_;
        }

        public static final int UUID_CLOCKSEQ_FIELD_NUMBER = 3;
        private long uuidClockseq_;
        /**
         * <code>optional fixed64 uuid_clockseq = 3;</code>
         */
        @java.lang.Override
        public boolean hasUuidClockseq() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }
        /**
         * <code>optional fixed64 uuid_clockseq = 3;</code>
         */
        @java.lang.Override
        public long getUuidClockseq() {
            return uuidClockseq_;
        }

        public static final int TIMESTAMP_FIELD_NUMBER = 4;
        private long timestamp_;
        /**
         * <code>optional fixed64 timestamp = 4;</code>
         *
         * <pre>
         * milliseconds since Java epoch (1970/01/01 00:00:00.000)
         * </pre>
         */
        @java.lang.Override
        public boolean hasTimestamp() {
            return ((bitField0_ & 0x00000008) == 0x00000008);
        }
        /**
         * <code>optional fixed64 timestamp = 4;</code>
         *
         * <pre>
         * milliseconds since Java epoch (1970/01/01 00:00:00.000)
         * </pre>
         */
        @java.lang.Override
        public long getTimestamp() {
            return timestamp_;
        }

        public static final int CODEC_FIELD_NUMBER = 5;
        private JournalMessages.CodecInfo codec_;
        /**
         * <code>optional .CodecInfo codec = 5;</code>
         */
        @java.lang.Override
        public boolean hasCodec() {
            return ((bitField0_ & 0x00000010) == 0x00000010);
        }
        /**
         * <code>optional .CodecInfo codec = 5;</code>
         */
        @java.lang.Override
        public JournalMessages.CodecInfo getCodec() {
            return codec_;
        }
        /**
         * <code>optional .CodecInfo codec = 5;</code>
         */
        @java.lang.Override
        public JournalMessages.CodecInfoOrBuilder getCodecOrBuilder() {
            return codec_;
        }

        public static final int SOURCE_NODES_FIELD_NUMBER = 6;
        private java.util.List<JournalMessages.SourceNode> sourceNodes_;
        /**
         * <code>repeated .SourceNode source_nodes = 6;</code>
         *
         * <pre>
         * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
         * </pre>
         */
        @java.lang.Override
        public java.util.List<JournalMessages.SourceNode> getSourceNodesList() {
            return sourceNodes_;
        }
        /**
         * <code>repeated .SourceNode source_nodes = 6;</code>
         *
         * <pre>
         * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
         * </pre>
         */
        @java.lang.Override
        public java.util.List<? extends JournalMessages.SourceNodeOrBuilder>
        getSourceNodesOrBuilderList() {
            return sourceNodes_;
        }
        /**
         * <code>repeated .SourceNode source_nodes = 6;</code>
         *
         * <pre>
         * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
         * </pre>
         */
        @java.lang.Override
        public int getSourceNodesCount() {
            return sourceNodes_.size();
        }
        /**
         * <code>repeated .SourceNode source_nodes = 6;</code>
         *
         * <pre>
         * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
         * </pre>
         */
        @java.lang.Override
        public JournalMessages.SourceNode getSourceNodes(int index) {
            return sourceNodes_.get(index);
        }
        /**
         * <code>repeated .SourceNode source_nodes = 6;</code>
         *
         * <pre>
         * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
         * </pre>
         */
        @java.lang.Override
        public JournalMessages.SourceNodeOrBuilder getSourceNodesOrBuilder(
            int index) {
            return sourceNodes_.get(index);
        }

        public static final int REMOTE_FIELD_NUMBER = 7;
        private JournalMessages.RemoteAddress remote_;
        /**
         * <code>optional .RemoteAddress remote = 7;</code>
         */
        @java.lang.Override
        public boolean hasRemote() {
            return ((bitField0_ & 0x00000020) == 0x00000020);
        }
        /**
         * <code>optional .RemoteAddress remote = 7;</code>
         */
        @java.lang.Override
        public JournalMessages.RemoteAddress getRemote() {
            return remote_;
        }
        /**
         * <code>optional .RemoteAddress remote = 7;</code>
         */
        @java.lang.Override
        public JournalMessages.RemoteAddressOrBuilder getRemoteOrBuilder() {
            return remote_;
        }

        public static final int PAYLOAD_FIELD_NUMBER = 8;
        private com.google.protobuf.ByteString payload_;
        /**
         * <code>optional bytes payload = 8;</code>
         */
        @java.lang.Override
        public boolean hasPayload() {
            return ((bitField0_ & 0x00000040) == 0x00000040);
        }
        /**
         * <code>optional bytes payload = 8;</code>
         */
        @java.lang.Override
        public com.google.protobuf.ByteString getPayload() {
            return payload_;
        }

        private void initFields() {
            version_ = 0;
            uuidTime_ = 0L;
            uuidClockseq_ = 0L;
            timestamp_ = 0L;
            codec_ = JournalMessages.CodecInfo.getDefaultInstance();
            sourceNodes_ = java.util.Collections.emptyList();
            remote_ = JournalMessages.RemoteAddress.getDefaultInstance();
            payload_ = com.google.protobuf.ByteString.EMPTY;
        }
        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
            getSerializedSize();
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeUInt32(1, version_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeFixed64(2, uuidTime_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeFixed64(3, uuidClockseq_);
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                output.writeFixed64(4, timestamp_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                output.writeMessage(5, codec_);
            }
            for (int i = 0; i < sourceNodes_.size(); i++) {
                output.writeMessage(6, sourceNodes_.get(i));
            }
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                output.writeMessage(7, remote_);
            }
            if (((bitField0_ & 0x00000040) == 0x00000040)) {
                output.writeBytes(8, payload_);
            }
            getUnknownFields().writeTo(output);
        }

        private int memoizedSerializedSize = -1;
        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSerializedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(1, version_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeFixed64Size(2, uuidTime_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeFixed64Size(3, uuidClockseq_);
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeFixed64Size(4, timestamp_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(5, codec_);
            }
            for (int i = 0; i < sourceNodes_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(6, sourceNodes_.get(i));
            }
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(7, remote_);
            }
            if (((bitField0_ & 0x00000040) == 0x00000040)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(8, payload_);
            }
            size += getUnknownFields().getSerializedSize();
            memoizedSerializedSize = size;
            return size;
        }

        private static final long serialVersionUID = 0L;
        @java.lang.Override
        protected java.lang.Object writeReplace()
            throws java.io.ObjectStreamException {
            return super.writeReplace();
        }

        public static JournalMessages.JournalMessage parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static JournalMessages.JournalMessage parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static JournalMessages.JournalMessage parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static JournalMessages.JournalMessage parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static JournalMessages.JournalMessage parseFrom(java.io.InputStream input)
            throws java.io.IOException {
            return PARSER.parseFrom(input);
        }
        public static JournalMessages.JournalMessage parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }
        public static JournalMessages.JournalMessage parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input);
        }
        public static JournalMessages.JournalMessage parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }
        public static JournalMessages.JournalMessage parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
            return PARSER.parseFrom(input);
        }
        public static JournalMessages.JournalMessage parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() { return Builder.create(); }
        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder(JournalMessages.JournalMessage prototype) {
            return newBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() { return newBuilder(this); }

        @java.lang.Override
        protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code JournalMessage}
         */
        public static final class Builder extends
            com.google.protobuf.GeneratedMessage.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:JournalMessage)
            JournalMessages.JournalMessageOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_JournalMessage_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_JournalMessage_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                        JournalMessages.JournalMessage.class, JournalMessages.JournalMessage.Builder.class);
            }

            // Construct using JournalMessages.JournalMessage.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                com.google.protobuf.GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
                    getCodecFieldBuilder();
                    getSourceNodesFieldBuilder();
                    getRemoteFieldBuilder();
                }
            }
            private static Builder create() {
                return new Builder();
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                version_ = 0;
                bitField0_ = (bitField0_ & ~0x00000001);
                uuidTime_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000002);
                uuidClockseq_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000004);
                timestamp_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000008);
                if (codecBuilder_ == null) {
                    codec_ = JournalMessages.CodecInfo.getDefaultInstance();
                } else {
                    codecBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000010);
                if (sourceNodesBuilder_ == null) {
                    sourceNodes_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000020);
                } else {
                    sourceNodesBuilder_.clear();
                }
                if (remoteBuilder_ == null) {
                    remote_ = JournalMessages.RemoteAddress.getDefaultInstance();
                } else {
                    remoteBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000040);
                payload_ = com.google.protobuf.ByteString.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000080);
                return this;
            }

            @java.lang.Override
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_JournalMessage_descriptor;
            }

            @java.lang.Override
            public JournalMessages.JournalMessage getDefaultInstanceForType() {
                return JournalMessages.JournalMessage.getDefaultInstance();
            }

            @java.lang.Override
            public JournalMessages.JournalMessage build() {
                JournalMessages.JournalMessage result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public JournalMessages.JournalMessage buildPartial() {
                JournalMessages.JournalMessage result = new JournalMessages.JournalMessage(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.version_ = version_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.uuidTime_ = uuidTime_;
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.uuidClockseq_ = uuidClockseq_;
                if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
                    to_bitField0_ |= 0x00000008;
                }
                result.timestamp_ = timestamp_;
                if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
                    to_bitField0_ |= 0x00000010;
                }
                if (codecBuilder_ == null) {
                    result.codec_ = codec_;
                } else {
                    result.codec_ = codecBuilder_.build();
                }
                if (sourceNodesBuilder_ == null) {
                    if (((bitField0_ & 0x00000020) == 0x00000020)) {
                        sourceNodes_ = java.util.Collections.unmodifiableList(sourceNodes_);
                        bitField0_ = (bitField0_ & ~0x00000020);
                    }
                    result.sourceNodes_ = sourceNodes_;
                } else {
                    result.sourceNodes_ = sourceNodesBuilder_.build();
                }
                if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
                    to_bitField0_ |= 0x00000020;
                }
                if (remoteBuilder_ == null) {
                    result.remote_ = remote_;
                } else {
                    result.remote_ = remoteBuilder_.build();
                }
                if (((from_bitField0_ & 0x00000080) == 0x00000080)) {
                    to_bitField0_ |= 0x00000040;
                }
                result.payload_ = payload_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof JournalMessages.JournalMessage) {
                    return mergeFrom((JournalMessages.JournalMessage)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(JournalMessages.JournalMessage other) {
                if (other == JournalMessages.JournalMessage.getDefaultInstance()) return this;
                if (other.hasVersion()) {
                    setVersion(other.getVersion());
                }
                if (other.hasUuidTime()) {
                    setUuidTime(other.getUuidTime());
                }
                if (other.hasUuidClockseq()) {
                    setUuidClockseq(other.getUuidClockseq());
                }
                if (other.hasTimestamp()) {
                    setTimestamp(other.getTimestamp());
                }
                if (other.hasCodec()) {
                    mergeCodec(other.getCodec());
                }
                if (sourceNodesBuilder_ == null) {
                    if (!other.sourceNodes_.isEmpty()) {
                        if (sourceNodes_.isEmpty()) {
                            sourceNodes_ = other.sourceNodes_;
                            bitField0_ = (bitField0_ & ~0x00000020);
                        } else {
                            ensureSourceNodesIsMutable();
                            sourceNodes_.addAll(other.sourceNodes_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.sourceNodes_.isEmpty()) {
                        if (sourceNodesBuilder_.isEmpty()) {
                            sourceNodesBuilder_.dispose();
                            sourceNodesBuilder_ = null;
                            sourceNodes_ = other.sourceNodes_;
                            bitField0_ = (bitField0_ & ~0x00000020);
                            sourceNodesBuilder_ =
                                com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                                    getSourceNodesFieldBuilder() : null;
                        } else {
                            sourceNodesBuilder_.addAllMessages(other.sourceNodes_);
                        }
                    }
                }
                if (other.hasRemote()) {
                    mergeRemote(other.getRemote());
                }
                if (other.hasPayload()) {
                    setPayload(other.getPayload());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
                JournalMessages.JournalMessage parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (JournalMessages.JournalMessage) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private int version_ ;
            /**
             * <code>optional uint32 version = 1;</code>
             */
            @java.lang.Override
            public boolean hasVersion() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /**
             * <code>optional uint32 version = 1;</code>
             */
            @java.lang.Override
            public int getVersion() {
                return version_;
            }
            /**
             * <code>optional uint32 version = 1;</code>
             */
            public Builder setVersion(int value) {
                bitField0_ |= 0x00000001;
                version_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional uint32 version = 1;</code>
             */
            public Builder clearVersion() {
                bitField0_ = (bitField0_ & ~0x00000001);
                version_ = 0;
                onChanged();
                return this;
            }

            private long uuidTime_ ;
            /**
             * <code>optional fixed64 uuid_time = 2;</code>
             *
             * <pre>
             * uuid, time is upper 64 bits, clockseq is lower 64 bits of the 128 bit uuid value
             * </pre>
             */
            @java.lang.Override
            public boolean hasUuidTime() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /**
             * <code>optional fixed64 uuid_time = 2;</code>
             *
             * <pre>
             * uuid, time is upper 64 bits, clockseq is lower 64 bits of the 128 bit uuid value
             * </pre>
             */
            @java.lang.Override
            public long getUuidTime() {
                return uuidTime_;
            }
            /**
             * <code>optional fixed64 uuid_time = 2;</code>
             *
             * <pre>
             * uuid, time is upper 64 bits, clockseq is lower 64 bits of the 128 bit uuid value
             * </pre>
             */
            public Builder setUuidTime(long value) {
                bitField0_ |= 0x00000002;
                uuidTime_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional fixed64 uuid_time = 2;</code>
             *
             * <pre>
             * uuid, time is upper 64 bits, clockseq is lower 64 bits of the 128 bit uuid value
             * </pre>
             */
            public Builder clearUuidTime() {
                bitField0_ = (bitField0_ & ~0x00000002);
                uuidTime_ = 0L;
                onChanged();
                return this;
            }

            private long uuidClockseq_ ;
            /**
             * <code>optional fixed64 uuid_clockseq = 3;</code>
             */
            @java.lang.Override
            public boolean hasUuidClockseq() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }
            /**
             * <code>optional fixed64 uuid_clockseq = 3;</code>
             */
            @java.lang.Override
            public long getUuidClockseq() {
                return uuidClockseq_;
            }
            /**
             * <code>optional fixed64 uuid_clockseq = 3;</code>
             */
            public Builder setUuidClockseq(long value) {
                bitField0_ |= 0x00000004;
                uuidClockseq_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional fixed64 uuid_clockseq = 3;</code>
             */
            public Builder clearUuidClockseq() {
                bitField0_ = (bitField0_ & ~0x00000004);
                uuidClockseq_ = 0L;
                onChanged();
                return this;
            }

            private long timestamp_ ;
            /**
             * <code>optional fixed64 timestamp = 4;</code>
             *
             * <pre>
             * milliseconds since Java epoch (1970/01/01 00:00:00.000)
             * </pre>
             */
            @java.lang.Override
            public boolean hasTimestamp() {
                return ((bitField0_ & 0x00000008) == 0x00000008);
            }
            /**
             * <code>optional fixed64 timestamp = 4;</code>
             *
             * <pre>
             * milliseconds since Java epoch (1970/01/01 00:00:00.000)
             * </pre>
             */
            @java.lang.Override
            public long getTimestamp() {
                return timestamp_;
            }
            /**
             * <code>optional fixed64 timestamp = 4;</code>
             *
             * <pre>
             * milliseconds since Java epoch (1970/01/01 00:00:00.000)
             * </pre>
             */
            public Builder setTimestamp(long value) {
                bitField0_ |= 0x00000008;
                timestamp_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional fixed64 timestamp = 4;</code>
             *
             * <pre>
             * milliseconds since Java epoch (1970/01/01 00:00:00.000)
             * </pre>
             */
            public Builder clearTimestamp() {
                bitField0_ = (bitField0_ & ~0x00000008);
                timestamp_ = 0L;
                onChanged();
                return this;
            }

            private JournalMessages.CodecInfo codec_ = JournalMessages.CodecInfo.getDefaultInstance();
            private com.google.protobuf.SingleFieldBuilder<
                JournalMessages.CodecInfo, JournalMessages.CodecInfo.Builder, JournalMessages.CodecInfoOrBuilder> codecBuilder_;
            /**
             * <code>optional .CodecInfo codec = 5;</code>
             */
            @java.lang.Override
            public boolean hasCodec() {
                return ((bitField0_ & 0x00000010) == 0x00000010);
            }
            /**
             * <code>optional .CodecInfo codec = 5;</code>
             */
            @java.lang.Override
            public JournalMessages.CodecInfo getCodec() {
                if (codecBuilder_ == null) {
                    return codec_;
                } else {
                    return codecBuilder_.getMessage();
                }
            }
            /**
             * <code>optional .CodecInfo codec = 5;</code>
             */
            public Builder setCodec(JournalMessages.CodecInfo value) {
                if (codecBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    codec_ = value;
                    onChanged();
                } else {
                    codecBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000010;
                return this;
            }
            /**
             * <code>optional .CodecInfo codec = 5;</code>
             */
            public Builder setCodec(
                JournalMessages.CodecInfo.Builder builderForValue) {
                if (codecBuilder_ == null) {
                    codec_ = builderForValue.build();
                    onChanged();
                } else {
                    codecBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000010;
                return this;
            }
            /**
             * <code>optional .CodecInfo codec = 5;</code>
             */
            public Builder mergeCodec(JournalMessages.CodecInfo value) {
                if (codecBuilder_ == null) {
                    if (((bitField0_ & 0x00000010) == 0x00000010) &&
                        codec_ != JournalMessages.CodecInfo.getDefaultInstance()) {
                        codec_ =
                            JournalMessages.CodecInfo.newBuilder(codec_).mergeFrom(value).buildPartial();
                    } else {
                        codec_ = value;
                    }
                    onChanged();
                } else {
                    codecBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000010;
                return this;
            }
            /**
             * <code>optional .CodecInfo codec = 5;</code>
             */
            public Builder clearCodec() {
                if (codecBuilder_ == null) {
                    codec_ = JournalMessages.CodecInfo.getDefaultInstance();
                    onChanged();
                } else {
                    codecBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000010);
                return this;
            }
            /**
             * <code>optional .CodecInfo codec = 5;</code>
             */
            public JournalMessages.CodecInfo.Builder getCodecBuilder() {
                bitField0_ |= 0x00000010;
                onChanged();
                return getCodecFieldBuilder().getBuilder();
            }
            /**
             * <code>optional .CodecInfo codec = 5;</code>
             */
            @java.lang.Override
            public JournalMessages.CodecInfoOrBuilder getCodecOrBuilder() {
                if (codecBuilder_ != null) {
                    return codecBuilder_.getMessageOrBuilder();
                } else {
                    return codec_;
                }
            }
            /**
             * <code>optional .CodecInfo codec = 5;</code>
             */
            private com.google.protobuf.SingleFieldBuilder<
                JournalMessages.CodecInfo, JournalMessages.CodecInfo.Builder, JournalMessages.CodecInfoOrBuilder>
            getCodecFieldBuilder() {
                if (codecBuilder_ == null) {
                    codecBuilder_ = new com.google.protobuf.SingleFieldBuilder<
                        JournalMessages.CodecInfo, JournalMessages.CodecInfo.Builder, JournalMessages.CodecInfoOrBuilder>(
                        getCodec(),
                        getParentForChildren(),
                        isClean());
                    codec_ = null;
                }
                return codecBuilder_;
            }

            private java.util.List<JournalMessages.SourceNode> sourceNodes_ =
                java.util.Collections.emptyList();
            private void ensureSourceNodesIsMutable() {
                if (!((bitField0_ & 0x00000020) == 0x00000020)) {
                    sourceNodes_ = new java.util.ArrayList<JournalMessages.SourceNode>(sourceNodes_);
                    bitField0_ |= 0x00000020;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilder<
                JournalMessages.SourceNode, JournalMessages.SourceNode.Builder, JournalMessages.SourceNodeOrBuilder> sourceNodesBuilder_;

            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            @java.lang.Override
            public java.util.List<JournalMessages.SourceNode> getSourceNodesList() {
                if (sourceNodesBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(sourceNodes_);
                } else {
                    return sourceNodesBuilder_.getMessageList();
                }
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            @java.lang.Override
            public int getSourceNodesCount() {
                if (sourceNodesBuilder_ == null) {
                    return sourceNodes_.size();
                } else {
                    return sourceNodesBuilder_.getCount();
                }
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            @java.lang.Override
            public JournalMessages.SourceNode getSourceNodes(int index) {
                if (sourceNodesBuilder_ == null) {
                    return sourceNodes_.get(index);
                } else {
                    return sourceNodesBuilder_.getMessage(index);
                }
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public Builder setSourceNodes(
                int index, JournalMessages.SourceNode value) {
                if (sourceNodesBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSourceNodesIsMutable();
                    sourceNodes_.set(index, value);
                    onChanged();
                } else {
                    sourceNodesBuilder_.setMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public Builder setSourceNodes(
                int index, JournalMessages.SourceNode.Builder builderForValue) {
                if (sourceNodesBuilder_ == null) {
                    ensureSourceNodesIsMutable();
                    sourceNodes_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    sourceNodesBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public Builder addSourceNodes(JournalMessages.SourceNode value) {
                if (sourceNodesBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSourceNodesIsMutable();
                    sourceNodes_.add(value);
                    onChanged();
                } else {
                    sourceNodesBuilder_.addMessage(value);
                }
                return this;
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public Builder addSourceNodes(
                int index, JournalMessages.SourceNode value) {
                if (sourceNodesBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSourceNodesIsMutable();
                    sourceNodes_.add(index, value);
                    onChanged();
                } else {
                    sourceNodesBuilder_.addMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public Builder addSourceNodes(
                JournalMessages.SourceNode.Builder builderForValue) {
                if (sourceNodesBuilder_ == null) {
                    ensureSourceNodesIsMutable();
                    sourceNodes_.add(builderForValue.build());
                    onChanged();
                } else {
                    sourceNodesBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public Builder addSourceNodes(
                int index, JournalMessages.SourceNode.Builder builderForValue) {
                if (sourceNodesBuilder_ == null) {
                    ensureSourceNodesIsMutable();
                    sourceNodes_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    sourceNodesBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public Builder addAllSourceNodes(
                java.lang.Iterable<? extends JournalMessages.SourceNode> values) {
                if (sourceNodesBuilder_ == null) {
                    ensureSourceNodesIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                        values, sourceNodes_);
                    onChanged();
                } else {
                    sourceNodesBuilder_.addAllMessages(values);
                }
                return this;
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public Builder clearSourceNodes() {
                if (sourceNodesBuilder_ == null) {
                    sourceNodes_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000020);
                    onChanged();
                } else {
                    sourceNodesBuilder_.clear();
                }
                return this;
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public Builder removeSourceNodes(int index) {
                if (sourceNodesBuilder_ == null) {
                    ensureSourceNodesIsMutable();
                    sourceNodes_.remove(index);
                    onChanged();
                } else {
                    sourceNodesBuilder_.remove(index);
                }
                return this;
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public JournalMessages.SourceNode.Builder getSourceNodesBuilder(
                int index) {
                return getSourceNodesFieldBuilder().getBuilder(index);
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            @java.lang.Override
            public JournalMessages.SourceNodeOrBuilder getSourceNodesOrBuilder(
                int index) {
                if (sourceNodesBuilder_ == null) {
                    return sourceNodes_.get(index);  } else {
                    return sourceNodesBuilder_.getMessageOrBuilder(index);
                }
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            @java.lang.Override
            public java.util.List<? extends JournalMessages.SourceNodeOrBuilder>
            getSourceNodesOrBuilderList() {
                if (sourceNodesBuilder_ != null) {
                    return sourceNodesBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(sourceNodes_);
                }
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public JournalMessages.SourceNode.Builder addSourceNodesBuilder() {
                return getSourceNodesFieldBuilder().addBuilder(
                    JournalMessages.SourceNode.getDefaultInstance());
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public JournalMessages.SourceNode.Builder addSourceNodesBuilder(
                int index) {
                return getSourceNodesFieldBuilder().addBuilder(
                    index, JournalMessages.SourceNode.getDefaultInstance());
            }
            /**
             * <code>repeated .SourceNode source_nodes = 6;</code>
             *
             * <pre>
             * the list of graylog2 nodes which have handled the message (radios, servers) in receive order
             * </pre>
             */
            public java.util.List<JournalMessages.SourceNode.Builder>
            getSourceNodesBuilderList() {
                return getSourceNodesFieldBuilder().getBuilderList();
            }
            private com.google.protobuf.RepeatedFieldBuilder<
                JournalMessages.SourceNode, JournalMessages.SourceNode.Builder, JournalMessages.SourceNodeOrBuilder>
            getSourceNodesFieldBuilder() {
                if (sourceNodesBuilder_ == null) {
                    sourceNodesBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
                        JournalMessages.SourceNode, JournalMessages.SourceNode.Builder, JournalMessages.SourceNodeOrBuilder>(
                        sourceNodes_,
                        ((bitField0_ & 0x00000020) == 0x00000020),
                        getParentForChildren(),
                        isClean());
                    sourceNodes_ = null;
                }
                return sourceNodesBuilder_;
            }

            private JournalMessages.RemoteAddress remote_ = JournalMessages.RemoteAddress.getDefaultInstance();
            private com.google.protobuf.SingleFieldBuilder<
                JournalMessages.RemoteAddress, JournalMessages.RemoteAddress.Builder, JournalMessages.RemoteAddressOrBuilder> remoteBuilder_;
            /**
             * <code>optional .RemoteAddress remote = 7;</code>
             */
            @java.lang.Override
            public boolean hasRemote() {
                return ((bitField0_ & 0x00000040) == 0x00000040);
            }
            /**
             * <code>optional .RemoteAddress remote = 7;</code>
             */
            @java.lang.Override
            public JournalMessages.RemoteAddress getRemote() {
                if (remoteBuilder_ == null) {
                    return remote_;
                } else {
                    return remoteBuilder_.getMessage();
                }
            }
            /**
             * <code>optional .RemoteAddress remote = 7;</code>
             */
            public Builder setRemote(JournalMessages.RemoteAddress value) {
                if (remoteBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    remote_ = value;
                    onChanged();
                } else {
                    remoteBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000040;
                return this;
            }
            /**
             * <code>optional .RemoteAddress remote = 7;</code>
             */
            public Builder setRemote(
                JournalMessages.RemoteAddress.Builder builderForValue) {
                if (remoteBuilder_ == null) {
                    remote_ = builderForValue.build();
                    onChanged();
                } else {
                    remoteBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000040;
                return this;
            }
            /**
             * <code>optional .RemoteAddress remote = 7;</code>
             */
            public Builder mergeRemote(JournalMessages.RemoteAddress value) {
                if (remoteBuilder_ == null) {
                    if (((bitField0_ & 0x00000040) == 0x00000040) &&
                        remote_ != JournalMessages.RemoteAddress.getDefaultInstance()) {
                        remote_ =
                            JournalMessages.RemoteAddress.newBuilder(remote_).mergeFrom(value).buildPartial();
                    } else {
                        remote_ = value;
                    }
                    onChanged();
                } else {
                    remoteBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000040;
                return this;
            }
            /**
             * <code>optional .RemoteAddress remote = 7;</code>
             */
            public Builder clearRemote() {
                if (remoteBuilder_ == null) {
                    remote_ = JournalMessages.RemoteAddress.getDefaultInstance();
                    onChanged();
                } else {
                    remoteBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000040);
                return this;
            }
            /**
             * <code>optional .RemoteAddress remote = 7;</code>
             */
            public JournalMessages.RemoteAddress.Builder getRemoteBuilder() {
                bitField0_ |= 0x00000040;
                onChanged();
                return getRemoteFieldBuilder().getBuilder();
            }
            /**
             * <code>optional .RemoteAddress remote = 7;</code>
             */
            @java.lang.Override
            public JournalMessages.RemoteAddressOrBuilder getRemoteOrBuilder() {
                if (remoteBuilder_ != null) {
                    return remoteBuilder_.getMessageOrBuilder();
                } else {
                    return remote_;
                }
            }
            /**
             * <code>optional .RemoteAddress remote = 7;</code>
             */
            private com.google.protobuf.SingleFieldBuilder<
                JournalMessages.RemoteAddress, JournalMessages.RemoteAddress.Builder, JournalMessages.RemoteAddressOrBuilder>
            getRemoteFieldBuilder() {
                if (remoteBuilder_ == null) {
                    remoteBuilder_ = new com.google.protobuf.SingleFieldBuilder<
                        JournalMessages.RemoteAddress, JournalMessages.RemoteAddress.Builder, JournalMessages.RemoteAddressOrBuilder>(
                        getRemote(),
                        getParentForChildren(),
                        isClean());
                    remote_ = null;
                }
                return remoteBuilder_;
            }

            private com.google.protobuf.ByteString payload_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>optional bytes payload = 8;</code>
             */
            @java.lang.Override
            public boolean hasPayload() {
                return ((bitField0_ & 0x00000080) == 0x00000080);
            }
            /**
             * <code>optional bytes payload = 8;</code>
             */
            @java.lang.Override
            public com.google.protobuf.ByteString getPayload() {
                return payload_;
            }
            /**
             * <code>optional bytes payload = 8;</code>
             */
            public Builder setPayload(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000080;
                payload_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional bytes payload = 8;</code>
             */
            public Builder clearPayload() {
                bitField0_ = (bitField0_ & ~0x00000080);
                payload_ = getDefaultInstance().getPayload();
                onChanged();
                return this;
            }

            // @@protoc_insertion_point(builder_scope:JournalMessage)
        }

        static {
            defaultInstance = new JournalMessage(true);
            defaultInstance.initFields();
        }

        // @@protoc_insertion_point(class_scope:JournalMessage)
    }

    public interface RemoteAddressOrBuilder extends
        // @@protoc_insertion_point(interface_extends:RemoteAddress)
        com.google.protobuf.MessageOrBuilder {

        /**
         * <code>optional bytes address = 1;</code>
         *
         * <pre>
         * the original remote (IP) address of the message sender, unresolved
         * </pre>
         */
        boolean hasAddress();
        /**
         * <code>optional bytes address = 1;</code>
         *
         * <pre>
         * the original remote (IP) address of the message sender, unresolved
         * </pre>
         */
        com.google.protobuf.ByteString getAddress();

        /**
         * <code>optional uint32 port = 2;</code>
         *
         * <pre>
         * the port of the sender, if available/applicable
         * </pre>
         */
        boolean hasPort();
        /**
         * <code>optional uint32 port = 2;</code>
         *
         * <pre>
         * the port of the sender, if available/applicable
         * </pre>
         */
        int getPort();

        /**
         * <code>optional string resolved = 3;</code>
         *
         * <pre>
         * a processing node can optionally resolve the address early
         * </pre>
         */
        boolean hasResolved();
        /**
         * <code>optional string resolved = 3;</code>
         *
         * <pre>
         * a processing node can optionally resolve the address early
         * </pre>
         */
        java.lang.String getResolved();
        /**
         * <code>optional string resolved = 3;</code>
         *
         * <pre>
         * a processing node can optionally resolve the address early
         * </pre>
         */
        com.google.protobuf.ByteString
        getResolvedBytes();
    }
    /**
     * Protobuf type {@code RemoteAddress}
     */
    public static final class RemoteAddress extends
        com.google.protobuf.GeneratedMessage implements
        // @@protoc_insertion_point(message_implements:RemoteAddress)
        RemoteAddressOrBuilder {
        // Use RemoteAddress.newBuilder() to construct.
        private RemoteAddress(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }
        private RemoteAddress(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

        private static final RemoteAddress defaultInstance;
        public static RemoteAddress getDefaultInstance() {
            return defaultInstance;
        }

        @java.lang.Override
        public RemoteAddress getDefaultInstanceForType() {
            return defaultInstance;
        }

        private final com.google.protobuf.UnknownFieldSet unknownFields;
        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private RemoteAddress(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownField(input, unknownFields,
                                extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {
                            bitField0_ |= 0x00000001;
                            address_ = input.readBytes();
                            break;
                        }
                        case 16: {
                            bitField0_ |= 0x00000002;
                            port_ = input.readUInt32();
                            break;
                        }
                        case 26: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000004;
                            resolved_ = bs;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                    e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return JournalMessages.internal_static_org_graylog2_plugin_journal_RemoteAddress_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return JournalMessages.internal_static_org_graylog2_plugin_journal_RemoteAddress_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                    JournalMessages.RemoteAddress.class, JournalMessages.RemoteAddress.Builder.class);
        }

        public static com.google.protobuf.Parser<RemoteAddress> PARSER =
            new com.google.protobuf.AbstractParser<RemoteAddress>() {
                @java.lang.Override
                public RemoteAddress parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                    return new RemoteAddress(input, extensionRegistry);
                }
            };

        @java.lang.Override
        public com.google.protobuf.Parser<RemoteAddress> getParserForType() {
            return PARSER;
        }

        private int bitField0_;
        public static final int ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString address_;
        /**
         * <code>optional bytes address = 1;</code>
         *
         * <pre>
         * the original remote (IP) address of the message sender, unresolved
         * </pre>
         */
        @java.lang.Override
        public boolean hasAddress() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /**
         * <code>optional bytes address = 1;</code>
         *
         * <pre>
         * the original remote (IP) address of the message sender, unresolved
         * </pre>
         */
        @java.lang.Override
        public com.google.protobuf.ByteString getAddress() {
            return address_;
        }

        public static final int PORT_FIELD_NUMBER = 2;
        private int port_;
        /**
         * <code>optional uint32 port = 2;</code>
         *
         * <pre>
         * the port of the sender, if available/applicable
         * </pre>
         */
        @java.lang.Override
        public boolean hasPort() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         * <code>optional uint32 port = 2;</code>
         *
         * <pre>
         * the port of the sender, if available/applicable
         * </pre>
         */
        @java.lang.Override
        public int getPort() {
            return port_;
        }

        public static final int RESOLVED_FIELD_NUMBER = 3;
        private java.lang.Object resolved_;
        /**
         * <code>optional string resolved = 3;</code>
         *
         * <pre>
         * a processing node can optionally resolve the address early
         * </pre>
         */
        @java.lang.Override
        public boolean hasResolved() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }
        /**
         * <code>optional string resolved = 3;</code>
         *
         * <pre>
         * a processing node can optionally resolve the address early
         * </pre>
         */
        @java.lang.Override
        public java.lang.String getResolved() {
            java.lang.Object ref = resolved_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    resolved_ = s;
                }
                return s;
            }
        }
        /**
         * <code>optional string resolved = 3;</code>
         *
         * <pre>
         * a processing node can optionally resolve the address early
         * </pre>
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getResolvedBytes() {
            java.lang.Object ref = resolved_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                resolved_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private void initFields() {
            address_ = com.google.protobuf.ByteString.EMPTY;
            port_ = 0;
            resolved_ = "";
        }
        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
            getSerializedSize();
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeBytes(1, address_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeUInt32(2, port_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeBytes(3, getResolvedBytes());
            }
            getUnknownFields().writeTo(output);
        }

        private int memoizedSerializedSize = -1;
        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSerializedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(1, address_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(2, port_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(3, getResolvedBytes());
            }
            size += getUnknownFields().getSerializedSize();
            memoizedSerializedSize = size;
            return size;
        }

        private static final long serialVersionUID = 0L;
        @java.lang.Override
        protected java.lang.Object writeReplace()
            throws java.io.ObjectStreamException {
            return super.writeReplace();
        }

        public static JournalMessages.RemoteAddress parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static JournalMessages.RemoteAddress parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static JournalMessages.RemoteAddress parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static JournalMessages.RemoteAddress parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static JournalMessages.RemoteAddress parseFrom(java.io.InputStream input)
            throws java.io.IOException {
            return PARSER.parseFrom(input);
        }
        public static JournalMessages.RemoteAddress parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }
        public static JournalMessages.RemoteAddress parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input);
        }
        public static JournalMessages.RemoteAddress parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }
        public static JournalMessages.RemoteAddress parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
            return PARSER.parseFrom(input);
        }
        public static JournalMessages.RemoteAddress parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() { return Builder.create(); }
        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder(JournalMessages.RemoteAddress prototype) {
            return newBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() { return newBuilder(this); }

        @java.lang.Override
        protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code RemoteAddress}
         */
        public static final class Builder extends
            com.google.protobuf.GeneratedMessage.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:RemoteAddress)
            JournalMessages.RemoteAddressOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_RemoteAddress_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_RemoteAddress_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                        JournalMessages.RemoteAddress.class, JournalMessages.RemoteAddress.Builder.class);
            }

            // Construct using JournalMessages.RemoteAddress.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                com.google.protobuf.GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
                }
            }
            private static Builder create() {
                return new Builder();
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                address_ = com.google.protobuf.ByteString.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000001);
                port_ = 0;
                bitField0_ = (bitField0_ & ~0x00000002);
                resolved_ = "";
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            @java.lang.Override
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_RemoteAddress_descriptor;
            }

            @java.lang.Override
            public JournalMessages.RemoteAddress getDefaultInstanceForType() {
                return JournalMessages.RemoteAddress.getDefaultInstance();
            }

            @java.lang.Override
            public JournalMessages.RemoteAddress build() {
                JournalMessages.RemoteAddress result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public JournalMessages.RemoteAddress buildPartial() {
                JournalMessages.RemoteAddress result = new JournalMessages.RemoteAddress(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.address_ = address_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.port_ = port_;
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.resolved_ = resolved_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof JournalMessages.RemoteAddress) {
                    return mergeFrom((JournalMessages.RemoteAddress)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(JournalMessages.RemoteAddress other) {
                if (other == JournalMessages.RemoteAddress.getDefaultInstance()) return this;
                if (other.hasAddress()) {
                    setAddress(other.getAddress());
                }
                if (other.hasPort()) {
                    setPort(other.getPort());
                }
                if (other.hasResolved()) {
                    bitField0_ |= 0x00000004;
                    resolved_ = other.resolved_;
                    onChanged();
                }
                this.mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
                JournalMessages.RemoteAddress parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (JournalMessages.RemoteAddress) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private com.google.protobuf.ByteString address_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>optional bytes address = 1;</code>
             *
             * <pre>
             * the original remote (IP) address of the message sender, unresolved
             * </pre>
             */
//            @java.lang.Override
            public boolean hasAddress() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /**
             * <code>optional bytes address = 1;</code>
             *
             * <pre>
             * the original remote (IP) address of the message sender, unresolved
             * </pre>
             */
//            @java.lang.Override
            public com.google.protobuf.ByteString getAddress() {
                return address_;
            }
            /**
             * <code>optional bytes address = 1;</code>
             *
             * <pre>
             * the original remote (IP) address of the message sender, unresolved
             * </pre>
             */
            public Builder setAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                address_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional bytes address = 1;</code>
             *
             * <pre>
             * the original remote (IP) address of the message sender, unresolved
             * </pre>
             */
            public Builder clearAddress() {
                bitField0_ = (bitField0_ & ~0x00000001);
                address_ = getDefaultInstance().getAddress();
                onChanged();
                return this;
            }

            private int port_ ;
            /**
             * <code>optional uint32 port = 2;</code>
             *
             * <pre>
             * the port of the sender, if available/applicable
             * </pre>
             */
            @java.lang.Override
            public boolean hasPort() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /**
             * <code>optional uint32 port = 2;</code>
             *
             * <pre>
             * the port of the sender, if available/applicable
             * </pre>
             */
            @java.lang.Override
            public int getPort() {
                return port_;
            }
            /**
             * <code>optional uint32 port = 2;</code>
             *
             * <pre>
             * the port of the sender, if available/applicable
             * </pre>
             */
            public Builder setPort(int value) {
                bitField0_ |= 0x00000002;
                port_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional uint32 port = 2;</code>
             *
             * <pre>
             * the port of the sender, if available/applicable
             * </pre>
             */
            public Builder clearPort() {
                bitField0_ = (bitField0_ & ~0x00000002);
                port_ = 0;
                onChanged();
                return this;
            }

            private java.lang.Object resolved_ = "";
            /**
             * <code>optional string resolved = 3;</code>
             *
             * <pre>
             * a processing node can optionally resolve the address early
             * </pre>
             */
            @java.lang.Override
            public boolean hasResolved() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }
            /**
             * <code>optional string resolved = 3;</code>
             *
             * <pre>
             * a processing node can optionally resolve the address early
             * </pre>
             */
            @java.lang.Override
            public java.lang.String getResolved() {
                java.lang.Object ref = resolved_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        resolved_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>optional string resolved = 3;</code>
             *
             * <pre>
             * a processing node can optionally resolve the address early
             * </pre>
             */
            @java.lang.Override
            public com.google.protobuf.ByteString
            getResolvedBytes() {
                java.lang.Object ref = resolved_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
                    resolved_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>optional string resolved = 3;</code>
             *
             * <pre>
             * a processing node can optionally resolve the address early
             * </pre>
             */
            public Builder setResolved(
                java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                resolved_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional string resolved = 3;</code>
             *
             * <pre>
             * a processing node can optionally resolve the address early
             * </pre>
             */
            public Builder clearResolved() {
                bitField0_ = (bitField0_ & ~0x00000004);
                resolved_ = getDefaultInstance().getResolved();
                onChanged();
                return this;
            }
            /**
             * <code>optional string resolved = 3;</code>
             *
             * <pre>
             * a processing node can optionally resolve the address early
             * </pre>
             */
            public Builder setResolvedBytes(
                com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                resolved_ = value;
                onChanged();
                return this;
            }

            // @@protoc_insertion_point(builder_scope:RemoteAddress)
        }

        static {
            defaultInstance = new RemoteAddress(true);
            defaultInstance.initFields();
        }

        // @@protoc_insertion_point(class_scope:RemoteAddress)
    }

    public interface CodecInfoOrBuilder extends
        // @@protoc_insertion_point(interface_extends:CodecInfo)
        com.google.protobuf.MessageOrBuilder {

        /**
         * <code>optional string name = 1;</code>
         */
        boolean hasName();
        /**
         * <code>optional string name = 1;</code>
         */
        java.lang.String getName();
        /**
         * <code>optional string name = 1;</code>
         */
        com.google.protobuf.ByteString
        getNameBytes();

        /**
         * <code>optional string config = 2;</code>
         *
         * <pre>
         * JSON description of configuration settings necessary to create the codec with
         * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
         * </pre>
         */
        boolean hasConfig();
        /**
         * <code>optional string config = 2;</code>
         *
         * <pre>
         * JSON description of configuration settings necessary to create the codec with
         * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
         * </pre>
         */
        java.lang.String getConfig();
        /**
         * <code>optional string config = 2;</code>
         *
         * <pre>
         * JSON description of configuration settings necessary to create the codec with
         * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
         * </pre>
         */
        com.google.protobuf.ByteString
        getConfigBytes();
    }
    /**
     * Protobuf type {@code CodecInfo}
     */
    public static final class CodecInfo extends
        com.google.protobuf.GeneratedMessage implements
        // @@protoc_insertion_point(message_implements:CodecInfo)
        CodecInfoOrBuilder {
        // Use CodecInfo.newBuilder() to construct.
        private CodecInfo(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }
        private CodecInfo(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

        private static final CodecInfo defaultInstance;
        public static CodecInfo getDefaultInstance() {
            return defaultInstance;
        }

        @java.lang.Override
        public CodecInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        private final com.google.protobuf.UnknownFieldSet unknownFields;
        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private CodecInfo(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownField(input, unknownFields,
                                extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            name_ = bs;
                            break;
                        }
                        case 18: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000002;
                            config_ = bs;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                    e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return JournalMessages.internal_static_org_graylog2_plugin_journal_CodecInfo_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return JournalMessages.internal_static_org_graylog2_plugin_journal_CodecInfo_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                    JournalMessages.CodecInfo.class, JournalMessages.CodecInfo.Builder.class);
        }

        public static com.google.protobuf.Parser<CodecInfo> PARSER =
            new com.google.protobuf.AbstractParser<CodecInfo>() {
                @java.lang.Override
                public CodecInfo parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                    return new CodecInfo(input, extensionRegistry);
                }
            };

        @java.lang.Override
        public com.google.protobuf.Parser<CodecInfo> getParserForType() {
            return PARSER;
        }

        private int bitField0_;
        public static final int NAME_FIELD_NUMBER = 1;
        private java.lang.Object name_;
        /**
         * <code>optional string name = 1;</code>
         */
        @java.lang.Override
        public boolean hasName() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /**
         * <code>optional string name = 1;</code>
         */
        @java.lang.Override
        public java.lang.String getName() {
            java.lang.Object ref = name_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    name_ = s;
                }
                return s;
            }
        }
        /**
         * <code>optional string name = 1;</code>
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getNameBytes() {
            java.lang.Object ref = name_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                name_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int CONFIG_FIELD_NUMBER = 2;
        private java.lang.Object config_;
        /**
         * <code>optional string config = 2;</code>
         *
         * <pre>
         * JSON description of configuration settings necessary to create the codec with
         * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
         * </pre>
         */
        @java.lang.Override
        public boolean hasConfig() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         * <code>optional string config = 2;</code>
         *
         * <pre>
         * JSON description of configuration settings necessary to create the codec with
         * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
         * </pre>
         */
        @java.lang.Override
        public java.lang.String getConfig() {
            java.lang.Object ref = config_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    config_ = s;
                }
                return s;
            }
        }
        /**
         * <code>optional string config = 2;</code>
         *
         * <pre>
         * JSON description of configuration settings necessary to create the codec with
         * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
         * </pre>
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getConfigBytes() {
            java.lang.Object ref = config_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                config_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private void initFields() {
            name_ = "";
            config_ = "";
        }
        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
            getSerializedSize();
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeBytes(1, getNameBytes());
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeBytes(2, getConfigBytes());
            }
            getUnknownFields().writeTo(output);
        }

        private int memoizedSerializedSize = -1;
        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSerializedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(1, getNameBytes());
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(2, getConfigBytes());
            }
            size += getUnknownFields().getSerializedSize();
            memoizedSerializedSize = size;
            return size;
        }

        private static final long serialVersionUID = 0L;
        @java.lang.Override
        protected java.lang.Object writeReplace()
            throws java.io.ObjectStreamException {
            return super.writeReplace();
        }

        public static JournalMessages.CodecInfo parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static JournalMessages.CodecInfo parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static JournalMessages.CodecInfo parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static JournalMessages.CodecInfo parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static JournalMessages.CodecInfo parseFrom(java.io.InputStream input)
            throws java.io.IOException {
            return PARSER.parseFrom(input);
        }
        public static JournalMessages.CodecInfo parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }
        public static JournalMessages.CodecInfo parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input);
        }
        public static JournalMessages.CodecInfo parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }
        public static JournalMessages.CodecInfo parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
            return PARSER.parseFrom(input);
        }
        public static JournalMessages.CodecInfo parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() { return Builder.create(); }
        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder(JournalMessages.CodecInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() { return newBuilder(this); }

        @java.lang.Override
        protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code CodecInfo}
         */
        public static final class Builder extends
            com.google.protobuf.GeneratedMessage.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:CodecInfo)
            JournalMessages.CodecInfoOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_CodecInfo_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_CodecInfo_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                        JournalMessages.CodecInfo.class, JournalMessages.CodecInfo.Builder.class);
            }

            // Construct using JournalMessages.CodecInfo.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                com.google.protobuf.GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
                }
            }
            private static Builder create() {
                return new Builder();
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                name_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                config_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            @java.lang.Override
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_CodecInfo_descriptor;
            }

            @java.lang.Override
            public JournalMessages.CodecInfo getDefaultInstanceForType() {
                return JournalMessages.CodecInfo.getDefaultInstance();
            }

            @java.lang.Override
            public JournalMessages.CodecInfo build() {
                JournalMessages.CodecInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public JournalMessages.CodecInfo buildPartial() {
                JournalMessages.CodecInfo result = new JournalMessages.CodecInfo(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.name_ = name_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.config_ = config_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof JournalMessages.CodecInfo) {
                    return mergeFrom((JournalMessages.CodecInfo)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(JournalMessages.CodecInfo other) {
                if (other == JournalMessages.CodecInfo.getDefaultInstance()) return this;
                if (other.hasName()) {
                    bitField0_ |= 0x00000001;
                    name_ = other.name_;
                    onChanged();
                }
                if (other.hasConfig()) {
                    bitField0_ |= 0x00000002;
                    config_ = other.config_;
                    onChanged();
                }
                this.mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
                JournalMessages.CodecInfo parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (JournalMessages.CodecInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private java.lang.Object name_ = "";
            /**
             * <code>optional string name = 1;</code>
             */
            @java.lang.Override
            public boolean hasName() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /**
             * <code>optional string name = 1;</code>
             */
            @java.lang.Override
            public java.lang.String getName() {
                java.lang.Object ref = name_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        name_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>optional string name = 1;</code>
             */
            @java.lang.Override
            public com.google.protobuf.ByteString
            getNameBytes() {
                java.lang.Object ref = name_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
                    name_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>optional string name = 1;</code>
             */
            public Builder setName(
                java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                name_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional string name = 1;</code>
             */
            public Builder clearName() {
                bitField0_ = (bitField0_ & ~0x00000001);
                name_ = getDefaultInstance().getName();
                onChanged();
                return this;
            }
            /**
             * <code>optional string name = 1;</code>
             */
            public Builder setNameBytes(
                com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                name_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object config_ = "";
            /**
             * <code>optional string config = 2;</code>
             *
             * <pre>
             * JSON description of configuration settings necessary to create the codec with
             * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
             * </pre>
             */
            @java.lang.Override
            public boolean hasConfig() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /**
             * <code>optional string config = 2;</code>
             *
             * <pre>
             * JSON description of configuration settings necessary to create the codec with
             * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
             * </pre>
             */
            @java.lang.Override
            public java.lang.String getConfig() {
                java.lang.Object ref = config_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        config_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>optional string config = 2;</code>
             *
             * <pre>
             * JSON description of configuration settings necessary to create the codec with
             * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
             * </pre>
             */
            @java.lang.Override
            public com.google.protobuf.ByteString
            getConfigBytes() {
                java.lang.Object ref = config_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
                    config_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>optional string config = 2;</code>
             *
             * <pre>
             * JSON description of configuration settings necessary to create the codec with
             * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
             * </pre>
             */
            public Builder setConfig(
                java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                config_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional string config = 2;</code>
             *
             * <pre>
             * JSON description of configuration settings necessary to create the codec with
             * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
             * </pre>
             */
            public Builder clearConfig() {
                bitField0_ = (bitField0_ & ~0x00000002);
                config_ = getDefaultInstance().getConfig();
                onChanged();
                return this;
            }
            /**
             * <code>optional string config = 2;</code>
             *
             * <pre>
             * JSON description of configuration settings necessary to create the codec with
             * for optimal performance make sure the serialization is stable, i.e. same config == same serialization bytes
             * </pre>
             */
            public Builder setConfigBytes(
                com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                config_ = value;
                onChanged();
                return this;
            }

            // @@protoc_insertion_point(builder_scope:CodecInfo)
        }

        static {
            defaultInstance = new CodecInfo(true);
            defaultInstance.initFields();
        }

        // @@protoc_insertion_point(class_scope:CodecInfo)
    }

    public interface SourceNodeOrBuilder extends
        // @@protoc_insertion_point(interface_extends:SourceNode)
        com.google.protobuf.MessageOrBuilder {

        /**
         * <code>optional string id = 1;</code>
         */
        boolean hasId();
        /**
         * <code>optional string id = 1;</code>
         */
        java.lang.String getId();
        /**
         * <code>optional string id = 1;</code>
         */
        com.google.protobuf.ByteString
        getIdBytes();

        /**
         * <code>optional .SourceNode.Type type = 2 [default = SERVER];</code>
         */
        boolean hasType();
        /**
         * <code>optional .SourceNode.Type type = 2 [default = SERVER];</code>
         */
        JournalMessages.SourceNode.Type getType();

        /**
         * <code>optional string input_id = 3;</code>
         */
        boolean hasInputId();
        /**
         * <code>optional string input_id = 3;</code>
         */
        java.lang.String getInputId();
        /**
         * <code>optional string input_id = 3;</code>
         */
        com.google.protobuf.ByteString
        getInputIdBytes();
    }
    /**
     * Protobuf type {@code SourceNode}
     */
    public static final class SourceNode extends
        com.google.protobuf.GeneratedMessage implements
        // @@protoc_insertion_point(message_implements:SourceNode)
        SourceNodeOrBuilder {
        // Use SourceNode.newBuilder() to construct.
        private SourceNode(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }
        private SourceNode(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

        private static final SourceNode defaultInstance;
        public static SourceNode getDefaultInstance() {
            return defaultInstance;
        }

        @java.lang.Override
        public SourceNode getDefaultInstanceForType() {
            return defaultInstance;
        }

        private final com.google.protobuf.UnknownFieldSet unknownFields;
        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private SourceNode(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownField(input, unknownFields,
                                extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            id_ = bs;
                            break;
                        }
                        case 16: {
                            int rawValue = input.readEnum();
                            JournalMessages.SourceNode.Type value = JournalMessages.SourceNode.Type.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(2, rawValue);
                            } else {
                                bitField0_ |= 0x00000002;
                                type_ = value;
                            }
                            break;
                        }
                        case 26: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000004;
                            inputId_ = bs;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                    e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return JournalMessages.internal_static_org_graylog2_plugin_journal_SourceNode_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return JournalMessages.internal_static_org_graylog2_plugin_journal_SourceNode_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                    JournalMessages.SourceNode.class, JournalMessages.SourceNode.Builder.class);
        }

        public static com.google.protobuf.Parser<SourceNode> PARSER =
            new com.google.protobuf.AbstractParser<SourceNode>() {
                @java.lang.Override
                public SourceNode parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                    return new SourceNode(input, extensionRegistry);
                }
            };

        @java.lang.Override
        public com.google.protobuf.Parser<SourceNode> getParserForType() {
            return PARSER;
        }

        /**
         * Protobuf enum {@code SourceNode.Type}
         */
        public enum Type
            implements com.google.protobuf.ProtocolMessageEnum {
            /**
             * <code>SERVER = 0;</code>
             */
            SERVER(0, 0),
            /**
             * <code>RADIO = 1;</code>
             */
            RADIO(1, 1),
            ;

            /**
             * <code>SERVER = 0;</code>
             */
            public static final int SERVER_VALUE = 0;
            /**
             * <code>RADIO = 1;</code>
             */
            public static final int RADIO_VALUE = 1;


            @java.lang.Override
            public final int getNumber() { return value; }

            public static Type valueOf(int value) {
                switch (value) {
                    case 0: return SERVER;
                    case 1: return RADIO;
                    default: return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<Type>
            internalGetValueMap() {
                return internalValueMap;
            }
            private static com.google.protobuf.Internal.EnumLiteMap<Type>
                internalValueMap =
                new com.google.protobuf.Internal.EnumLiteMap<Type>() {
                    @java.lang.Override
                    public Type findValueByNumber(int number) {
                        return Type.valueOf(number);
                    }
                };

            @java.lang.Override
            public final com.google.protobuf.Descriptors.EnumValueDescriptor
            getValueDescriptor() {
                return getDescriptor().getValues().get(index);
            }
            @java.lang.Override
            public final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptorForType() {
                return getDescriptor();
            }
            public static final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptor() {
                return JournalMessages.SourceNode.getDescriptor().getEnumTypes().get(0);
            }

            private static final Type[] VALUES = values();

            public static Type valueOf(
                com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new java.lang.IllegalArgumentException(
                        "EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private final int index;
            private final int value;

            private Type(int index, int value) {
                this.index = index;
                this.value = value;
            }

            // @@protoc_insertion_point(enum_scope:SourceNode.Type)
        }

        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private java.lang.Object id_;
        /**
         * <code>optional string id = 1;</code>
         */
        @java.lang.Override
        public boolean hasId() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /**
         * <code>optional string id = 1;</code>
         */
        @java.lang.Override
        public java.lang.String getId() {
            java.lang.Object ref = id_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    id_ = s;
                }
                return s;
            }
        }
        /**
         * <code>optional string id = 1;</code>
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getIdBytes() {
            java.lang.Object ref = id_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                id_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int TYPE_FIELD_NUMBER = 2;
        private JournalMessages.SourceNode.Type type_;
        /**
         * <code>optional .SourceNode.Type type = 2 [default = SERVER];</code>
         */
        @java.lang.Override
        public boolean hasType() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         * <code>optional .SourceNode.Type type = 2 [default = SERVER];</code>
         */
        @java.lang.Override
        public JournalMessages.SourceNode.Type getType() {
            return type_;
        }

        public static final int INPUT_ID_FIELD_NUMBER = 3;
        private java.lang.Object inputId_;
        /**
         * <code>optional string input_id = 3;</code>
         */
        @java.lang.Override
        public boolean hasInputId() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }
        /**
         * <code>optional string input_id = 3;</code>
         */
        @java.lang.Override
        public java.lang.String getInputId() {
            java.lang.Object ref = inputId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    inputId_ = s;
                }
                return s;
            }
        }
        /**
         * <code>optional string input_id = 3;</code>
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getInputIdBytes() {
            java.lang.Object ref = inputId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                inputId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private void initFields() {
            id_ = "";
            type_ = JournalMessages.SourceNode.Type.SERVER;
            inputId_ = "";
        }
        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
            getSerializedSize();
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeBytes(1, getIdBytes());
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeEnum(2, type_.getNumber());
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeBytes(3, getInputIdBytes());
            }
            getUnknownFields().writeTo(output);
        }

        private int memoizedSerializedSize = -1;
        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSerializedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(1, getIdBytes());
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeEnumSize(2, type_.getNumber());
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(3, getInputIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            memoizedSerializedSize = size;
            return size;
        }

        private static final long serialVersionUID = 0L;
        @java.lang.Override
        protected java.lang.Object writeReplace()
            throws java.io.ObjectStreamException {
            return super.writeReplace();
        }

        public static JournalMessages.SourceNode parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static JournalMessages.SourceNode parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static JournalMessages.SourceNode parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static JournalMessages.SourceNode parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static JournalMessages.SourceNode parseFrom(java.io.InputStream input)
            throws java.io.IOException {
            return PARSER.parseFrom(input);
        }
        public static JournalMessages.SourceNode parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }
        public static JournalMessages.SourceNode parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input);
        }
        public static JournalMessages.SourceNode parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }
        public static JournalMessages.SourceNode parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
            return PARSER.parseFrom(input);
        }
        public static JournalMessages.SourceNode parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() { return Builder.create(); }
        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder(JournalMessages.SourceNode prototype) {
            return newBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() { return newBuilder(this); }

        @java.lang.Override
        protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code SourceNode}
         */
        public static final class Builder extends
            com.google.protobuf.GeneratedMessage.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:SourceNode)
            JournalMessages.SourceNodeOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_SourceNode_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_SourceNode_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                        JournalMessages.SourceNode.class, JournalMessages.SourceNode.Builder.class);
            }

            // Construct using JournalMessages.SourceNode.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                com.google.protobuf.GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
                }
            }
            private static Builder create() {
                return new Builder();
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                id_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                type_ = JournalMessages.SourceNode.Type.SERVER;
                bitField0_ = (bitField0_ & ~0x00000002);
                inputId_ = "";
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            @java.lang.Override
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return JournalMessages.internal_static_org_graylog2_plugin_journal_SourceNode_descriptor;
            }

            @java.lang.Override
            public JournalMessages.SourceNode getDefaultInstanceForType() {
                return JournalMessages.SourceNode.getDefaultInstance();
            }

            @java.lang.Override
            public JournalMessages.SourceNode build() {
                JournalMessages.SourceNode result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public JournalMessages.SourceNode buildPartial() {
                JournalMessages.SourceNode result = new JournalMessages.SourceNode(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.id_ = id_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.type_ = type_;
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.inputId_ = inputId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof JournalMessages.SourceNode) {
                    return mergeFrom((JournalMessages.SourceNode)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(JournalMessages.SourceNode other) {
                if (other == JournalMessages.SourceNode.getDefaultInstance()) return this;
                if (other.hasId()) {
                    bitField0_ |= 0x00000001;
                    id_ = other.id_;
                    onChanged();
                }
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasInputId()) {
                    bitField0_ |= 0x00000004;
                    inputId_ = other.inputId_;
                    onChanged();
                }
                this.mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
                JournalMessages.SourceNode parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (JournalMessages.SourceNode) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private java.lang.Object id_ = "";
            /**
             * <code>optional string id = 1;</code>
             */
            @java.lang.Override
            public boolean hasId() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /**
             * <code>optional string id = 1;</code>
             */
            @java.lang.Override
            public java.lang.String getId() {
                java.lang.Object ref = id_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        id_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>optional string id = 1;</code>
             */
            @java.lang.Override
            public com.google.protobuf.ByteString
            getIdBytes() {
                java.lang.Object ref = id_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
                    id_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>optional string id = 1;</code>
             */
            public Builder setId(
                java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                id_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional string id = 1;</code>
             */
            public Builder clearId() {
                bitField0_ = (bitField0_ & ~0x00000001);
                id_ = getDefaultInstance().getId();
                onChanged();
                return this;
            }
            /**
             * <code>optional string id = 1;</code>
             */
            public Builder setIdBytes(
                com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                id_ = value;
                onChanged();
                return this;
            }

            private JournalMessages.SourceNode.Type type_ = JournalMessages.SourceNode.Type.SERVER;
            /**
             * <code>optional .SourceNode.Type type = 2 [default = SERVER];</code>
             */
            @java.lang.Override
            public boolean hasType() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /**
             * <code>optional .SourceNode.Type type = 2 [default = SERVER];</code>
             */
            @java.lang.Override
            public JournalMessages.SourceNode.Type getType() {
                return type_;
            }
            /**
             * <code>optional .SourceNode.Type type = 2 [default = SERVER];</code>
             */
            public Builder setType(JournalMessages.SourceNode.Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                type_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional .SourceNode.Type type = 2 [default = SERVER];</code>
             */
            public Builder clearType() {
                bitField0_ = (bitField0_ & ~0x00000002);
                type_ = JournalMessages.SourceNode.Type.SERVER;
                onChanged();
                return this;
            }

            private java.lang.Object inputId_ = "";
            /**
             * <code>optional string input_id = 3;</code>
             */
            @java.lang.Override
            public boolean hasInputId() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }
            /**
             * <code>optional string input_id = 3;</code>
             */
            @java.lang.Override
            public java.lang.String getInputId() {
                java.lang.Object ref = inputId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        inputId_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>optional string input_id = 3;</code>
             */
            @java.lang.Override
            public com.google.protobuf.ByteString
            getInputIdBytes() {
                java.lang.Object ref = inputId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
                    inputId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>optional string input_id = 3;</code>
             */
            public Builder setInputId(
                java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                inputId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional string input_id = 3;</code>
             */
            public Builder clearInputId() {
                bitField0_ = (bitField0_ & ~0x00000004);
                inputId_ = getDefaultInstance().getInputId();
                onChanged();
                return this;
            }
            /**
             * <code>optional string input_id = 3;</code>
             */
            public Builder setInputIdBytes(
                com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                inputId_ = value;
                onChanged();
                return this;
            }

            // @@protoc_insertion_point(builder_scope:SourceNode)
        }

        static {
            defaultInstance = new SourceNode(true);
            defaultInstance.initFields();
        }

        // @@protoc_insertion_point(class_scope:SourceNode)
    }

    private static final com.google.protobuf.Descriptors.Descriptor
        internal_static_org_graylog2_plugin_journal_JournalMessage_descriptor;
    private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internal_static_org_graylog2_plugin_journal_JournalMessage_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
        internal_static_org_graylog2_plugin_journal_RemoteAddress_descriptor;
    private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internal_static_org_graylog2_plugin_journal_RemoteAddress_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
        internal_static_org_graylog2_plugin_journal_CodecInfo_descriptor;
    private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internal_static_org_graylog2_plugin_journal_CodecInfo_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
        internal_static_org_graylog2_plugin_journal_SourceNode_descriptor;
    private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internal_static_org_graylog2_plugin_journal_SourceNode_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }
    private static com.google.protobuf.Descriptors.FileDescriptor
        descriptor;
    static {
        java.lang.String[] descriptorData = {
            "\n\021raw_message.proto\022\033org.graylog2.plugin" +
                ".journal\"\241\002\n\016JournalMessage\022\017\n\007version\030\001" +
                " \001(\r\022\021\n\tuuid_time\030\002 \001(\006\022\025\n\ruuid_clockseq" +
                "\030\003 \001(\006\022\021\n\ttimestamp\030\004 \001(\006\0225\n\005codec\030\005 \001(\013" +
                "2&.CodecInfo" +
                "\022=\n\014source_nodes\030\006 \003(\0132\'.org.graylog2.pl" +
                "ugin.journal.SourceNode\022:\n\006remote\030\007 \001(\0132" +
                "*.RemoteAddr" +
                "ess\022\017\n\007payload\030\010 \001(\014\"@\n\rRemoteAddress\022\017\n" +
                "\007address\030\001 \001(\014\022\014\n\004port\030\002 \001(\r\022\020\n\010resolved",
            "\030\003 \001(\t\")\n\tCodecInfo\022\014\n\004name\030\001 \001(\t\022\016\n\006con" +
                "fig\030\002 \001(\t\"\215\001\n\nSourceNode\022\n\n\002id\030\001 \001(\t\022B\n\004" +
                "type\030\002 \001(\0162,.org.graylog2.plugin.journal" +
                ".SourceNode.Type:\006SERVER\022\020\n\010input_id\030\003 \001" +
                "(\t\"\035\n\004Type\022\n\n\006SERVER\020\000\022\t\n\005RADIO\020\001B.\n\033org" +
                ".graylog2.plugin.journalB\017JournalMessage" +
                "s"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
            new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
                @java.lang.Override
                public com.google.protobuf.ExtensionRegistry assignDescriptors(
                    com.google.protobuf.Descriptors.FileDescriptor root) {
                    descriptor = root;
                    return null;
                }
            };
        com.google.protobuf.Descriptors.FileDescriptor
            .internalBuildGeneratedFileFrom(descriptorData,
                new com.google.protobuf.Descriptors.FileDescriptor[] {
                }, assigner);
        internal_static_org_graylog2_plugin_journal_JournalMessage_descriptor =
            getDescriptor().getMessageTypes().get(0);
        internal_static_org_graylog2_plugin_journal_JournalMessage_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
            internal_static_org_graylog2_plugin_journal_JournalMessage_descriptor,
            new java.lang.String[] { "Version", "UuidTime", "UuidClockseq", "Timestamp", "Codec", "SourceNodes", "Remote", "Payload", });
        internal_static_org_graylog2_plugin_journal_RemoteAddress_descriptor =
            getDescriptor().getMessageTypes().get(1);
        internal_static_org_graylog2_plugin_journal_RemoteAddress_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
            internal_static_org_graylog2_plugin_journal_RemoteAddress_descriptor,
            new java.lang.String[] { "Address", "Port", "Resolved", });
        internal_static_org_graylog2_plugin_journal_CodecInfo_descriptor =
            getDescriptor().getMessageTypes().get(2);
        internal_static_org_graylog2_plugin_journal_CodecInfo_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
            internal_static_org_graylog2_plugin_journal_CodecInfo_descriptor,
            new java.lang.String[] { "Name", "Config", });
        internal_static_org_graylog2_plugin_journal_SourceNode_descriptor =
            getDescriptor().getMessageTypes().get(3);
        internal_static_org_graylog2_plugin_journal_SourceNode_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
            internal_static_org_graylog2_plugin_journal_SourceNode_descriptor,
            new java.lang.String[] { "Id", "Type", "InputId", });
    }

    // @@protoc_insertion_point(outer_class_scope)
}
