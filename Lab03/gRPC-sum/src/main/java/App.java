import io.grpc.Server;
import io.grpc.ServerBuilder;
import sum.SumImpl;

class App {

	public static void main(String[] args) {

		try {
			Server server = ServerBuilder.forPort(6789).addService(new SumImpl()).build();
			server.start();
			System.out.println("Server started!");
			server.awaitTermination();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
