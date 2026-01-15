import java.util.*;
import java.util.regex.Pattern;

// Student model
class UniStudent {
    int id;
    String name;
    String course;
    int marks;

    UniStudent(int id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String toString() {
        return id + " " + name + " " + course + " " + marks;
    }
}

class UniversityManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Using ArrayList to store students
        List<UniStudent> students = new ArrayList<>();

        // Set to store unique course names
        Set<String> courses = new HashSet<>();

        // Map for quick student lookup
        Map<Integer, UniStudent> studentMap = new HashMap<>();

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Remove 4.Search 5.Sort 6.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        int id = sc.nextInt();
                        sc.nextLine();

                        String name = sc.nextLine();
                        String course = sc.nextLine();
                        int marks = sc.nextInt();

                        if (!Pattern.matches("[A-Za-z ]+", name))
                            throw new Exception("Invalid Name");

                        UniStudent s = new UniStudent(id, name, course, marks);
                        students.add(s);
                        courses.add(course);
                        studentMap.put(id, s);
                        break;

                    case 2:
                        students.forEach(System.out::println);
                        break;

                    case 3:
                        int rid = sc.nextInt();
                        students.removeIf(st -> st.id == rid);
                        studentMap.remove(rid);
                        break;

                    case 4:
                        System.out.println(studentMap.get(sc.nextInt()));
                        break;

                    case 5:
                        students.sort(Comparator.comparingInt(st -> st.marks));
                        break;

                    case 6:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}