import java.util.List;
import java.util.Scanner;

public class IRCTCAPP {

    // Scanner to read user input from console
    private final Scanner scanner = new Scanner(System.in);

    // Service to manage users (registration, login, logout)
    private final UserService userService = new UserService();

    // Service to manage bookings (search trains, book tickets, cancel)
    private final BookingService bookingService = new BookingService();

    // Main method - program starts here
    public static void main(String[] args) {
        // Create IRCTCAPP object and start the application
        new IRCTCAPP().start();
    }

    // Start the application and show main menu
    public void start() {
        while (true) {
            System.out.println("\nWelcome to IRCTC APP");

            // If user is not logged in, show registration/login menu
            if (!userService.isLoggedIn()) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();
                    default -> System.out.println("Invalid choice");
                }
            }
            // If user is already logged in, show user menu
            else {
                showUserMenu();
            }
        }
    }

    // User registration
    public void register() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        System.out.print("Enter full name: ");
        // ⚡ Important: clear the leftover newline from previous next() call
        // If we don’t do this, scanner.nextLine() will capture an empty string
        scanner.nextLine();
        String fullName = scanner.nextLine();

        System.out.print("Enter contact: ");
        String contact = scanner.next();

        userService.registerUser(username, password, fullName, contact);
        System.out.println("Registration successful!");
    }

    // User login
    public void login() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        userService.loginUser(username, password);
    }

    // User menu after login
    private void showUserMenu() {
        while (userService.isLoggedIn()) {
            System.out.println("\n---- User Menu -----");
            System.out.println("1. Search Train");
            System.out.println("2. Book Trains");
            System.out.println("3. View My Tickets");
            System.out.println("4. Cancel Tickets");
            System.out.println("5. View All Trains");
            System.out.println("6. Logout");
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> searchTrain();
                case 2 -> bookTicket();
                case 3 -> viewMyTickets();
                case 4 -> cancelTicket();
                case 5 -> bookingService.listAllTrains();
                case 6 -> userService.logOutUser();
                default -> System.out.println("Invalid choice..");
            }
        }
    }

    // Search trains between source and destination
    public void searchTrain() {
        System.out.print("Enter source station: ");
        String source = scanner.next();

        System.out.print("Enter destination station: ");
        String destination = scanner.next();

        List<Train> trains = bookingService.searchTrain(source, destination);

        // If no train is found
        if (trains.isEmpty()) {
            System.out.println("No train found between " + source + " and " + destination);
            return;
        }

        // If trains found, print all
        System.out.println("Train(s) Found:");
        for (Train train : trains) {
            System.out.println(train); // Uses Train.toString() to print details
        }

        // Ask if user wants to book
        System.out.print("Do you want to book ticket? (yes/no): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter Train ID to book: ");
            int trainId = scanner.nextInt();

            System.out.print("Enter number of seats to book: ");
            int seats = scanner.nextInt();

            Ticket ticket = bookingService.bookTicket(userService.getCurrentUser(), trainId, seats);
            if (ticket != null) {
                System.out.println("Booking successful!");
                System.out.println(ticket);
            }
        } else {
            System.out.println("Returning to user menu...");
        }
    }

    // Book ticket directly from user menu
    private void bookTicket() {
        System.out.print("Enter source station: ");
        String source = scanner.next();

        System.out.print("Enter destination station: ");
        String destination = scanner.next();

        List<Train> trains = bookingService.searchTrain(source, destination);

        if (trains.isEmpty()) {
            System.out.println("No trains available for booking.");
            return;
        }

        System.out.println("Available Trains:");
        for (Train train : trains) {
            System.out.println(train);
        }

        System.out.print("Enter Train ID to book: ");
        int trainId = scanner.nextInt();

        System.out.print("Enter number of seats to book: ");
        int seats = scanner.nextInt();

        Ticket ticket = bookingService.bookTicket(userService.getCurrentUser(), trainId, seats);
        if (ticket != null) {
            System.out.println("Booking successful!");
            System.out.println(ticket);
        }
    }

    // View tickets booked by current user
    private void viewMyTickets() {
        List<Ticket> tickets = bookingService.getTicketByUser(userService.getCurrentUser());
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked yet.");
        }
        else {
            System.out.println("Your Tickets:");
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

    // Cancel ticket by ticket ID
    private void cancelTicket() {
        System.out.print("Enter Ticket ID to cancel: ");
        int ticketId = scanner.nextInt();

        bookingService.cancelTicket(ticketId, userService.getCurrentUser());
    }

    // Exit application
    private void exitApp() {
        System.out.println("Thank you for using IRCTC APP.");
        System.exit(0);
    }
}
