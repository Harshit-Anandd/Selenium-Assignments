public class CurrentAccount extends Account {

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void calculateInterest() {
        // No interest for current account
        System.out.println("No interest for Current Account");
    }
}
