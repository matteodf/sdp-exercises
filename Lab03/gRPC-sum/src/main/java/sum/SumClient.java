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

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

class SumClient {

	public static void main(String[] argv) throws IOException{

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
		System.out.println("Simple sum of the two numbers is being calculated");
		simpleSum(firstNumber, secondNumber);
		/*System.out.println("Repeated sum of the first number is being calculated");
		repeatedSum(firstNumber, secondNumber);*/
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
}
