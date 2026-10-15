public abstract class Account {
    protected String accountNumber;
    protected double balance;

    // Constructor
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Concrete deposit method rejecting non-positive amounts
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited $" + amount + " into Account " + accountNumber + ". New Balance: $" + balance);
    }

    // Concrete getter for balance
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void withdraw(double amount);
    public abstract void endOfMonth();
}
