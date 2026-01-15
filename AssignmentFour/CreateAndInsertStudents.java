import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class CreateAndInsertStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "root";

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Create Statement object
            Statement stmt = con.createStatement();

            // SQL query to create Students table
            String createTable =
                    "CREATE TABLE IF NOT EXISTS students (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "branch VARCHAR(20)," +
                    "semester INT," +
                    "percentage DOUBLE," +
                    "year_of_passing INT)";

            // Executing table creation query
            stmt.executeUpdate(createTable);

            // SQL query to insert records
            String insertData =
                    "INSERT INTO students VALUES " +
                    "(1,'Rahul','CSE',7,78.5,2024)," +
                    "(2,'Anita','EC',7,81.0,2025)," +
                    "(3,'Kiran','Civil',6,72.0,2024)";

            // Executing insert query
            stmt.executeUpdate(insertData);

            System.out.println("Table created and records inserted successfully");

            // Closing resources
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
