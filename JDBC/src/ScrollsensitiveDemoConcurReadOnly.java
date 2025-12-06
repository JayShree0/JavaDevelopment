import java.sql.*;

public class ScrollsensitiveDemoConcurReadOnly {


    /*
     * Steps to perform JDBC operations:
     * 1. Load the driver class.
     * 2. Establish a connection to the database.
     * 3. Create a statement.
     * 4. Execute a query.
     * 5. Process the results.
     * 6. Close the connection.
     */

    /*
    * To see live updated data from the database while your program is running,
    * you must re-execute the query because MySQL does not support TYPE_SCROLL_SENSITIVE.
    * */

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd", "root", "r6JQT427@");

            // Statement object to execute SQL queries
            Statement st = con.createStatement();

            // SQL query to fetch all students
            String query = "SELECT * FROM student";

            System.out.println("🔄 Live DB Monitoring Started...\n");

            // Infinite loop to refresh data every few seconds
            while (true) {

                // Execute query again → fetch fresh updated data
                ResultSet rs = st.executeQuery(query);

                System.out.println("----------- Current Data -----------");

                // Read each row from the latest ResultSet
                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | " +
                                    rs.getString("stdName") + " | " +
                                    rs.getInt("age")
                    );
                }

                System.out.println("------------------------------------\n");

                // Close ResultSet before next refresh
                rs.close();

                // Wait 5 seconds before fetching data again
                Thread.sleep(5000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
