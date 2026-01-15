public class SavingsAccount extends Account {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Method Overriding (Runtime Polymorphism)
    @Override
    public void calculateInterest() {
        double interest = balance * 0.04;
        balance += interest;
    }
}
