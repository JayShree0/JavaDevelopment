import java.util.HashMap;
import java.util.Map;

public class UserService {

    // -------------------------------
    // Data members
    // -------------------------------

    // username -> User mapping
    // (Map me store karenge ki kaunsa username kis User object se linked hai)
    private Map<String, User> userMap = new HashMap<>();

    // current login user ka reference (null if no one is logged in)
    private User currentUser = null;


    // -------------------------------
    // Register new user
    // -------------------------------
    public boolean registerUser(String username, String password, String fullName, String contact) {
        // Step 1: check if username already exist karta hai
        if (userMap.containsKey(username)) {
            System.out.println("Username already exist/taken, Please choose another");
            return false; // registration failed
        }

        // Step 2: agar username available hai -> new User object banayenge
        User user = new User(username, password, fullName, contact);

        // Step 3: userMap me store karenge (key = username, value = User object)
        userMap.put(username, user);
        System.out.println("Registration Successful..");
        return true;
    }


    // -------------------------------
    // Login user
    // -------------------------------
    public boolean loginUser(String username, String password) {
        // Step 1: check if username exist hi nahi karta
        if (!userMap.containsKey(username)) {
            System.out.println("No User found with this username");
            return false; // login failed
        }

        // Step 2: user object fetch karenge map se
        User user = userMap.get(username);

        // Step 3: check password match
        if (!user.getPassword().equals(password)) {
            System.out.println("Incorrect password");
            return false; // login failed
        }

        // Step 4: login successful -> currentUser ko set karenge
        currentUser = user;
        System.out.println("Welcome : " + currentUser.getFullName() + " !");
        return true;
    }


    // -------------------------------
    // Logout user
    // -------------------------------
    void logOutUser() {
        if (currentUser != null) {
            System.out.println("Logged Out " + currentUser.getFullName());
        }
        // logout hone ke baad currentUser null ho jayega
        currentUser = null;
    }


    // -------------------------------
    // Utility Methods
    // -------------------------------

    // Current logged-in user return karega
    public User getCurrentUser() {
        return currentUser;
    }

    // Check if koi user login hai ya nahi
    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
