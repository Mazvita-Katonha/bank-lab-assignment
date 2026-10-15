
    public class SavingsAccount extends Account {
    private double minimumBalance;
    private double interestRate; // e.g., 0.02 for 2%

    // Constructor
    public SavingsAccount(String accountNumber, double balance, double minimumBalance, double interestRate) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    // Override withdraw to enforce minimum balance rule
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return;
        }
        
        if (balance - amount < minimumBalance) {
            System.out.println("Transaction Rejected for Account " + accountNumber + 
                               ": Withdrawal of $" + amount + " would breach the minimum balance requirement of $" + minimumBalance);
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Savings Account " + accountNumber + ". New Balance: $" + balance);
        }
    }

    // Override endOfMonth to add interest earned
    @Override
    public void endOfMonth() {
        double interestEarned = balance * interestRate;
        balance += interestEarned;
        System.out.println("Savings Account " + accountNumber + " processed for month-end. Interest added: $" + interestEarned + ". New Balance: $" + balance);
    }
}


