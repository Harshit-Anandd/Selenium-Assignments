import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class UpdateCSEPercentage {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "root";

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Create statement
            Statement stmt = con.createStatement();

            // SQL query to increase percentage by 5% for CSE branch
            String updateQuery =
                    "UPDATE students " +
                    "SET percentage = percentage + (percentage * 0.05) " +
                    "WHERE branch = 'CSE'";

            // Execute update query
            int rows = stmt.executeUpdate(updateQuery);

            // Display number of rows affected
            System.out.println(rows + " CSE student records updated");

            // Close resources
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
