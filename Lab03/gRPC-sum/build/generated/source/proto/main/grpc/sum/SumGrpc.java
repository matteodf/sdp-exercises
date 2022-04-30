package sum;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: Sum.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SumGrpc {

  private SumGrpc() {}

  public static final String SERVICE_NAME = "sum.Sum";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sum.SumOuterClass.SumMessage,
      sum.SumOuterClass.Result> getSimpleSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "simpleSum",
      requestType = sum.SumOuterClass.SumMessage.class,
      responseType = sum.SumOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sum.SumOuterClass.SumMessage,
      sum.SumOuterClass.Result> getSimpleSumMethod() {
    io.grpc.MethodDescriptor<sum.SumOuterClass.SumMessage, sum.SumOuterClass.Result> getSimpleSumMethod;
    if ((getSimpleSumMethod = SumGrpc.getSimpleSumMethod) == null) {
      synchronized (SumGrpc.class) {
        if ((getSimpleSumMethod = SumGrpc.getSimpleSumMethod) == null) {
          SumGrpc.getSimpleSumMethod = getSimpleSumMethod =
              io.grpc.MethodDescriptor.<sum.SumOuterClass.SumMessage, sum.SumOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "simpleSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sum.SumOuterClass.SumMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sum.SumOuterClass.Result.getDefaultInstance()))
              .setSchemaDescriptor(new SumMethodDescriptorSupplier("simpleSum"))
              .build();
        }
      }
    }
    return getSimpleSumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sum.SumOuterClass.SumMessage,
      sum.SumOuterClass.Result> getRepeatedSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "repeatedSum",
      requestType = sum.SumOuterClass.SumMessage.class,
      responseType = sum.SumOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<sum.SumOuterClass.SumMessage,
      sum.SumOuterClass.Result> getRepeatedSumMethod() {
    io.grpc.MethodDescriptor<sum.SumOuterClass.SumMessage, sum.SumOuterClass.Result> getRepeatedSumMethod;
    if ((getRepeatedSumMethod = SumGrpc.getRepeatedSumMethod) == null) {
      synchronized (SumGrpc.class) {
        if ((getRepeatedSumMethod = SumGrpc.getRepeatedSumMethod) == null) {
          SumGrpc.getRepeatedSumMethod = getRepeatedSumMethod =
              io.grpc.MethodDescriptor.<sum.SumOuterClass.SumMessage, sum.SumOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "repeatedSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sum.SumOuterClass.SumMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sum.SumOuterClass.Result.getDefaultInstance()))
              .setSchemaDescriptor(new SumMethodDescriptorSupplier("repeatedSum"))
              .build();
        }
      }
    }
    return getRepeatedSumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sum.SumOuterClass.SumMessage,
      sum.SumOuterClass.Result> getStreamSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamSum",
      requestType = sum.SumOuterClass.SumMessage.class,
      responseType = sum.SumOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<sum.SumOuterClass.SumMessage,
      sum.SumOuterClass.Result> getStreamSumMethod() {
    io.grpc.MethodDescriptor<sum.SumOuterClass.SumMessage, sum.SumOuterClass.Result> getStreamSumMethod;
    if ((getStreamSumMethod = SumGrpc.getStreamSumMethod) == null) {
      synchronized (SumGrpc.class) {
        if ((getStreamSumMethod = SumGrpc.getStreamSumMethod) == null) {
          SumGrpc.getStreamSumMethod = getStreamSumMethod =
              io.grpc.MethodDescriptor.<sum.SumOuterClass.SumMessage, sum.SumOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sum.SumOuterClass.SumMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sum.SumOuterClass.Result.getDefaultInstance()))
              .setSchemaDescriptor(new SumMethodDescriptorSupplier("streamSum"))
              .build();
        }
      }
    }
    return getStreamSumMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SumStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SumStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SumStub>() {
        @java.lang.Override
        public SumStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SumStub(channel, callOptions);
        }
      };
    return SumStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SumBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SumBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SumBlockingStub>() {
        @java.lang.Override
        public SumBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SumBlockingStub(channel, callOptions);
        }
      };
    return SumBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SumFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SumFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SumFutureStub>() {
        @java.lang.Override
        public SumFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SumFutureStub(channel, callOptions);
        }
      };
    return SumFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SumImplBase implements io.grpc.BindableService {

    /**
     */
    public void simpleSum(sum.SumOuterClass.SumMessage request,
        io.grpc.stub.StreamObserver<sum.SumOuterClass.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSimpleSumMethod(), responseObserver);
    }

    /**
     */
    public void repeatedSum(sum.SumOuterClass.SumMessage request,
        io.grpc.stub.StreamObserver<sum.SumOuterClass.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRepeatedSumMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<sum.SumOuterClass.SumMessage> streamSum(
        io.grpc.stub.StreamObserver<sum.SumOuterClass.Result> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamSumMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSimpleSumMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sum.SumOuterClass.SumMessage,
                sum.SumOuterClass.Result>(
                  this, METHODID_SIMPLE_SUM)))
          .addMethod(
            getRepeatedSumMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                sum.SumOuterClass.SumMessage,
                sum.SumOuterClass.Result>(
                  this, METHODID_REPEATED_SUM)))
          .addMethod(
            getStreamSumMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                sum.SumOuterClass.SumMessage,
                sum.SumOuterClass.Result>(
                  this, METHODID_STREAM_SUM)))
          .build();
    }
  }

  /**
   */
  public static final class SumStub extends io.grpc.stub.AbstractAsyncStub<SumStub> {
    private SumStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SumStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SumStub(channel, callOptions);
    }

    /**
     */
    public void simpleSum(sum.SumOuterClass.SumMessage request,
        io.grpc.stub.StreamObserver<sum.SumOuterClass.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSimpleSumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void repeatedSum(sum.SumOuterClass.SumMessage request,
        io.grpc.stub.StreamObserver<sum.SumOuterClass.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRepeatedSumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<sum.SumOuterClass.SumMessage> streamSum(
        io.grpc.stub.StreamObserver<sum.SumOuterClass.Result> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamSumMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SumBlockingStub extends io.grpc.stub.AbstractBlockingStub<SumBlockingStub> {
    private SumBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SumBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SumBlockingStub(channel, callOptions);
    }

    /**
     */
    public sum.SumOuterClass.Result simpleSum(sum.SumOuterClass.SumMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSimpleSumMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<sum.SumOuterClass.Result> repeatedSum(
        sum.SumOuterClass.SumMessage request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRepeatedSumMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SumFutureStub extends io.grpc.stub.AbstractFutureStub<SumFutureStub> {
    private SumFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SumFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SumFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sum.SumOuterClass.Result> simpleSum(
        sum.SumOuterClass.SumMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSimpleSumMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIMPLE_SUM = 0;
  private static final int METHODID_REPEATED_SUM = 1;
  private static final int METHODID_STREAM_SUM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SumImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SumImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIMPLE_SUM:
          serviceImpl.simpleSum((sum.SumOuterClass.SumMessage) request,
              (io.grpc.stub.StreamObserver<sum.SumOuterClass.Result>) responseObserver);
          break;
        case METHODID_REPEATED_SUM:
          serviceImpl.repeatedSum((sum.SumOuterClass.SumMessage) request,
              (io.grpc.stub.StreamObserver<sum.SumOuterClass.Result>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_SUM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamSum(
              (io.grpc.stub.StreamObserver<sum.SumOuterClass.Result>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SumBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SumBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sum.SumOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Sum");
    }
  }

  private static final class SumFileDescriptorSupplier
      extends SumBaseDescriptorSupplier {
    SumFileDescriptorSupplier() {}
  }

  private static final class SumMethodDescriptorSupplier
      extends SumBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SumMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SumGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SumFileDescriptorSupplier())
              .addMethod(getSimpleSumMethod())
              .addMethod(getRepeatedSumMethod())
              .addMethod(getStreamSumMethod())
              .build();
        }
      }
    }
    return result;
  }
}
