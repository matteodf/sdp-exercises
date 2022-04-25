import java.io.DataOutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Vector;

public class ServerQueue {
    private final Object lock = new Object();
    private final Vector<SocketInfo> connections = new Vector<>();
    private final ArrayList<Message> serverBuffer = new ArrayList<>();

    // Function that adds a new connection to the list of all clients connected to the server
    public void addConnection(SocketInfo s){
        connections.add(s);
    }

    // Function that removes a client from the list of connections
    public void closeConnection(SocketInfo s){
        connections.removeElement(s);
    }

    // Function that adds a new message to the server queue
    public void putMessage (Message message){
        synchronized (lock){
            serverBuffer.add(message);
            lock.notify();
        }
    }

    // Function that broadcasts the messages from the queue to all clients
    public void sendString(){
        synchronized (lock){
            try{
                Message message;
                if (serverBuffer.size()>0){
                    message = serverBuffer.get(0);

                    //Sends a disconnection notification if the client disconnected
                    if (message.getMessage().equals("disconnected")){
                        for (SocketInfo s : connections){
                            // Don't send the message to the sender itself
                            if (message.getSender() == s){
                                continue;
                            }
                            try {
                                DataOutputStream outToClient = new DataOutputStream(s.getSocket().getOutputStream());
                                outToClient.writeBytes(message.getSender().getNickname() + " left the chat" + '\n');
                            } catch (SocketException ex){
                                System.err.println("ERROR! Couldn't deliver message to address " + s.getSocket().getInetAddress().getHostAddress() + ", port " + s.getSocket().getPort());
                            } catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    } else if (message.getMessage().equals("connected")){
                        for (SocketInfo s : connections){
                            // Don't send the message to the sender itself
                            if (message.getSender() == s){
                                continue;
                            }
                            try {
                                DataOutputStream outToClient = new DataOutputStream(s.getSocket().getOutputStream());
                                outToClient.writeBytes(message.getSender().getNickname() + " joined the chat" + '\n');
                            } catch (SocketException ex){
                                System.err.println("ERROR! Couldn't deliver message to address " + s.getSocket().getInetAddress().getHostAddress() + ", port " + s.getSocket().getPort());
                            } catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    } else {
                        for (SocketInfo s : connections){
                            // Don't send the message to the sender itself
                            if (message.getSender() == s){
                                continue;
                            }
                            try {
                                DataOutputStream outToClient = new DataOutputStream(s.getSocket().getOutputStream());
                                outToClient.writeBytes(message.getFormattedMessage() + '\n');
                            } catch (SocketException ex){
                                // If the client is unreachable it prints an error
                                System.err.println("ERROR! Couldn't deliver message to address " + s.getSocket().getInetAddress().getHostAddress() + ", port " + s.getSocket().getPort());
                            } catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    }
                    // After the broadcast, it removes the message and notify
                    serverBuffer.remove(0);
                    lock.notify();
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
