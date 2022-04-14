import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
	private Socket connectionSocket = null;
	private BufferedReader inFromClient;
	private DataOutputStream outToClient;
	private Reservation reservation;

	// the constructor argument is an established socket
	public ServerThread(Socket s, Reservation res) {
		connectionSocket = s;
		reservation = res;
		try {
			inFromClient =
					new BufferedReader(
							new InputStreamReader(connectionSocket.getInputStream()));
			outToClient =
					new DataOutputStream(connectionSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		Integer desiredTickets;
		Integer freeSeats;
		Integer result;
		String clientAddress = connectionSocket.getInetAddress().getHostAddress();
		Integer clientPort = connectionSocket.getPort();
		try {
			freeSeats = reservation.getFreeSeats();
			if (freeSeats == 0){
				outToClient.writeBytes(-1 + "\n");
			} else {
				outToClient.writeBytes(freeSeats + "\n");
				try{
					synchronized (reservation){
						desiredTickets = Integer.parseInt(inFromClient.readLine());
						result = reservation.buyTickets(desiredTickets);
						try{
							if (result == 0){
								outToClient.writeBytes(-1 + "\n");
							} else {
								/* Send answer to client */
								outToClient.writeBytes(result + "\n");
							}
							connectionSocket.close();
						} catch (SocketException ex){
							System.err.println("ERROR! Client from address " + clientAddress +  ", port " + clientPort + ": the connection was reset or lost");
						}  catch (Exception ex){
							ex.printStackTrace();
						}
					}
				} catch (NumberFormatException ex){
					System.err.println("ERROR! Client passed a non valid number of tickets or the connection was lost");
				}
			}
		} catch (SocketException ex){
			System.err.println("ERROR! Client from address " + clientAddress +  ", port " + clientPort + ": the connection was reset or lost");
		} catch (NumberFormatException ex){
			System.err.println("ERROR! Client from address " + clientAddress +  ", port " + clientPort + ": the provided number was either not valid or the client terminated the connection.");
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}