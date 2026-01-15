import java.io.Serializable;

public abstract class Account implements Serializable {
    private int accountNumber;
    private String accountHolderName;
    protected double balance;

    // Constructor
    public Account(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Encapsulation using getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Method Overloading (Compile-time Polymorphism)
    public void deposit(double amount) {
        balance += amount;
    }

    public void deposit(double amount, String mode) {
        balance += amount;
        System.out.println("Deposited via " + mode);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    // Abstract method
    public abstract void calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + accountHolderName);
        System.out.println("Balance        : " + balance);
    }
}
