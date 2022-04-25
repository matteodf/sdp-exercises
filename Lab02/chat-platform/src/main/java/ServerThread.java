public class ServerThread extends Thread {
    private final ServerQueue serverQueue;
    private final SocketInfo user;

    // the constructor argument is an established socket and the server queue
    public ServerThread(SocketInfo s, ServerQueue q) {
        user = s;
        serverQueue = q;
    }

    public void run() {
        try {

            /* Initialization of the producer that reads messages from socket and adds them to queue */
            ServerProducer inputProducer = new ServerProducer(serverQueue, user);
            /* Initialization of the producer that broadcast messages to socket */
            ServerConsumer outputConsumer = new ServerConsumer(serverQueue);

            // Start of threads bound to a socket
            new Thread(inputProducer).start();
            new Thread(outputConsumer).start();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}