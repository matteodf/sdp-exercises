import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.util.ArrayList;

class Student {

	public static void main(String[] argv) {

		/* Initialization of a students */
		Residence studentResidence = new Residence("Via del Campo, 38", 20100, "Milano", "MI");
		ArrayList<Exam> exams = new ArrayList<>();
		Exam exam1 = new Exam("Distributed and Pervasive System", LocalDate.of(2020, 1, 8), 29);
		exams.add(exam1);
		Exam exam2 = new Exam("Advanced Programming", LocalDate.of(2021, 6, 23), 18);
		exams.add(exam2);
		Exam exam3 = new Exam("Basic Programming", LocalDate.of(2022, 9, 1), 21);
		exams.add(exam3);
		PersonalData student = new PersonalData("Fabio", "Rossi", 1996, studentResidence, 888323, exams);

		System.out.println("Welcome to the Student Platform. We are sending your data to the University server.");

		try {
			Socket clientSocket = new Socket("localhost", 6789);
			/* Initialization of the output stream to the socket */
			DataOutputStream outToServer =
					new DataOutputStream(clientSocket.getOutputStream());

			Gson gson = new Gson();
			String studentJson = gson.toJson(student);

			outToServer.writeBytes(studentJson + '\n');

		} catch (Exception ex) {
			System.err.println("Connection refused!\n");
		}
	}
}
