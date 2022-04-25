import java.util.ArrayList;

public class Queue {
    private final ArrayList<String> buffer = new ArrayList<>();
    private final Object lock = new Object();

    // Function that adds a new message to the queue buffer
    public void putString(String message){
        synchronized (lock){
            buffer.add(message);
            lock.notify();
        }
    }

    // Function that retrieves new messages from the buffer
    public String getString(){
        synchronized (lock){
            String message;
            while(buffer.size() == 0){
                try{
                    lock.wait();
                } catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            message = buffer.get(0);
            buffer.remove(0);
            return message;
        }
    }
}
