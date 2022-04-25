package iterative;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

class IterativeServer {

	public static void main(String[] argv) { 
		String sum;
		int portNumber;
		int clientFirstNumber;
		int clientSecondNumber;

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
								ex.printStackTrace();
							}
						}
						catch (NumberFormatException ex){
							System.err.println("The provided number was either not valid or the client terminated the connection.");
						} catch (Exception ex){
							ex.printStackTrace();
						}
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
