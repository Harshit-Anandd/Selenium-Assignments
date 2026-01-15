import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class DeleteCivilStudents {

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

            // SQL delete query with multiple conditions
            String deleteQuery =
                    "DELETE FROM students " +
                    "WHERE year_of_passing = 2024 AND branch = 'Civil'";

            // Execute delete query
            int rows = stmt.executeUpdate(deleteQuery);

            // Display affected rows
            System.out.println(rows + " Civil student records deleted");

            // Close resources
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
