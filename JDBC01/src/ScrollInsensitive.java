import java.sql.*;

public class ScrollInsensitive {

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
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);

            // Step 4: Write SQL query
            String query = "SELECT * FROM student";

            // Step 5: Execute the query and store the result
            ResultSet res = statement.executeQuery(query);

            System.out.println("-------Scroll insensitive, read only------");

            res.last();
            System.out.println("Last Row: " + res.getInt("id"));
            System.out.println("Last Row: " + res.getString("stdName"));

            res.first();
            System.out.println("first Row: " + res.getInt("id"));
            System.out.println("first Row: " + res.getString("stdName"));

            res.absolute(2);
            System.out.println("absolute(any specific) Row: " + res.getInt("id"));
            System.out.println("absolute(any specific) Row: " + res.getString("stdName"));

//            // Step 6: Display the fetched data
//            System.out.println("----------- Read Data -----------");
//            while (res.next()) {
//                System.out.println(
//                        res.getInt("id") + " | " +
//                                res.getString("stdName") + " | " +
//                                res.getInt("age")
//                );
//            }

            // Step 7: Close connections
            res.close();
            statement.close();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
