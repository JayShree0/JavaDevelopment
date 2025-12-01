package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

    // JDBC URL (Corrected spelling: mysql)
    private static final String URL = "jdbc:mysql://localhost:3306/grage";  // No name change as per your request
    private static final String USER = "root";       // Database username
    private static final String PASS = "r6JQT427@";  // Database password

    /**
     * Returns a new database connection.
     * @return Connection object
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }
}
