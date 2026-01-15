import java.util.Scanner;

class BankAccount {

    // Declaring instance variables
    private String name;
    private int accNo;
    private double balance;

    // Constructor to initialize account details
    BankAccount(String name, int accNo) {
        this.name = name;
        this.accNo = accNo;
        this.balance = 0;
    }

    // Method to deposit amount
    void deposit(double amount) {

        // Validating deposit amount
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid deposit amount");

        balance += amount;
    }

    // Method to withdraw amount
    void withdraw(double amount) {

        // Checking sufficient balance
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient balance");

        balance -= amount;
    }

    // Method to display account details
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Account No: " + accNo);
        System.out.println("Balance: " + balance);
    }
}

class BankManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Reading account holder details
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        // Creating BankAccount object
        BankAccount acc = new BankAccount(name, accNo);

        // Menu-driven loop
        while (true) {

            System.out.println("\n1.Deposit 2.Withdraw 3.Balance 4.Details 5.Exit");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        acc.deposit(sc.nextDouble());
                        break;

                    case 2:
                        acc.withdraw(sc.nextDouble());
                        break;

                    case 3:
                        acc.display();
                        break;

                    case 4:
                        acc.display();
                        break;

                    case 5:
                        return; // Exit program
                }
            }
            // Handling runtime exceptions
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}