import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

class MultiServer {

	public static void main(String[] argv) {
		Reservation reservation = new Reservation();

		/* Initialization of the keyboard input */

		try{
			/* Create a "listening socket" on the specified port */
			ServerSocket welcomeSocket = new ServerSocket(6789);
			System.out.println("Connection initialized on port 6789");
			while(true) {
				try{
					Socket connectionSocket = welcomeSocket.accept();
					String clientAddress = connectionSocket.getInetAddress().getHostAddress();
					int clientPort = connectionSocket.getPort();
					System.out.println("CONNECTION! Client connected from address " + clientAddress + ", port " + clientPort);

					// thread creation passing the established socket as arg
					ServerThread theThread =
							new ServerThread(connectionSocket, reservation);

					// start of the thread
					theThread.start();
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
