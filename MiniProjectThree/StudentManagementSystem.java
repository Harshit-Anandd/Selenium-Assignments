import java.util.*;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Student> students = new HashMap<>();

    // Login credentials
    static final String USERNAME = "admin";
    static final String PASSWORD = "student123";

    public static void main(String[] args) {

        if (!login()) {
            System.out.println("Invalid login credentials. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n--- STUDENT MANAGEMENT MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Eno");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student by Eno");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> displayStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateBranch();
                    case 5 -> deleteStudent();
                    case 6 -> displaySortedStudents();
                    case 7 -> {
                        System.out.println("Exiting Student Management System...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch (InvalidStudentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Login system
    static boolean login() {
        System.out.print("Username: ");
        String user = sc.next();
        System.out.print("Password: ");
        String pass = sc.next();
        return user.equals(USERNAME) && pass.equals(PASSWORD);
    }

    // Add Student
    static void addStudent() throws InvalidStudentException {

        System.out.print("Enter Enrollment Number: ");
        int eno = sc.nextInt();

        if (students.containsKey(eno))
            throw new InvalidStudentException("Enrollment number must be unique");

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();
        if (branch.isEmpty())
            throw new InvalidStudentException("Branch cannot be empty");

        System.out.print("Enter Semester: ");
        int sem = sc.nextInt();

        System.out.print("Enter Percentage: ");
        double perc = sc.nextDouble();
        if (perc <= 0)
            throw new InvalidStudentException("Percentage must be positive");

        students.put(eno, new Student(eno, name, branch, sem, perc));
        System.out.println("Student added successfully");
    }

    // Display all students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available");
            return;
        }

        for (Student s : students.values()) {
            s.display();
        }
    }

    // Search student
    static void searchStudent() {
        System.out.print("Enter Enrollment Number: ");
        int eno = sc.nextInt();

        Student s = students.get(eno);
        if (s != null)
            s.display();
        else
            System.out.println("Student not found");
    }

    // Update student branch
    static void updateBranch() throws InvalidStudentException {
        System.out.print("Enter Enrollment Number: ");
        int eno = sc.nextInt();

        Student s = students.get(eno);
        if (s == null)
            throw new InvalidStudentException("Student not found");

        sc.nextLine();
        System.out.print("Enter New Branch: ");
        String branch = sc.nextLine();
        if (branch.isEmpty())
            throw new InvalidStudentException("Branch cannot be empty");

        s.setBranch(branch);
        System.out.println("Branch updated successfully");
    }

    // Delete student
    static void deleteStudent() throws InvalidStudentException {
        System.out.print("Enter Enrollment Number: ");
        int eno = sc.nextInt();

        if (students.remove(eno) == null)
            throw new InvalidStudentException("Student not found");

        System.out.println("Student deleted successfully");
    }

    // Display sorted students by percentage
    static void displaySortedStudents() {
        List<Student> list = new ArrayList<>(students.values());

        list.sort(Comparator.comparingDouble(Student::getPercentage).reversed());

        for (Student s : list) {
            s.display();
        }
    }
}
