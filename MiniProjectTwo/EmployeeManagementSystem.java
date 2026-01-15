import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Employee> employees = new HashMap<>();
    static final String FILE_NAME = "employees.dat";

    // Hardcoded login credentials
    static final String USERNAME = "admin";
    static final String PASSWORD = "admin123";

    public static void main(String[] args) {

        loadData();

        if (!login()) {
            System.out.println("Invalid login. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n--- EMPLOYEE MANAGEMENT MENU ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees (By Salary)");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> displayEmployees();
                    case 3 -> searchEmployee();
                    case 4 -> updateSalary();
                    case 5 -> deleteEmployee();
                    case 6 -> displaySortedEmployees();
                    case 7 -> displayDepartments();
                    case 8 -> {
                        saveData();
                        System.out.println("Exiting system...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch (InvalidEmployeeException e) {
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

    // Add Employee
    static void addEmployee() throws InvalidEmployeeException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        if (employees.containsKey(id))
            throw new InvalidEmployeeException("Employee ID must be unique");

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        if (dept.isEmpty())
            throw new InvalidEmployeeException("Department cannot be empty");

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        if (salary <= 0)
            throw new InvalidEmployeeException("Salary must be positive");

        employees.put(id, new Employee(id, name, dept, salary));
        saveData();
        System.out.println("Employee added successfully");
    }

    // Display all employees
    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        for (Employee e : employees.values()) {
            e.display();
        }
    }

    // Search employee
    static void searchEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Employee e = employees.get(id);
        if (e != null)
            e.display();
        else
            System.out.println("Employee not found");
    }

    // Update salary
    static void updateSalary() throws InvalidEmployeeException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Employee e = employees.get(id);
        if (e == null)
            throw new InvalidEmployeeException("Employee not found");

        System.out.print("Enter new salary: ");
        double salary = sc.nextDouble();
        if (salary <= 0)
            throw new InvalidEmployeeException("Salary must be positive");

        e.setSalary(salary);
        saveData();
        System.out.println("Salary updated");
    }

    // Delete employee
    static void deleteEmployee() throws InvalidEmployeeException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        if (employees.remove(id) == null)
            throw new InvalidEmployeeException("Employee not found");

        saveData();
        System.out.println("Employee deleted");
    }

    // Display sorted employees by salary
    static void displaySortedEmployees() {
        List<Employee> list = new ArrayList<>(employees.values());
        list.sort(Comparator.comparingDouble(Employee::getSalary));

        for (Employee e : list) {
            e.display();
        }
    }

    // Display unique departments
    static void displayDepartments() {
        Set<String> depts = new TreeSet<>();
        for (Employee e : employees.values()) {
            depts.add(e.getDepartment());
        }
        System.out.println("Departments:");
        for (String d : depts) {
            System.out.println(d);
        }
    }

    // File Handling
    static void saveData() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    static void loadData() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (Map<Integer, Employee>) ois.readObject();
        } catch (Exception ignored) {}
    }
}
