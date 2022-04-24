public class ServerConsumer implements Runnable {
    private final ServerQueue queue;

    public ServerConsumer(ServerQueue q){
        this.queue = q;
    }

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
