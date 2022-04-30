import student.StudentOuterClass.Student;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

	public static void main(String[] args) throws IOException {

		System.out.println("Connection initialized on port 6789\n");
		ServerSocket serverSocket = new ServerSocket(6789);

		Socket s = serverSocket.accept();

		Student student = Student.parseFrom(s.getInputStream());

		System.out.println(student);
	}
}
