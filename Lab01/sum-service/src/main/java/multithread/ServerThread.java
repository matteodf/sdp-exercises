package multithread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ServerThread extends Thread {
	private final Socket connectionSocket;
	private BufferedReader inFromClient;
	private DataOutputStream outToClient;

	// the constructor argument is an established socket
	public ServerThread(Socket s) {
		connectionSocket = s;
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
		String sum;
		int clientFirstNumber;
		int clientSecondNumber;
		String clientAddress = connectionSocket.getInetAddress().getHostAddress();
		int clientPort = connectionSocket.getPort();
		try{
			/* Read line from client */
			clientFirstNumber = Integer.parseInt(inFromClient.readLine());
			clientSecondNumber = Integer.parseInt(inFromClient.readLine());
			sum = Integer.toString(clientFirstNumber + clientSecondNumber) + '\n';
			try{
				/* Send answer to client */
				outToClient.writeBytes(sum);
				System.out.println("SUCCESS! Client from address " + clientAddress +  ", port " + clientPort + ": result send successfully!");
				connectionSocket.close();
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
		catch (NumberFormatException ex){
			System.err.println("ERROR! Client from address " + clientAddress +  ", port " + clientPort + ": the provided number was either not valid or the client terminated the connection.");
		} catch (SocketException ex){
			System.err.println("ERROR! Client from address " + clientAddress +  ", port " + clientPort + ": the connection was reset or lost");
		}  catch (Exception ex){
			ex.printStackTrace();
		}
	}
}