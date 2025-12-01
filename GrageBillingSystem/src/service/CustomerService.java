package service;

import config.DbConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    /**
     * Inserts a new customer into database.
     * @param customer Customer object
     */
    public void addCustomer(Customer customer) throws SQLException {

        // Create database connection
        Connection conn = DbConfig.getConnection();

        // Prepared statement to prevent SQL injection
        PreparedStatement ps =
                conn.prepareStatement("INSERT INTO customers (name, phone) VALUES (?, ?)");

        // Replace placeholders with actual values
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getPhone());

        // Execute query
        ps.executeUpdate();

        // Close resources
        ps.close();
        conn.close();
    }

    /**
     * Fetches all customers from database.
     * @return List of Customer
     */
    public List<Customer> getAllCustomer() throws SQLException {

        List<Customer> list = new ArrayList<>();

        // Establish connection
        Connection conn = DbConfig.getConnection();

        // Create a statement to execute query
        Statement st = conn.createStatement();

        // Execute SELECT query
        ResultSet rs = st.executeQuery("SELECT * FROM customers");

        // Convert each row into Customer object
        while (rs.next()) {
            list.add(new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone")
            ));
        }

        return list; // connection auto-closes when program ends
    }

    public Customer getCustomersBasedOnNum(String number) throws SQLException {

        Customer customer = new Customer();

        // Establish connection
        Connection conn = DbConfig.getConnection();

        // Create a statement to execute query
        Statement st = conn.createStatement();

        // Execute SELECT query
        ResultSet rs = st.executeQuery("SELECT * FROM customers where phone = " + number );

        // Convert each row into Customer object
        while (rs.next()) {
            customer = new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone")
            );
        }

        return customer; // connection auto-closes when program ends
    }

}
