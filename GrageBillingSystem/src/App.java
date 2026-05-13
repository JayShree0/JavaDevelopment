import entity.Customer;
import entity.Vehicle;
import service.BillingService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BillingService service = new BillingService();

        while (true) {
            System.out.println("\n=== GARAGE BILLING SYSTEM ===");
            System.out.println("1. Add Customer & Vehicle");
            System.out.println("2. Generate Invoice");
            System.out.println("3. Show All Invoices");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            int ch;
            try {
                ch = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            try {
                switch (ch) {
                    case 1:
                        System.out.print("Customer name: ");
                        String name = sc.nextLine().trim();

                        System.out.print("Phone: ");
                        String phone = sc.nextLine().trim();

                        Customer c = new Customer(0, name, phone);
                        int cid = service.customerService.addCustomer(c);
                        if (cid <= 0) {
                            System.out.println("Failed to add customer.");
                            break;
                        }

                        System.out.print("Vehicle Number (plate): ");
                        String vnum = sc.nextLine().trim();

                        System.out.print("Model: ");
                        String model = sc.nextLine().trim();

                        Vehicle v = new Vehicle(0, cid, vnum, model);
                        int vid = service.vehicleService.addVehicle(v);
                        if (vid <= 0) {
                            System.out.println("Failed to add vehicle.");
                        } else {
                            System.out.println("Saved Customer ID=" + cid + " Vehicle ID=" + vid);
                        }
                        break;

                    case 2:
                        System.out.print("Enter Customer Id: ");
                        int custId = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter Vehicle Id: ");
                        int vehId = Integer.parseInt(sc.nextLine().trim());

                        // show services
                        System.out.println("Available services:");
                        service.serviceService.getAllServices().forEach(s -> System.out.println(s));

                        System.out.print("Number of services to add: ");
                        int n = Integer.parseInt(sc.nextLine().trim());

                        List<Integer> sids = new ArrayList<>();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Enter Service ID: ");
                            sids.add(Integer.parseInt(sc.nextLine().trim()));
                        }

                        service.createInvoice(custId, vehId, sids);
                        break;

                    case 3:
                        service.showAllInvoices();
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (SQLException ex) {
                System.out.println("Database error: " + ex.getMessage());
                ex.printStackTrace();
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}