import java.sql.*;

public class InsertUsingPreparedStatementDemo {

    /*
     * Steps to perform JDBC operations:
     * 1. Load the driver class.
     * 2. Establish a connection to the database.
     * 3. Create a statement.
     * 4. Execute a query.
     * 5. Process the results.
     * 6. Close the connection.
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection to the database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd", "root", "r6JQT427@");

            // Step 3: Create a statement object to execute SQL queries
            Statement statement = con.createStatement();

            // Step 4: Write SQL query
            String query = "INSERT INTO student (id, stdName, age) values (?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(query);


            pstmt.setInt(1, 106);
            pstmt.setString(2, "Jayshree");
            pstmt.setInt(3, 24);
            pstmt.executeUpdate();

            pstmt.setInt(1, 104);
            pstmt.setString(2, "Jayshree");
            pstmt.setInt(3, 27);
            pstmt.executeUpdate();


            pstmt.setInt(1, 105);
            pstmt.setString(2, "Patel");
            pstmt.setInt(3, 29);
            pstmt.executeUpdate();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
