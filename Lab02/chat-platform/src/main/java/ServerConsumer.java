public class ServerConsumer implements Runnable {
    private final ServerQueue queue;

    public ServerConsumer(ServerQueue q){
        this.queue = q;
    }

    // Server consumer that sends in broadcast the messages to all the clients
    public void run(){
        try{
            while (true){
                try{
                    queue.sendString();
                } catch (Exception ex){
                    ex.printStackTrace();
                    return;
                }
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
