package sum;

import sum.SumGrpc;
import sum.SumGrpc.*;
import sum.SumOuterClass.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

class SumClient {

	public static void main(String[] argv) throws IOException, InterruptedException {

		Socket s = new Socket("localhost", 6789);

		System.out.println("Simple Sum service\nEnter two numbers (press enter to send each number)");

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		int firstNumber, secondNumber;

		try {
			firstNumber = Integer.parseInt(inFromUser.readLine());
			secondNumber = Integer.parseInt(inFromUser.readLine());
		} catch (NumberFormatException ex) {
			System.err.println("Invalid number!");
			s.close();
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			s.close();
			return;
		}
		System.out.println("\nSimple sum of the two numbers is being calculated");
		simpleSum(firstNumber, secondNumber);
		System.out.println("\nRepeated sum of the first number is being calculated");
		repeatedSum(firstNumber, secondNumber);
		System.out.println("\nGenerating a stream of sum that duplicates the first number for every iteration and adds it to the second number");
		streamSum(firstNumber, secondNumber);
	}

	//calling a synchronous rpc operation
	public static void simpleSum(int firstNumber, int secondNumber){

		//plaintext channel on the address (ip/port) which offers the GreetingService service
		final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:6789").usePlaintext().build();

		//creating a blocking stub on the channel
		SumBlockingStub stub = SumGrpc.newBlockingStub(channel);

		//creating the HelloResponse object which will be provided as input to the RPC method
		SumMessage request = SumMessage.newBuilder().setFirstNumber(firstNumber).setSecondNumber(secondNumber).build();

		//calling the method. it returns an instance of HelloResponse
		Result response = stub.simpleSum(request);

		//printing the answer
		System.out.println(response.getNumber());

		//closing the channel
		channel.shutdown();
	}

	//calling an asynchronous method based on stream
	public static void repeatedSum(int firstNumber, int secondNumber) throws InterruptedException {

		//plaintext channel on the address (ip/port) which offers the GreetingService service
		final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:6789").usePlaintext().build();

		//creating an asynchronous stub on the channel
		SumStub stub = SumGrpc.newStub(channel);

		//creating the HelloResponse object which will be provided as input to the RPC method
		SumMessage request = SumMessage.newBuilder().setFirstNumber(firstNumber).setSecondNumber(secondNumber).build();

		//calling the RPC method. since it is asynchronous, we need to define handlers
		stub.repeatedSum(request, new StreamObserver<Result>() {
			//this hanlder takes care of each item received in the stream
			public void onNext(Result response) {
				//each item is just printed
				System.out.println("Current sum value: " + response.getNumber());
			}

			//if there are some errors, this method will be called
			public void onError(Throwable throwable) {
				System.out.println("Error! "+throwable.getMessage());
			}

			//when the stream is completed (the server called "onCompleted") just close the channel
			public void onCompleted() {
				channel.shutdownNow();
			}
		});

		//you need this. otherwise the method will terminate before that answers from the server are received
		channel.awaitTermination(10, TimeUnit.SECONDS);
	}

	//calling an asynchronous method based on stream
	public static void streamSum(int firstNumber, int secondNumber) throws InterruptedException {

		//plaintext channel on the address (ip/port) which offers the GreetingService service
		final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:6789").usePlaintext().build();

		//creating an asynchronous stub on the channel
		SumStub stub = SumGrpc.newStub(channel);

		//creating the HelloResponse object which will be provided as input to the RPC method
		SumMessage request = SumMessage.newBuilder().setFirstNumber(firstNumber).setSecondNumber(secondNumber).build();

		//calling the RPC method. since it is asynchronous, we need to define handlers
		StreamObserver<SumMessage> stream = stub.streamSum(new StreamObserver<Result>() {
			//this hanlder takes care of each item received in the stream
			public void onNext(Result response) {
				//each item is just printed
				System.out.println("Current sum value: " + response.getNumber());
			}

			//if there are some errors, this method will be called
			public void onError(Throwable throwable) {
				System.out.println("Error! "+throwable.getMessage());
			}

			//when the stream is completed (the server called "onCompleted") just close the channel
			public void onCompleted() {
				channel.shutdownNow();
			}
		});

		for(int i = 0; i < secondNumber; i++){
			stream.onNext(SumMessage.newBuilder().setFirstNumber((int) (firstNumber*Math.pow(2,i))).setSecondNumber(secondNumber).build());
		}

		//you need this. otherwise the method will terminate before that answers from the server are received
		channel.awaitTermination(10, TimeUnit.SECONDS);
	}

}
