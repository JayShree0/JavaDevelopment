package service;

import java.util.List;

import entity.Invoice;
import java.sql.SQLException;

public class BillingService {

    // Customer related operations
    public CustomerService customerService = new CustomerService();

    // Invoice related operations
    public InvoiceService invoiceService = new InvoiceService();

    /**
     * Creates multiple invoice entries for each selected service.
     */
    public void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) throws SQLException {

        // Loop through each service and insert invoice row
        String sids = " ";
        for (int serviceId : serviceIds) {
            sids += serviceId;
        }
        invoiceService.addInvoice(new Invoice(0, customerId, vehicleId, Integer.parseInt(sids)));

        System.out.println("Invoice generated successfully....");
    }

    /**
     * Shows all invoices stored in DB.
     */
    public void showAllInvoices() throws SQLException {

        // Fetch invoices
        List<Invoice> invoices = invoiceService.getAllInvoice();

        // Display them
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }
}
