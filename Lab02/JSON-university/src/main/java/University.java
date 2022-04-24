import com.google.gson.Gson;

import java.io.*;
import java.net.*; 

class University {

	public static void main(String[] argv) {
		Gson gson = new Gson();

		try{
			/* Create a "listening socket" on the specified port */
			ServerSocket welcomeSocket = new ServerSocket(6789);
			System.out.println("Connection initialized on port 6789");
			while(true) {
				try{
					Socket connectionSocket = welcomeSocket.accept();
					String clientAddress = connectionSocket.getInetAddress().getHostAddress();
					int clientPort = connectionSocket.getPort();
					System.out.println("CONNECTION! Client connected from address " + clientAddress + ", port " + clientPort + '\n');
					BufferedReader inFromClient =
							new BufferedReader(
									new InputStreamReader(connectionSocket.getInputStream()));

					String studentJson = inFromClient.readLine();
					PersonalData student = gson.fromJson(studentJson, PersonalData.class);
					System.out.println(student.getPersonalData());
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
	}
}
