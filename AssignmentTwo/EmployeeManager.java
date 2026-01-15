import java.util.*;
import java.util.regex.Pattern;

// Employee class
class Employee {
    int empId;
    String name;

    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public String toString() {
        return empId + " - " + name;
    }
}

class EmployeeManager {

    public static void main(String[] args) {

        // HashMap allows null key and null values
        Map<Integer, Employee> hashMap = new HashMap<>();

        // Hashtable does NOT allow null
        Map<Integer, Employee> hashtable = new Hashtable<>();

        // TreeMap stores data in sorted order
        Map<Integer, Employee> treeMap = new TreeMap<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Search 4.Remove 5.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        if (!Pattern.matches("[A-Za-z ]+", name))
                            throw new Exception("Invalid Name");

                        Employee emp = new Employee(id, name);

                        hashMap.put(id, emp);
                        hashtable.put(id, emp);
                        treeMap.put(id, emp);
                        break;

                    case 2:
                        System.out.println(treeMap);
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        System.out.println(hashMap.get(sc.nextInt()));
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        int rid = sc.nextInt();
                        hashMap.remove(rid);
                        hashtable.remove(rid);
                        treeMap.remove(rid);
                        break;

                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}