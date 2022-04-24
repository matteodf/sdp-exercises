import java.io.DataOutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Vector;

public class ServerQueue {
    private final Object lock = new Object();
    private final Vector<SocketInfo> connections = new Vector<>();
    private final ArrayList<Message> serverBuffer = new ArrayList<>();

    public void addConnection(SocketInfo s){
        connections.add(s);
    }

    public void closeConnection(SocketInfo s){
        connections.removeElement(s);
    }

    public void putMessage (Message message){
        if (message.getStringMessage().equals("null")){
            return;
        }
        synchronized (lock){
            serverBuffer.add(message);
            lock.notify();
        }
    }

    public void sendString(){
        synchronized (lock){
            try{
                Message message;
                if (serverBuffer.size()>0){
                    message = serverBuffer.get(0);
                    if (message.getStringMessage().equals("disconnected")){
                        for (SocketInfo s : connections){
                            try {
                                DataOutputStream outToClient = new DataOutputStream(s.getSocket().getOutputStream());
                                outToClient.writeBytes("User " + message.getSender().getNickname() + " disconnected from the chat" + '\n');
                            } catch (SocketException ex){
                                System.err.println("ERROR! Couldn't deliver message to address " + s.getSocket().getInetAddress().getHostAddress() + ", port " + s.getSocket().getPort());
                            } catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    } else {
                        for (SocketInfo s : connections){
                            if (message.getSender() == s){
                                continue;
                            }
                            try {
                                DataOutputStream outToClient = new DataOutputStream(s.getSocket().getOutputStream());
                                if (!message.getStringMessage().equals("null")){
                                    outToClient.writeBytes(message.getMessage() + '\n');
                                }
                            } catch (SocketException ex){
                                System.err.println("ERROR! Couldn't deliver message to address " + s.getSocket().getInetAddress().getHostAddress() + ", port " + s.getSocket().getPort());
                            } catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    }
                    serverBuffer.remove(0);
                    lock.notify();
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
