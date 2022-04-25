import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerProducer implements Runnable {
    private final ServerQueue queue;
    private BufferedReader inFromClient;
    private final SocketInfo user;

    public ServerProducer(ServerQueue q, SocketInfo s){
        this.queue = q;
        this.user = s;
    }

    // Server consumer adds messages coming from client to the server queue in order to broadcast them to all the clients
    public void run(){
        try{
            inFromClient =
                    new BufferedReader(new InputStreamReader(user.getSocket().getInputStream()));

            while (true){
                try{
                    Message m = new Message(user, readFromServer());

                    // Checks if the message is not null, because when the client fails it sends null strings to server
                    if (!m.getMessage().equals("null")){
                        // Adds the message to the queue
                        queue.putMessage(m);
                    }

                } catch (IOException ex){
                    // Catch if the client disconnects, and send a message that results in notify all client about the disconnection.
                    System.err.println("CONNECTION LOST! Client from address " + user.getSocket().getInetAddress().getHostAddress() + ", port " + user.getSocket().getPort() + " was disconnected");
                    Message m = new Message(user, "disconnected");
                    queue.putMessage(m);
                    // Deletes the connection from the active connections
                    queue.closeConnection(user);
                    return;
                } catch (Exception ex){
                    ex.printStackTrace();
                    return;
                }
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public String readFromServer() throws IOException {
        return inFromClient.readLine();
    }
}
