import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private final String message;
    private final String formattedDate;
    private final SocketInfo user;

    Message(SocketInfo u, String m){
        user = u;
        message = m;
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formattedDate = date.format(format);
    }

    public SocketInfo getSender(){
        return user;
    }

    public String getMessage(){
        return "---------- NEW MESSAGE ----------\nOn " + formattedDate + ", " + user.getNickname() + " wrote: \n" + message + "\n---------------------------------";
    }

    public String getStringMessage(){
        return message;
    }
}
