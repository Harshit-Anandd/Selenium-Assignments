import java.io.Serializable;

public class Student implements Serializable {

    private int eno;
    private String name;
    private String branch;
    private int semester;
    private double percentage;

    // Constructor
    public Student(int eno, String name, String branch, int semester, double percentage) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.semester = semester;
        this.percentage = percentage;
    }

    // Getters and setters
    public int getEno() {
        return eno;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getPercentage() {
        return percentage;
    }

    // Display student details
    public void display() {
        System.out.println(eno + " | " + name + " | " + branch +
                " | Sem " + semester + " | " + percentage + "%");
    }
}
