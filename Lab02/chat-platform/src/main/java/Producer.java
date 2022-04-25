import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Producer implements Runnable {
    private final Queue queue;
    private Socket clientSocket = null;
    private BufferedReader inFromServer;

    /* Initialization of keyboard input */
    BufferedReader inFromUser =
            new BufferedReader(new InputStreamReader(System.in));

    public Producer(Queue q){
        this.queue = q;
    }

    public Producer(Queue q, Socket s){
        this.queue = q;
        this.clientSocket = s;
    }

    public void run(){
        try{
            if (clientSocket != null){
                //If socket is null the consumer is the one that reads messages from the server and adds them to the queue
                inFromServer =
                        new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                while (true){
                    try{
                        String s = readFromServer();
                        queue.putString(s);
                    } catch (IOException ex){
                        System.err.println("CONNECTION LOST! Try to restart the client.");
                        return;
                    } catch (Exception ex){
                        ex.printStackTrace();
                        return;
                    }
                }
            } else {
                //Else it is the consumer that reads messages from the client console and adds them to the local queue
                while (true){
                    try{
                        String message = readFromConsole();
                        if (message.equals("null") || message.equals("disconnected") || message.equals("connected") || message.isEmpty()){
                            System.err.println("ERROR! Invalid message, try again");
                            continue;
                        }
                        queue.putString(message);
                    } catch (Exception ex){
                        ex.printStackTrace();
                        return;
                    }
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public String readFromConsole() throws IOException {
        return inFromUser.readLine();
    }

    public String readFromServer() throws IOException {
        return inFromServer.readLine();
    }
}
