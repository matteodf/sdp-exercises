import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class Consumer implements Runnable {
    private final Queue queue;
    private boolean useSocket = false;
    private Socket clientSocket = null;
    private DataOutputStream outToServer;

    public Consumer(Queue q){
        this.queue = q;
    }

    public Consumer(Queue q, Socket s){
        this.queue = q;
        this.useSocket = true;
        this.clientSocket = s;
    }

    public void run(){
        try{
            if (useSocket){
                outToServer =
                        new DataOutputStream(clientSocket.getOutputStream());

                while (true){
                    try{
                        sendToServer(queue.getString());
                    } catch (SocketException ex){
                        System.err.println("Connection lost! Try to restart the client.");
                        clientSocket.close();
                        return;
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            } else {
                while (true){
                    try{
                        printToConsole(queue.getString());
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

    public void printToConsole(String message){
        System.out.println(message);
    }

    public void sendToServer(String message) throws IOException {
        outToServer.writeBytes(message + '\n');
    }
}
