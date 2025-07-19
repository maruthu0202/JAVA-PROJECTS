import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankSystem {
    private String name;
    private String accNo;
    private double balance;

    public BankSystem(String name, String accNo, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("⚠️ Deposit amount must be positive.");
        } else {
            balance += amount;
            System.out.println("✅ ₹" + amount + " deposited successfully.");
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("⚠️ Withdrawal amount must be positive.");
        } else if (amount > balance) {
            throw new InsufficientBalanceException("❌ Insufficient balance for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        }
    }

    public void showBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to Java Bank ===");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your account number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter initial deposit: ₹");
        double initial = sc.nextDouble();

        BankSystem bank = new BankSystem(name, accNo, initial);
        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double dep = sc.nextDouble();
                    bank.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double with = sc.nextDouble();
                    try {
                        bank.withdraw(with);
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    bank.showBalance();
                    break;
                case 4:
                    System.out.println("🏦 Thank you for using Java Bank.");
                    break;
                default:
                    System.out.println("❗ Invalid option. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
