package multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

class MultiServer {

	public static void main(String[] argv) {
		int portNumber;

		/* Initialization of the keyboard input */
		BufferedReader inFromUser =
				new BufferedReader(new InputStreamReader(System.in));

		/* Asks parameters for socket initialization */
		System.out.print("Enter the port number of the server: ");
		try{
			portNumber = Integer.parseInt(inFromUser.readLine());
			try{
				/* Create a "listening socket" on the specified port */
				ServerSocket welcomeSocket = new ServerSocket(portNumber);
				System.out.println("Connection initialized on port " + portNumber);
				while(true) {
					try{
						Socket connectionSocket = welcomeSocket.accept();
						String clientAddress = connectionSocket.getInetAddress().getHostAddress();
						int clientPort = connectionSocket.getPort();
						System.out.println("CONNECTION! Client connected from address " + clientAddress + ", port " + clientPort);

						// thread creation passing the established socket as arg
						ServerThread theThread =
								new ServerThread(connectionSocket);

						// start of the thread
						theThread.start();
					} catch (Exception ex){
						ex.printStackTrace();
						return;
					}
				}
			} catch (BindException ex){
				System.err.println("Address not valid or already in use. Try again!\n");
			} catch (IllegalArgumentException ex) {
				System.err.println("Port value out of range. Try again!\n");
			} catch (Exception ex){
				ex.printStackTrace();
			}
		} catch (NumberFormatException ex){
			System.err.println("Port number is not valid. Try again!\n");
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
