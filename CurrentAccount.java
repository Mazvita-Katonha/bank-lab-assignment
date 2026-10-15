
    
public class CurrentAccount extends Account {
    private double overdraftLimit; // Stored as a positive value representing maximum allowed debt
    private double maintenanceFee;

    // Constructor
    public CurrentAccount(String accountNumber, double balance, double overdraftLimit, double maintenanceFee) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
        this.maintenanceFee = maintenanceFee;
    }

    // Override withdraw to allow negative balance up to the overdraft limit
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return;
        }

        // Available funds include current balance plus the overdraft limit
        if (balance - amount < -overdraftLimit) {
            System.out.println("Transaction Rejected for Account " + accountNumber + 
                               ": Withdrawal of $" + amount + " exceeds the overdraft limit of $" + overdraftLimit);
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Current Account " + accountNumber + ". New Balance: $" + balance);
        }
    }

    // Override endOfMonth to deduct the maintenance fee
    @Override
    public void endOfMonth() {
        balance -= maintenanceFee;
        System.out.println("Current Account " + accountNumber + " processed for month-end. Maintenance fee deducted: $" + maintenanceFee + ". New Balance: $" + balance);
    }
}

