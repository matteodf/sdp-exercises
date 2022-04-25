import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private final String message;
    private final String formattedDate;
    private final SocketInfo user;

    // When a new message is created, the date is automatically set to the current time
    Message(SocketInfo u, String m){
        user = u;
        message = m;
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formattedDate = date.format(format);
    }

    // Getter function to retrieve the user
    public SocketInfo getSender(){
        return user;
    }

    // Function to get the formatted message
    public String getFormattedMessage(){
        String formattedMessage = "---------- NEW MESSAGE ----------\n";
        formattedMessage += "On " + formattedDate + ", "+ user.getNickname() + " wrote:\n";
        formattedMessage += message + "\n";
        formattedMessage +=  "---------------------------------";
        return formattedMessage;
    }

    // Function to get only the message string
    public String getMessage(){
        return message;
    }
}
