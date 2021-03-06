import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;


class MultiServer {

    public static void main(String[] argv) {
        ServerQueue serverQueue = new ServerQueue();

        try{
            /* Create a "listening socket" on the specified port */
            ServerSocket welcomeSocket = new ServerSocket(6789);
            System.out.println("Connection initialized on port 6789");

            while(true) {
                try{
                    Socket connectionSocket = welcomeSocket.accept();

                    /* Initialization of the input stream from the socket */
                    BufferedReader inFromClient =
                            new BufferedReader(new
                                    InputStreamReader(connectionSocket.getInputStream()));

                    /* Gets the client nickname and initializes a new connection with the SocketInfo structure*/
                    String nickname = inFromClient.readLine();
                    SocketInfo connection = new SocketInfo(connectionSocket, nickname);
                    serverQueue.addConnection(connection);

                    String clientAddress = connectionSocket.getInetAddress().getHostAddress();
                    int clientPort = connectionSocket.getPort();
                    System.out.println("CONNECTION! Client connected from address " + clientAddress + ", port " + clientPort);

                    // thread creation passing the established socket and the server queue as arg
                    ServerThread theThread =
                            new ServerThread(connection, serverQueue);

                    // start of the thread
                    theThread.start();

                    Message m = new Message(connection, "connected");
                    serverQueue.putMessage(m);


                } catch (Exception ex){
                    ex.printStackTrace();
                    return;
                }
            }
        } catch (BindException ex){
            System.err.println("Address not valid or already in use. Try again!\n");
        } catch (IllegalArgumentException ex) {
            System.err.println("Port value out of range. Try again!\n");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}