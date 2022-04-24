import java.net.Socket;

public class SocketInfo {
    private final Socket connection;
    private final String nickname;

    SocketInfo(Socket c, String n){
        this.connection = c;
        this.nickname = n;
    }

    public Socket getSocket(){
        return connection;
    }

    public String getNickname(){
        return nickname;
    }
}
