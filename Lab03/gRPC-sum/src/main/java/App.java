import io.grpc.Server;
import io.grpc.ServerBuilder;
import sum.SumImpl;

import java.io.IOException;

class App {

	public static void main(String[] args) throws IOException {

		try {
			Server server = ServerBuilder.forPort(6789).addService(new SumImpl()).build();
			server.start();
			System.out.println("Server started!");
			server.awaitTermination();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
