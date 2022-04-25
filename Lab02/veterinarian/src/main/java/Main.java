import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] argv) throws Exception {
		ArrayList<Thread> threads = new ArrayList<>();
		WaitingRoom w = new WaitingRoom(4);
		int totalAnimals;

		/* Initialization of keyboard input */
		BufferedReader inFromUser =
				new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the number of animals that wish to enter the room: ");

		try {
			totalAnimals = Integer.parseInt(inFromUser.readLine());
		} catch (NumberFormatException ex){
			System.err.println("Invalid number!");
			return;
		} catch (Exception ex){
			ex.printStackTrace();
			return;
		}

		for (int i=0; i<totalAnimals; i++){
			Random rd = new Random();
			Animal an = new Animal(rd.nextBoolean(), i, w);
			threads.add(an);
		}

		System.out.println("All the animals are ready.\n");

		for (Thread t : threads){
			t.start();
		}

		for (Thread t : threads){
			t.join();
		}

		System.out.println("\nThere are no more animals in the queue.");

	}
}
