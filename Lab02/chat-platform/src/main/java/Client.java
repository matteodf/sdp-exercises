import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class Client {

	public static void main(String[] argv) {
		Queue outputQueue = new Queue();
		Queue inputQueue = new Queue();
		String nickname;

		/* Initialization of the keyboard input */
		BufferedReader inFromUser =
				new BufferedReader(new InputStreamReader(System.in));

		try {
			Socket clientSocket = new Socket("localhost", 6789);
			/* Initialization of the producer that reads messages from keyboard and adds them to queue */
			Producer outputProducer = new Producer(outputQueue);
			/* Initialization of the producer that reads messages from socket and adds them to queue */
			Producer inputProducer = new Producer(inputQueue, clientSocket);
			/* Initialization of the producer that sends messages to socket */
			Consumer outputConsumer = new Consumer(outputQueue, clientSocket);
			/* Initialization of the producer that sends messages to client console */
			Consumer inputConsumer = new Consumer(inputQueue);

			System.out.print("Insert your nickname: ");
			nickname = inFromUser.readLine();
			System.out.println("Welcome to the Chat Platform, " + nickname + "!");

			/* Initialization of the output stream to the socket */
			DataOutputStream outToServer =
					new DataOutputStream(clientSocket.getOutputStream());

			outToServer.writeBytes(nickname + "\n");

			// Start of the local threads
			new Thread(outputProducer).start();
			new Thread(inputConsumer).start();

			try{
				// Start of threads bound to a socket
				new Thread(inputProducer).start();
				new Thread(outputConsumer).start();

			} catch (Exception ex) {
				ex.printStackTrace();
				clientSocket.close();
			}

		} catch (Exception ex) {
			System.err.println("The server is not reachable.\n");
		}
	}
}
