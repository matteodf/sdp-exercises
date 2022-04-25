package iterative;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

class Client {

	public static void main(String[] argv) throws Exception {
		String result;
		int firstNumber;
		int secondNumber;
		String serverAddress;
		int portNumber;

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
					ex.printStackTrace();
					clientSocket.close();
					return;
				}
				System.out.print("Enter the second number: ");
				try {
					secondNumber = Integer.parseInt(inFromUser.readLine());
					try{
						/* Send numbers to server */
						outToServer.writeBytes(Integer.toString(firstNumber) + '\n' + secondNumber + '\n');
						/* Read answer from server */
						result = inFromServer.readLine();

						System.out.println("Result computed by the server: " + result);

						clientSocket.close();
					}
					catch (SocketException ex){
						System.err.println("The connection was reset or lost");
					}
				} catch (NumberFormatException ex) {
					System.err.println("Invalid number!");
					clientSocket.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					clientSocket.close();
				}

			} catch (Exception ex) {
				System.err.println("Connection refused! Check address and port and retry\n");
			}
		} catch (NumberFormatException ex){
			System.err.println("Port number not valid.\n");
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
