import java.io.*;
import java.net.*; 

class MultiServer {

	public static void main(String argv[]) throws Exception 
	{ 
		Integer portNumber;
		Reservation reservation = new Reservation();

		/* Initialization of the keyboard input */
		BufferedReader inFromUser =
				new BufferedReader(new InputStreamReader(System.in));

		try{
			/* Create a "listening socket" on the specified port */
			ServerSocket welcomeSocket = new ServerSocket(6789);
			System.out.println("Connection initialized on port 6789");
			while(true) {
				Socket connectionSocket = welcomeSocket.accept();
				String clientAddress = connectionSocket.getInetAddress().getHostAddress();
				Integer clientPort = connectionSocket.getPort();
				System.out.println("CONNECTION! Client connected from address " + clientAddress + ", port " + clientPort);

				// thread creation passing the established socket as arg
				ServerThread theThread =
						new ServerThread(connectionSocket, reservation);

				// start of the thread
				theThread.start();

			}
		} catch (BindException ex){
			System.err.println("Address not valid or already in use. Try again!\n");
			return;
		} catch (IllegalArgumentException ex) {
			System.err.println("Port value out of range. Try again!\n");
			return;
		} catch (Exception ex){
			ex.printStackTrace();
			return;
		}
	}
}
