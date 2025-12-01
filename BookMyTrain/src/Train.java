@SuppressWarnings("ALL")
public class Train {

    // -------------------------------
    // Instance variables (state of Train object)
    // -------------------------------
    private int trainId;          // unique ID for train
    private String name;          // train ka naam
    private String source;        // starting station
    private String destination;   // ending station

    private int totalSeats;       // total seats in train
    private int availableSeats;   // currently available seats (dynamic value)

    // -------------------------------
    // Constructor: new Train banate time initization hota hai
    // totalSeats hi initially availableSeats ke barabar hoga
    // -------------------------------
    public Train(int trainId, String name, String source, String destination,int totalSeats){
        this.trainId = trainId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;  // initially sab seats available
    }

    // -------------------------------
    // Getters & Setters (Encapsulation)
    // -------------------------------
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // -------------------------------
    // Book seats method
    // Agar requested seats availableSeats se kam ya barabar hain
    // to booking successful hogi aur availableSeats reduce ho jayenge
    // warna booking fail (false return)
    // -------------------------------
    public boolean bookedSeats(int count){
        if(count <= availableSeats) {
            availableSeats = availableSeats - count;
            return true;  // booking successful
        } else {
            return false; // booking failed
        }
    }

    // -------------------------------
    // Cancel seats method
    // Cancel hone par availableSeats wapas increase ho jayenge
    // -------------------------------
    public void cancelSeats(int count) {
        availableSeats = availableSeats + count;
    }

    // -------------------------------
    // toString() override
    // Jab Train object ko print karenge to readable string milegi
    // instead of default memory reference
    // -------------------------------
    @Override
    public String toString(){
        return trainId + " | " + name + " | " + source + " -> " + destination +
                " | Seat Available: " + availableSeats;
    }
}
