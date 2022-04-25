import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class Consumer implements Runnable {
    private final Queue queue;
    private Socket socket = null;
    private DataOutputStream outToServer;

    public Consumer(Queue q){
        this.queue = q;
    }

    public Consumer(Queue q, Socket s){
        this.queue = q;
        this.socket = s;
    }

    public void run(){
        try{
            if (socket != null){
                //If socket is null the consumer is the one that sends messages to the server
                outToServer =
                        new DataOutputStream(socket.getOutputStream());

                while (true){
                    try{
                        sendToServer(queue.getString());
                    } catch (SocketException ex){
                        System.err.println("Connection lost! Try to restart the client.");
                        socket.close();
                        return;
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            } else {
                //Else the consumer is the one that prints the messages to the console
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
