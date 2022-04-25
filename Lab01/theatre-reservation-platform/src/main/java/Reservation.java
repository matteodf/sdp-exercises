class Reservation {
    private Integer reservedSeats = 0;
    private final Object lock = new Object();

    public Integer getFreeSeats(){
        Integer totalTickets = 10;
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
