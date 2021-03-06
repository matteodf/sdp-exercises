// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Sum.proto

package sum;

public final class SumOuterClass {
  private SumOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SumMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:sum.SumMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 firstNumber = 1;</code>
     * @return The firstNumber.
     */
    int getFirstNumber();

    /**
     * <code>int32 secondNumber = 2;</code>
     * @return The secondNumber.
     */
    int getSecondNumber();
  }
  /**
   * Protobuf type {@code sum.SumMessage}
   */
  public static final class SumMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:sum.SumMessage)
      SumMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use SumMessage.newBuilder() to construct.
    private SumMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SumMessage() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new SumMessage();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private SumMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
            case 8: {

              firstNumber_ = input.readInt32();
              break;
            }
            case 16: {

              secondNumber_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sum.SumOuterClass.internal_static_sum_SumMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sum.SumOuterClass.internal_static_sum_SumMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sum.SumOuterClass.SumMessage.class, sum.SumOuterClass.SumMessage.Builder.class);
    }

    public static final int FIRSTNUMBER_FIELD_NUMBER = 1;
    private int firstNumber_;
    /**
     * <code>int32 firstNumber = 1;</code>
     * @return The firstNumber.
     */
    @java.lang.Override
    public int getFirstNumber() {
      return firstNumber_;
    }

    public static final int SECONDNUMBER_FIELD_NUMBER = 2;
    private int secondNumber_;
    /**
     * <code>int32 secondNumber = 2;</code>
     * @return The secondNumber.
     */
    @java.lang.Override
    public int getSecondNumber() {
      return secondNumber_;
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
      if (firstNumber_ != 0) {
        output.writeInt32(1, firstNumber_);
      }
      if (secondNumber_ != 0) {
        output.writeInt32(2, secondNumber_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (firstNumber_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, firstNumber_);
      }
      if (secondNumber_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, secondNumber_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof sum.SumOuterClass.SumMessage)) {
        return super.equals(obj);
      }
      sum.SumOuterClass.SumMessage other = (sum.SumOuterClass.SumMessage) obj;

      if (getFirstNumber()
          != other.getFirstNumber()) return false;
      if (getSecondNumber()
          != other.getSecondNumber()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + FIRSTNUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getFirstNumber();
      hash = (37 * hash) + SECONDNUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getSecondNumber();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static sum.SumOuterClass.SumMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sum.SumOuterClass.SumMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sum.SumOuterClass.SumMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sum.SumOuterClass.SumMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sum.SumOuterClass.SumMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sum.SumOuterClass.SumMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sum.SumOuterClass.SumMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static sum.SumOuterClass.SumMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static sum.SumOuterClass.SumMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static sum.SumOuterClass.SumMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static sum.SumOuterClass.SumMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static sum.SumOuterClass.SumMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(sum.SumOuterClass.SumMessage prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code sum.SumMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:sum.SumMessage)
        sum.SumOuterClass.SumMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return sum.SumOuterClass.internal_static_sum_SumMessage_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return sum.SumOuterClass.internal_static_sum_SumMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                sum.SumOuterClass.SumMessage.class, sum.SumOuterClass.SumMessage.Builder.class);
      }

      // Construct using sum.SumOuterClass.SumMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        firstNumber_ = 0;

        secondNumber_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return sum.SumOuterClass.internal_static_sum_SumMessage_descriptor;
      }

      @java.lang.Override
      public sum.SumOuterClass.SumMessage getDefaultInstanceForType() {
        return sum.SumOuterClass.SumMessage.getDefaultInstance();
      }

      @java.lang.Override
      public sum.SumOuterClass.SumMessage build() {
        sum.SumOuterClass.SumMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public sum.SumOuterClass.SumMessage buildPartial() {
        sum.SumOuterClass.SumMessage result = new sum.SumOuterClass.SumMessage(this);
        result.firstNumber_ = firstNumber_;
        result.secondNumber_ = secondNumber_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof sum.SumOuterClass.SumMessage) {
          return mergeFrom((sum.SumOuterClass.SumMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(sum.SumOuterClass.SumMessage other) {
        if (other == sum.SumOuterClass.SumMessage.getDefaultInstance()) return this;
        if (other.getFirstNumber() != 0) {
          setFirstNumber(other.getFirstNumber());
        }
        if (other.getSecondNumber() != 0) {
          setSecondNumber(other.getSecondNumber());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
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
        sum.SumOuterClass.SumMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (sum.SumOuterClass.SumMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int firstNumber_ ;
      /**
       * <code>int32 firstNumber = 1;</code>
       * @return The firstNumber.
       */
      @java.lang.Override
      public int getFirstNumber() {
        return firstNumber_;
      }
      /**
       * <code>int32 firstNumber = 1;</code>
       * @param value The firstNumber to set.
       * @return This builder for chaining.
       */
      public Builder setFirstNumber(int value) {
        
        firstNumber_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 firstNumber = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearFirstNumber() {
        
        firstNumber_ = 0;
        onChanged();
        return this;
      }

      private int secondNumber_ ;
      /**
       * <code>int32 secondNumber = 2;</code>
       * @return The secondNumber.
       */
      @java.lang.Override
      public int getSecondNumber() {
        return secondNumber_;
      }
      /**
       * <code>int32 secondNumber = 2;</code>
       * @param value The secondNumber to set.
       * @return This builder for chaining.
       */
      public Builder setSecondNumber(int value) {
        
        secondNumber_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 secondNumber = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearSecondNumber() {
        
        secondNumber_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:sum.SumMessage)
    }

    // @@protoc_insertion_point(class_scope:sum.SumMessage)
    private static final sum.SumOuterClass.SumMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new sum.SumOuterClass.SumMessage();
    }

    public static sum.SumOuterClass.SumMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SumMessage>
        PARSER = new com.google.protobuf.AbstractParser<SumMessage>() {
      @java.lang.Override
      public SumMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new SumMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SumMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SumMessage> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public sum.SumOuterClass.SumMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface ResultOrBuilder extends
      // @@protoc_insertion_point(interface_extends:sum.Result)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 number = 1;</code>
     * @return The number.
     */
    int getNumber();
  }
  /**
   * Protobuf type {@code sum.Result}
   */
  public static final class Result extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:sum.Result)
      ResultOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Result.newBuilder() to construct.
    private Result(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Result() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Result();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Result(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
            case 8: {

              number_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sum.SumOuterClass.internal_static_sum_Result_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sum.SumOuterClass.internal_static_sum_Result_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sum.SumOuterClass.Result.class, sum.SumOuterClass.Result.Builder.class);
    }

    public static final int NUMBER_FIELD_NUMBER = 1;
    private int number_;
    /**
     * <code>int32 number = 1;</code>
     * @return The number.
     */
    @java.lang.Override
    public int getNumber() {
      return number_;
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
      if (number_ != 0) {
        output.writeInt32(1, number_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (number_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, number_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof sum.SumOuterClass.Result)) {
        return super.equals(obj);
      }
      sum.SumOuterClass.Result other = (sum.SumOuterClass.Result) obj;

      if (getNumber()
          != other.getNumber()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + NUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getNumber();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static sum.SumOuterClass.Result parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sum.SumOuterClass.Result parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sum.SumOuterClass.Result parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sum.SumOuterClass.Result parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sum.SumOuterClass.Result parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sum.SumOuterClass.Result parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sum.SumOuterClass.Result parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static sum.SumOuterClass.Result parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static sum.SumOuterClass.Result parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static sum.SumOuterClass.Result parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static sum.SumOuterClass.Result parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static sum.SumOuterClass.Result parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(sum.SumOuterClass.Result prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code sum.Result}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:sum.Result)
        sum.SumOuterClass.ResultOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return sum.SumOuterClass.internal_static_sum_Result_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return sum.SumOuterClass.internal_static_sum_Result_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                sum.SumOuterClass.Result.class, sum.SumOuterClass.Result.Builder.class);
      }

      // Construct using sum.SumOuterClass.Result.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        number_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return sum.SumOuterClass.internal_static_sum_Result_descriptor;
      }

      @java.lang.Override
      public sum.SumOuterClass.Result getDefaultInstanceForType() {
        return sum.SumOuterClass.Result.getDefaultInstance();
      }

      @java.lang.Override
      public sum.SumOuterClass.Result build() {
        sum.SumOuterClass.Result result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public sum.SumOuterClass.Result buildPartial() {
        sum.SumOuterClass.Result result = new sum.SumOuterClass.Result(this);
        result.number_ = number_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof sum.SumOuterClass.Result) {
          return mergeFrom((sum.SumOuterClass.Result)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(sum.SumOuterClass.Result other) {
        if (other == sum.SumOuterClass.Result.getDefaultInstance()) return this;
        if (other.getNumber() != 0) {
          setNumber(other.getNumber());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
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
        sum.SumOuterClass.Result parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (sum.SumOuterClass.Result) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int number_ ;
      /**
       * <code>int32 number = 1;</code>
       * @return The number.
       */
      @java.lang.Override
      public int getNumber() {
        return number_;
      }
      /**
       * <code>int32 number = 1;</code>
       * @param value The number to set.
       * @return This builder for chaining.
       */
      public Builder setNumber(int value) {
        
        number_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 number = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearNumber() {
        
        number_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:sum.Result)
    }

    // @@protoc_insertion_point(class_scope:sum.Result)
    private static final sum.SumOuterClass.Result DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new sum.SumOuterClass.Result();
    }

    public static sum.SumOuterClass.Result getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Result>
        PARSER = new com.google.protobuf.AbstractParser<Result>() {
      @java.lang.Override
      public Result parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Result(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Result> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Result> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public sum.SumOuterClass.Result getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sum_SumMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sum_SumMessage_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sum_Result_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sum_Result_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tSum.proto\022\003sum\"7\n\nSumMessage\022\023\n\013firstN" +
      "umber\030\001 \001(\005\022\024\n\014secondNumber\030\002 \001(\005\"\030\n\006Res" +
      "ult\022\016\n\006number\030\001 \001(\0052\216\001\n\003Sum\022)\n\tsimpleSum" +
      "\022\017.sum.SumMessage\032\013.sum.Result\022-\n\013repeat" +
      "edSum\022\017.sum.SumMessage\032\013.sum.Result0\001\022-\n" +
      "\tstreamSum\022\017.sum.SumMessage\032\013.sum.Result" +
      "(\0010\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_sum_SumMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_sum_SumMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sum_SumMessage_descriptor,
        new java.lang.String[] { "FirstNumber", "SecondNumber", });
    internal_static_sum_Result_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_sum_Result_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sum_Result_descriptor,
        new java.lang.String[] { "Number", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
