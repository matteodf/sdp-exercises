import java.io.*;
import java.net.*;

class Reservation {
    private Integer totalTickets = 10;
    private Integer reservedSeats = 0;
    private Object lock = new Object();

    public Integer getReservations(){
        if (totalTickets == reservedSeats){
            return 0;
        } else {
            return reservedSeats;
        }
    }

    public Integer getTotalTickets() {
        return totalTickets;
    }

    public Integer getFreeSeats(){
        return totalTickets - reservedSeats;
    }

    public Integer buyTickets(Integer ticketNumber){
        synchronized (lock){
            if (ticketNumber > getFreeSeats()){
                System.err.println("REFUSED REQUEST! There are not enough tickets. Try again.");
                return 0;
            } else {
                reservedSeats += ticketNumber;
                System.out.println("SUCCESS! There are still " + getFreeSeats() +  " tickets available");
                return 1;
            }
        }
    }
}
