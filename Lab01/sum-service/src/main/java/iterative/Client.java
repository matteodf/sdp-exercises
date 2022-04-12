package iterative;

import java.io.*;
import java.net.*;

class Client {

	public static void main(String argv[]) throws Exception { 
		String result;
		Integer firstNumber = 0;
		Integer secondNumber = 0;
		String serverAddress;
		Integer portNumber;

		/* Initialization of keyboard input */
		BufferedReader inFromUser =
			new BufferedReader(new InputStreamReader(System.in));

		/* Asks parameters for socket initialization */
		System.out.print("Enter the server address: ");
		serverAddress = inFromUser.readLine();
		System.out.print("Enter the port number of the server: ");
		try {
			portNumber = Integer.parseInt(inFromUser.readLine());

			try {
				Socket clientSocket = new Socket(serverAddress, portNumber);
				/* Initialization of the output stream to the socket */
				DataOutputStream outToServer =
						new DataOutputStream(clientSocket.getOutputStream());

				/* Initialization of the input stream from the socket */
				BufferedReader inFromServer =
						new BufferedReader(new
								InputStreamReader(clientSocket.getInputStream()));


				/* Parameters insertion */
				System.out.print("Enter the first number: ");
				try {
					firstNumber = Integer.parseInt(inFromUser.readLine());
				} catch (NumberFormatException ex) {
					System.err.println("Invalid number!");
					clientSocket.close();
					return;
				} catch (Exception ex) {
					System.err.println(ex.toString());
					clientSocket.close();
					return;
				}
				System.out.print("Enter the second number: ");
				try {
					secondNumber = Integer.parseInt(inFromUser.readLine());
					Thread.sleep(10000);
					try{
						/* Send numbers to server */
						outToServer.writeBytes(Integer.toString(firstNumber) + '\n' + Integer.toString(secondNumber) + '\n');
						/* Read answer from server */
						result = inFromServer.readLine();

						System.out.println("Result computed by the server: " + result);

						clientSocket.close();
					}
					catch (SocketException ex){
						System.err.println("The connection was reset or lost");
						return;
					}
				} catch (NumberFormatException ex) {
					System.err.println("Invalid number!");
					clientSocket.close();
					return;
				} catch (Exception ex) {
					System.err.println(ex.toString());
					clientSocket.close();
					return;
				}

			} catch (Exception ex) {
				System.err.println("Connection refused! Check address and port and retry\n");
				return;
			}
		} catch (NumberFormatException ex){
			System.err.println("Port number not valid.\n");
			return;
		} catch (Exception ex){
			System.err.println(ex.toString());
			return;
		}
	}
}
