public class User {

    // -------------------------------
    // Instance variables (User details)
    // -------------------------------
    private String username;   // unique username for login
    private String password;   // user password (⚠ should be encrypted in real apps)
    private String fullName;   // user full name
    private String contact;    // user contact info (mobile/email)

    // -------------------------------
    // Constructor: object create karte hi initialize hoga
    // -------------------------------
    public User(String username, String password, String fullName, String contact){
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.contact = contact;
    }

    // -------------------------------
    // Getters & Setters (Encapsulation)
    // Ye methods se fields ko access/modify karte hain
    // -------------------------------
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // -------------------------------
    // toString() override
    // Jab User object ko print karenge to readable output milega
    // Example: "John Doe (john123)"
    // instead of default memory reference
    // -------------------------------
    @Override
    public String toString() {
        return fullName + " (" + username + ")";
    }
}
