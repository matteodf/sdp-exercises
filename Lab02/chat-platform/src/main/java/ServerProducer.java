import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerProducer implements Runnable {
    private final ServerQueue queue;
    private BufferedReader inFromServer;
    private final SocketInfo user;

    public ServerProducer(ServerQueue q, SocketInfo s){
        this.queue = q;
        this.user = s;
    }

    public void run(){
        try{
            inFromServer =
                    new BufferedReader(new InputStreamReader(user.getSocket().getInputStream()));

                while (true){
                    try{
                        Message m = new Message(user, readFromServer());
                        if (!m.getStringMessage().equals("null")){
                            queue.putMessage(m);
                        }
                    } catch (IOException ex){
                        System.err.println("CONNECTION LOST! Client from address " + user.getSocket().getInetAddress().getHostAddress() + ", port " + user.getSocket().getPort() + " was disconnected");
                        Message m = new Message(user, "disconnected");
                        queue.putMessage(m);
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
        return inFromServer.readLine();
    }
}
