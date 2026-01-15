import java.util.*;
import java.util.regex.Pattern;

// Student class
class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public String toString() {
        return rollNo + " - " + name;
    }
}

class StudentRecordManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Using List interface with ArrayList
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Remove 4.Search 5.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Roll No: ");
                        int roll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        // REGEX validation for name
                        if (!Pattern.matches("[A-Za-z ]+", name))
                            throw new Exception("Invalid Name");

                        students.add(new Student(roll, name));
                        break;

                    case 2:
                        for (Student s : students)
                            System.out.println(s);
                        break;

                    case 3:
                        System.out.print("Enter Roll No to remove: ");
                        int r = sc.nextInt();
                        students.removeIf(s -> s.rollNo == r);
                        break;

                    case 4:
                        System.out.print("Enter Roll No to search: ");
                        int sr = sc.nextInt();
                        for (Student s : students)
                            if (s.rollNo == sr)
                                System.out.println(s);
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