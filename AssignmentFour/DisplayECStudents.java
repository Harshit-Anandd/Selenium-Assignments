import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class DisplayECStudents {

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

            // SQL query to fetch EC students of semester 7
            String selectQuery =
                    "SELECT * FROM students " +
                    "WHERE semester = 7 AND branch = 'EC'";

            // Execute select query
            ResultSet rs = stmt.executeQuery(selectQuery);

            // Display records row by row
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("branch") + " " +
                        rs.getInt("semester") + " " +
                        rs.getDouble("percentage") + " " +
                        rs.getInt("year_of_passing")
                );
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
