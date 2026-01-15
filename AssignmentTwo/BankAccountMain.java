import java.util.Scanner;

// Interface for basic banking operations
interface BankingOperations {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

// Interface for customer-related operations
interface CustomerOperations {
    void displayCustomerDetails();
}

// BankAccount class implementing multiple interfaces
class BankAccount implements BankingOperations, CustomerOperations {

    private String customerName;
    private int accountNumber;
    private double balance;

    // Constructor to initialize customer details
    BankAccount(String customerName, int accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Deposit operation with validation
    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid deposit amount");
        balance += amount;
    }

    // Withdraw operation with balance check
    public void withdraw(double amount) {
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
    }

    // Display current balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Display customer details
    public void displayCustomerDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Number: " + accountNumber);
    }
}

class BankAccountMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount account = new BankAccount(name, accNo);

        while (true) {
            System.out.println("\n1.Deposit 2.Withdraw 3.Balance 4.Details 5.Exit");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        account.deposit(sc.nextDouble());
                        break;
                    case 2:
                        account.withdraw(sc.nextDouble());
                        break;
                    case 3:
                        account.checkBalance();
                        break;
                    case 4:
                        account.displayCustomerDetails();
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