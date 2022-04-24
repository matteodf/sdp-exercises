public class ServerThread extends Thread {
    private final ServerQueue serverQueue;
    private final SocketInfo user;

    // the constructor argument is an established socket
    public ServerThread(SocketInfo s, ServerQueue q) {
        user = s;
        serverQueue = q;
    }

    public void run() {
        String clientAddress = user.getSocket().getInetAddress().getHostAddress();
        int clientPort = user.getSocket().getPort();
        try {
            /* Initialization of the producer that reads messages from socket and adds them to queue */
            ServerProducer inputProducer = new ServerProducer(serverQueue, user);
            /* Initialization of the producer that sends messages to socket */
            ServerConsumer outputConsumer = new ServerConsumer(serverQueue);

            // Start of threads bound to a socket
            new Thread(inputProducer).start();
            new Thread(outputConsumer).start();

        } catch (NumberFormatException ex){
            System.err.println("ERROR! Client from address " + clientAddress +  ", port " + clientPort + ": the provided number was either not valid or the client terminated the connection.");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}