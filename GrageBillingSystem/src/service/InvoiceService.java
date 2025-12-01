package service;

import config.DbConfig;
import entity.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    /**
     * Inserts a new invoice row into database.
     */
    public void addInvoice(Invoice invoice) throws SQLException {

        Connection conn = DbConfig.getConnection();

        // Insert statement for invoice
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO invoices (customer_id, vehicle_id, service_id) VALUES (?,?,?)"
        );

        // Set values from object
        ps.setInt(1, invoice.getCustomerId());
        ps.setInt(2, invoice.getVehicleId());
        ps.setInt(3, invoice.getServiceId());

        // Execute insert
        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    /**
     * Retrieves all invoices from DB.
     * @return List<Invoice>
     */
    public List<Invoice> getAllInvoice() throws SQLException {

        List<Invoice> list = new ArrayList<>();

        Connection conn = DbConfig.getConnection();
        Statement st = conn.createStatement();

        // Fetch all invoices
        ResultSet rs = st.executeQuery("SELECT * FROM invoices");

        // Convert DB row → Invoice object
        while (rs.next()) {
            list.add(new Invoice(
                    rs.getInt("id"),          // invoice id
                    rs.getInt("customer_id"), // customer id
                    rs.getInt("vehicle_id"),  // vehicle id
                    rs.getInt("service_id")   // service id
            ));
        }

        rs.close();
        st.close();
        conn.close();

        return list;
    }
}
