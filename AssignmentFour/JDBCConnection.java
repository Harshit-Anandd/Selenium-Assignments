import java.sql.Connection;
import java.sql.DriverManager;

class JDBCConnection {

    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "root";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Attempt to establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // If connection object is not null, connection is successful
            if (con != null) {
                System.out.println("Connection Successful");
            }

            // Closing connection
            con.close();

        } catch (Exception e) {
            // If any exception occurs, connection failed
            System.out.println("Unable to connect");
        }
    }
}
