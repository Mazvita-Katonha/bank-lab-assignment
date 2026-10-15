
    import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        // Create a list containing a mix of account types
        List<Account> accounts = new ArrayList<>();
        
        // SavingsAccount params: accountNumber, initial balance, minimumBalance, interestRate
        accounts.add(new SavingsAccount("SAV-101", 1000.0, 200.0, 0.05));
        
        // CurrentAccount params: accountNumber, initial balance, overdraftLimit, maintenanceFee
        accounts.add(new CurrentAccount("CUR-202", 500.0, 300.0, 15.0));

        System.out.println("=== DEMONSTRATING EDGE CASES ===");
        
        // Edge Case 1: SavingsAccount withdrawal rejection
        System.out.println("\n--- Testing Savings Account Withdrawal Limits ---");
        Account savings = accounts.get(0);
        savings.withdraw(500.0);  // Should succeed (1000 - 500 = 500, which is >= 200)
        savings.withdraw(400.0);  // Should fail (500 - 400 = 100, which is below 200 minimum)

        // Edge Case 2: CurrentAccount going into overdraft within its limit
        System.out.println("\n--- Testing Current Account Overdraft Behavior ---");
        Account current = accounts.get(1);
        current.withdraw(650.0);  // Should succeed, putting balance at -$150 (within -$300 limit)
        current.withdraw(200.0);  // Should fail (-150 - 200 = -350, exceeding the -$300 limit)

        System.out.println("\n=== DEMONSTRATING POLYMORPHIC LOOP ===");
        System.out.println("Executing endOfMonth() on all accounts using parent class reference...\n");
        
        // Loop through the list using the abstract Account reference only
        for (Account acc : accounts) {
            System.out.println("Account type identified by runtime: " + acc.getClass().getSimpleName());
            acc.endOfMonth(); // Polymorphism at work
            System.out.println("----------------------------------------");
        }
    }
}


