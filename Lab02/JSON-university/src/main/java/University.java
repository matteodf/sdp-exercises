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

					/* Initialization of the output stream to the socket */
					DataOutputStream outToClient =
							new DataOutputStream(connectionSocket.getOutputStream());

					// Gets a JSON string and return a PersonalData structure, printing it with the proper method.
					String studentJson = inFromClient.readLine();
					PersonalData student = gson.fromJson(studentJson, PersonalData.class);
					System.out.println(student.printPersonalData());

					// Calculates the average grade, prints it on console and returns it to the client
					double averageGrade = 0.;
					int counterExam = 0;

					for (Exam ex : student.getExams()){
						counterExam++;
						averageGrade += ex.getMark();
					}

					if (counterExam != 0){
						System.out.println("Average grade: " + String.format("%.2f", (averageGrade / counterExam)));
					}
					outToClient.writeBytes("University received the data. Your average is " + String.format("%.2f", (averageGrade / counterExam)) + "\n");

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
