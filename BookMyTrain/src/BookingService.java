import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class BookingService {
    // Stores all trains in the system
    private List<Train> trainList = new ArrayList<>();

    // Stores all booked tickets
    private List<Ticket> ticketList = new ArrayList<>();

    // Constructor: preload some train data into the system
    public BookingService() {
        trainList.add(new Train(101,"Rajdhani Express","Delhi","Nagpur",100));
        trainList.add(new Train(102,"Shatabdi Express","Delhi","Mumbai",60));
        trainList.add(new Train(103,"Durunto Express","Agra","Delhi",70));
        trainList.add(new Train(104,"Vande Bharat Express","Delhi","Goa",100));
        trainList.add(new Train(105,"Intercity","Kolkata","Manali",90));
        trainList.add(new Train(106,"Tejas Express","Delhi","Bengaluru",80));
    }

    // Search trains by source and destination
    public List<Train> searchTrain(String source, String destination) {
        List<Train> res = new ArrayList<>();
        // Loop through all trains and check if source & destination match
        for(Train train : trainList) {
            if(train.getSource().equalsIgnoreCase(source) &&
                    train.getDestination().equalsIgnoreCase(destination)) {
                res.add(train); // add matching train to result list
            }
        }
        return res; // return all matched trains
    }

    // Book a ticket for a given trainId and seatCount
    public Ticket bookTicket(User user, int trainId, int seatCount) {

        // Loop through all trains in trainList one by one
        for(Train train : trainList) {
            // Check if this trainId matches the given trainId
            if(train.getTrainId() == trainId) {
                // Try to book seats
                if(train.bookedSeats(seatCount)) {
                    // If booking successful, create a new ticket
                    Ticket ticket = new Ticket(user, train, seatCount);
                    ticketList.add(ticket); // add ticket to ticket list
                    return ticket; // return ticket object
                }
                // If not enough seats available
                else {
                    System.out.println("No enough seat available");
                    return null;
                }
            }
        }
        // If no train with the given trainId is found
        System.out.println("trainId not found");
        return null;
    }

    // Get all tickets booked by a specific user
    public List<Ticket> getTicketByUser(User user) {
        List<Ticket> res = new ArrayList<>();
        // Loop through all tickets
        for(Ticket ticket : ticketList) {
            // Check if this ticket belongs to the given user
            if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())) {
                res.add(ticket); // add to result
            }
        }
        return res; // return all tickets of this user
    }

    // Cancel a booked ticket by ticketId and user
    public boolean cancelTicket(int ticketId, User user) {
        // Iterator is used for safe traversal and removal of elements from ticketList
        Iterator<Ticket> iterator = ticketList.listIterator();

        // Loop through all tickets in the ticketList
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next(); // get next ticket

            // Check if the ticket matches the given ticketId and belongs to the same user
            if (ticket.getTicketId() == ticketId &&
                    ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())) {

                // Free the seats in the train (because the booking is being cancelled)
                Train train = ticket.getTrain();
                train.cancelSeats(ticket.getSeatBooked());

                // Safely remove the ticket from ticketList using iterator
                iterator.remove();

                // Confirmation message
                System.out.println("Ticket " + ticketId + " cancelled Successfully");
                return true; // cancellation successful
            }
        }

        // If no matching ticket found for this user
        System.out.println("Ticket not found or does not belong to current user");
        return false; // cancellation failed
    }

    // Display all trains available in the system
    public void listAllTrains() {
        System.out.println("List of all trains");
        for(Train train : trainList) {
            System.out.println(train); // calls Train.toString()
        }
    }
}
