package iterative;

import java.io.*;
import java.net.*; 

class IterativeServer {

	public static void main(String argv[]) throws Exception 
	{ 
		String sum;
		Integer portNumber;
		Integer clientFirstNumber;
		Integer clientSecondNumber;

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
				System.out.println("Connection initialized on port " + Integer.toString(portNumber));

				while(true) {
					Socket connectionSocket = welcomeSocket.accept();
					String clientAddress = connectionSocket.getInetAddress().getHostAddress();
					Integer clientPort = connectionSocket.getPort();
					System.out.println("\nClient connected from address " + clientAddress + ", port " + clientPort);

					/* Initialization of input stream from socket */
					BufferedReader inFromClient =
							new BufferedReader(new
									InputStreamReader(connectionSocket.getInputStream()));

					/* Initialization of output stream to socket */
					DataOutputStream  outToClient =
							new DataOutputStream(connectionSocket.getOutputStream());

					try{
						/* Read line from client */
						clientFirstNumber = Integer.parseInt(inFromClient.readLine());
						System.out.println("First number received");
						clientSecondNumber = Integer.parseInt(inFromClient.readLine());
						System.out.println("Second number received");

						sum = Integer.toString(clientFirstNumber + clientSecondNumber) + '\n';
						try{
							/* Send answer to client */
							outToClient.writeBytes(sum);
							System.out.println("Result send successfully!");
							connectionSocket.close();
						} catch (SocketException ex){
							System.err.println("The connection was reset or lost");
						} catch (Exception ex){
							System.err.println(ex.toString());
						}
					}
					catch (NumberFormatException ex){
						System.err.println("The provided number was either not valid or the client terminated the connection.");
					} catch (Exception ex){
						System.err.println(ex.toString());
					}
				}
			} catch (BindException ex){
				System.err.println("Address not valid or already in use. Try again!\n");
				return;
			} catch (IllegalArgumentException ex) {
				System.err.println("Port value out of range. Try again!\n");
				return;
			} catch (Exception ex){
				System.err.println(ex.toString());
				return;
			}
		} catch (NumberFormatException ex){
			System.err.println("Port number is not valid. Try again!\n");
			return;
		} catch (Exception ex){
			System.err.println(ex.toString());
			return;
		}
	}
}
