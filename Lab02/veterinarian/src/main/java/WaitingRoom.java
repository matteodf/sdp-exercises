class WaitingRoom {
    // Parameters definition
    private Integer maxDogNumber = 4;
    private Integer maxCatNumber = 1;
    private Integer currentDogNumber;
    private Integer currentCatNumber;
    private Object lock = new Object();

    // This allows overriding the constraints when constructing the waiting room
    WaitingRoom(Integer maxDog, Integer maxCat){
        maxDogNumber = maxDog;
        maxCatNumber = maxCat;
        currentDogNumber = 0;
        currentCatNumber = 0;
    }

    // Enter room function takes animal as a parameter to check requirements
    public void enterRoom(Animal animal){
        // wait and notify are related to the synchronization object
        synchronized (lock){
            /* Checks animal species and checks requirements:
                • A cat can’t enter the waiting room if there is already a dog or a cat
                • A dog can’t enter the waiting room if there is a cat
                • There can’t be more than four dogs together
               If they are respected, increments the current number related to that species
            */
            if (animal.getSpecies() == AnimalSpecies.CAT){
                while (currentCatNumber >= 1 || currentDogNumber >= 1){
                    try{
                        lock.wait();
                    } catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                currentCatNumber++;
            } else {
                while (currentCatNumber >= 1 || currentDogNumber >= maxDogNumber){
                    try{
                        lock.wait();
                    } catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                currentDogNumber++;
            }
        }
    }

    // Enter room function takes animal as a parameter to check what counter needs to be decremented
    public void leaveRoom(Animal animal){
        // notifyAll is related to the synchronization object
        synchronized (lock){
            if (animal.getSpecies() == AnimalSpecies.CAT){
                currentCatNumber--;
            } else {
                currentDogNumber--;
            }
            lock.notifyAll();
        }
    }
}
