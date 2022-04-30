package student;

import com.google.gson.Gson;

import student.StudentOuterClass.Student;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;

class Client {

	public static void main(String[] argv) throws IOException{

		System.out.println("Welcome to the Student Platform. We are sending your data to the University server.");

		Socket s = new Socket("localhost", 6789);

		/*Initialization of the student data with protocol buffer*/
		Student student =
				Student.newBuilder()
						.setName("Fabio")
						.setSurname("Rossi")
						.setYearOfBirth(1996)
						.setIdNumber(888323)
						.setResidence(
								Student.Residence.newBuilder()
										.setStreetName("Via del Campo, 38")
										.setCapValue(20100)
										.setCityName("Milano")
										.setProvinceName("MI")
						)
						.addExam(
								Student.Exam.newBuilder()
										.setExamName("Distributed and Pervasive System")
										.setExamDate("January 8, 2020")
										.setMark(29)
						)
						.addExam(
								Student.Exam.newBuilder()
										.setExamName("Advanced Programming")
										.setExamDate("June 23, 2021")
										.setMark(18)
						)
						.addExam(
								Student.Exam.newBuilder()
										.setExamName("Basic Programming")
										.setExamDate("September 1, 2022")
										.setMark(21)
						).build();

		/* Initialization of a student with GSon */
		JSONResidence studentResidence = new JSONResidence("Via del Campo, 38", 20100, "Milano", "MI");
		ArrayList<JSONExam> exams = new ArrayList<>();
		JSONExam exam1 = new JSONExam("Distributed and Pervasive System", LocalDate.of(2020, 1, 8), 29);
		exams.add(exam1);
		JSONExam exam2 = new JSONExam("Advanced Programming", LocalDate.of(2021, 6, 23), 18);
		exams.add(exam2);
		JSONExam exam3 = new JSONExam("Basic Programming", LocalDate.of(2022, 9, 1), 21);
		exams.add(exam3);
		JSONStudent studentJSON = new JSONStudent("Fabio", "Rossi", 1996, studentResidence, 888323, exams);

		/* JSON format the PersonalData structure related to the student */
		Gson gson = new Gson();
		String studentJson = gson.toJson(studentJSON);

		/* Sends protocol buffer */
		student.writeTo(s.getOutputStream());

		/* Calculate data saving */
		double byteSaved = studentJson.getBytes().length - student.toByteArray().length;

		System.out.println("\n================ DATA SAVING ================");
		System.out.println("PROTO total dimension: " + student.toByteArray().length + " bytes");
		System.out.println("JSON total dimension: " + studentJson.getBytes().length + " bytes");
		System.out.println("With protocol buffer, you sent " + String.format("%.2f", ((byteSaved / studentJson.getBytes().length)*100)) + "% less data than JSON");
		System.out.println("=============================================");

		s.close();
	}
}
