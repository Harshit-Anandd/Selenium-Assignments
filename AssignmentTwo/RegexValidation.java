import java.util.Scanner;
import java.util.regex.Pattern;

class RegexValidation {

    // Method to validate using regex
    static boolean validate(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Mobile 2.Email 3.Username 4.Password 5.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Mobile Number: ");
                        if (validate(sc.nextLine(), "[6-9][0-9]{9}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Mobile Number");
                        break;

                    case 2:
                        System.out.print("Enter Email ID: ");
                        if (validate(sc.nextLine(), "^[A-Za-z0-9+_.-]+@(.+)$"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Email ID");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        if (validate(sc.nextLine(), "[A-Za-z]{5,}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Username");
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        if (validate(sc.nextLine(), "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Password");
                        break;

                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
    }
}