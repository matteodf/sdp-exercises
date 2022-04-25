import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

class Client {

	public static void main(String[] argv) {
		int freeSeats;
		int ticketsNumber;
		int result;

		/* Initialization of keyboard input */
		BufferedReader inFromUser =
			new BufferedReader(new InputStreamReader(System.in));


		try {
			Socket clientSocket = new Socket("localhost", 6789);
			/* Initialization of the output stream to the socket */
			DataOutputStream outToServer =
					new DataOutputStream(clientSocket.getOutputStream());

			/* Initialization of the input stream from the socket */
			BufferedReader inFromServer =
					new BufferedReader(new
							InputStreamReader(clientSocket.getInputStream()));

			System.out.println("Welcome to the Reserving Seats Platform!");
			try{
				freeSeats = Integer.parseInt(inFromServer.readLine());
				if (freeSeats == -1){
					System.out.println("Sorry, all seats were already booked.");
					clientSocket.close();
					return;
				} else {
					System.out.println("Remaining seats: " + freeSeats);
				}

				/* Parameters insertion */
				System.out.print("Enter the number of seats you wish to reserve: ");
				try {
					ticketsNumber = Integer.parseInt(inFromUser.readLine());
				} catch (NumberFormatException ex) {
					System.err.println("Invalid number!");
					clientSocket.close();
					return;
				} catch (Exception ex) {
					ex.printStackTrace();
					clientSocket.close();
					return;
				}

				if (ticketsNumber <= 0){
					System.err.println("Invalid number of tickets. Try again");
					clientSocket.close();
				} else {
					try{
						/* Send numbers to server */
						outToServer.writeBytes(Integer.toString(ticketsNumber) + '\n');
						/* Read answer from server */
						try{
							result = Integer.parseInt(inFromServer.readLine());
							if (result == -1){
								System.err.println("ERROR! There are not enough tickets. Try again.");
							} else {
								System.out.println("Tickets purchased!");
							}
						} catch (NumberFormatException ex){
							System.err.println();
						}

						clientSocket.close();
					}
					catch (SocketException ex){
						System.err.println("The connection was reset or lost");
					}
				}
			} catch (NumberFormatException ex) {
				System.err.println("Invalid response from server!");
				clientSocket.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				clientSocket.close();
			}


		} catch (Exception ex) {
			System.err.println("Connection refused!\n");
		}
	}
}
