import java.util.Random;

// Enumeration type to describe animals species
enum AnimalSpecies {DOG, CAT};

public class Animal extends Thread {
	private AnimalSpecies animalSpecies;
	private Integer id;
	private WaitingRoom waitRoom;

	public Animal(boolean species, Integer i, WaitingRoom w) {
		// Chooses the species based on a random boolean
		if (species){
			animalSpecies = AnimalSpecies.CAT;
		} else {
			animalSpecies = AnimalSpecies.DOG;
		}
		id = i;
		waitRoom = w;
	}

	// Getter function that retrieves the animal species
	public AnimalSpecies getSpecies(){
		return animalSpecies;
	}

	public void run() {
		try{
			System.out.println("Thread " + id + ": a " + animalSpecies.toString().toLowerCase() + " wants to enter the waiting room" );
			waitRoom.enterRoom(this);
			System.out.println("Thread " + id + ": the " + animalSpecies.toString().toLowerCase() + " entered the waiting room" );
			wasteSomeTime();
			System.out.println("Thread " + id + ": the " + animalSpecies.toString().toLowerCase() + " is exiting the waiting room" );
			waitRoom.leaveRoom(this);
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}

	// Function that randomly assigns the time in which the animal stays in the waiting room
	private void wasteSomeTime(){
		Random rnd = new Random();
		Integer seconds = rnd.nextInt(10) + 1;
		try {
			Thread.sleep(seconds*1000);
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}