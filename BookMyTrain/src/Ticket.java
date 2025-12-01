public class Ticket {

    // Unique ID for each ticket
    private int ticketId;

    // User who booked the ticket
    // Using a User object allows us to easily access all user details from the ticket
    private User user;

    // Train for which the ticket is booked
    private Train train;

    // Number of seats booked in this ticket
    private int seatBooked;

    // Static counter to generate unique ticket IDs starting from 1001
    private static int counter = 1001;

    // Constructor to initialize a ticket with a user, train, and number of seats
    public Ticket(User user, Train train, int seatBooked) {
        this.ticketId = counter++; // Assign unique ticket ID and increment counter
        this.user = user;
        this.train = train;
        this.seatBooked = seatBooked;
    }

    // Getter and Setter methods for all fields

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        this.seatBooked = seatBooked;
    }

    // Static getter and setter for counter
    // Useful if we need to reset or access the current ticket number
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    // Override toString to provide a meaningful string representation of the ticket
    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
                " | Train: " + train.getName() +
                " | Route: " + train.getSource() + " -> " + train.getDestination() +
                " | Seats: " + seatBooked +
                " | Booked By: " + user.getFullName();
    }
}
