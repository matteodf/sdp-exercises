package sum;

import io.grpc.stub.StreamObserver;
import sum.SumGrpc.SumImplBase;
import sum.SumOuterClass.Result;
import sum.SumOuterClass.SumMessage;

public class SumImpl extends SumImplBase {

    @Override
    public void simpleSum(SumOuterClass.SumMessage request, StreamObserver<Result> responseObserver){
        System.out.println(request);
        Result response = Result.newBuilder().setNumber(request.getFirstNumber() + request.getSecondNumber()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void repeatedSum(SumOuterClass.SumMessage request, StreamObserver<Result> responseObserver){
        System.out.println(request);
        int sum = 0;
        for (int i = 0; i < request.getSecondNumber(); i++){
            sum += request.getFirstNumber();
            Result response = Result.newBuilder().setNumber(sum).build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<SumOuterClass.SumMessage> streamSum(StreamObserver<Result> responseObserver){
        return new StreamObserver<SumMessage>() {

            @Override
            public void onNext(SumMessage value) {
                int sum = value.getFirstNumber() + value.getSecondNumber();
                responseObserver.onNext(Result.newBuilder().setNumber(sum).build());
            }

            @Override
            public void onError(Throwable t) { }

            @Override
            public void onCompleted() { }
        };
    }
}
