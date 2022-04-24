import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Producer implements Runnable {
    private final Queue queue;
    private boolean useSocket = false;
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
        this.useSocket = true;
        this.clientSocket = s;
    }

    public void run(){
        try{
            if (useSocket){
                inFromServer =
                        new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                while (true){
                    try{
                        String s = readFromServer();
                        if (s != null){
                            queue.putString(s);
                        }
                    } catch (IOException ex){
                        System.err.println("CONNECTION LOST! Try to restart the client.");
                        return;
                    } catch (Exception ex){
                        ex.printStackTrace();
                        return;
                    }
                }
            } else {
                while (true){
                    try{
                        queue.putString(readFromConsole());
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
