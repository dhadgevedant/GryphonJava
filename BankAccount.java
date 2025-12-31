 public class BankAccount {
    //simulate banking operations using constructors and methods
    private String accountHolderName;
    private String accountNumber;
    private double balance; 
    // Constructor to initialize bank account
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;  
    }
    // Meathod to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");     
        }
    }   
    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {      
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
    // Method to check balance
    public double getBalance() {
        return balance;
    }
    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", "123456789", 1000.0);
        account.displayAccountDetails();
        account.deposit(500.0);
        account.withdraw(200.0);
        System.out.println("Final Balance: $" + account.getBalance());
    }
}

/*
public class BankApp {
    public static void main(String[] args) {

        // Creating object (Real customer account)
        BankAccount account = new BankAccount(10101, "Sachin", 50000, 1234);

        System.out.println("Account No: " + account.getAccountNumber());
        System.out.println("Name: " + account.getAccountHolderName());

        account.deposit(10000);
        account.withdraw(8000, 1234);

        System.out.println("Balance: " + account.getBalance(1234));

        // Wrong PIN test
        System.out.println("Balance: " + account.getBalance(1111));
    }
}

class BankAccount {

    //  Private data (Hidden)
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private int pin;

    // Constructor (Initialization)
    public BankAccount(int accountNumber, String name,
    		double balance, int pin) {
        this.accountNumber = accountNumber;
        this.accountHolderName = name;
        this.balance = balance;
        this.pin = pin;
    }

    //  Read-only access
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    //  Controlled balance access
    public double getBalance(int enteredPin) {
        if (enteredPin == pin) {
            return balance;
        } else {
            System.out.println("Invalid PIN!");
            return 0;
        }
    }

    //  Deposit with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    //  Withdraw with rules
    public void withdraw(double amount, int enteredPin) {
        if (enteredPin != pin) {
            System.out.println("Invalid PIN!");
            return;
        }

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
};
*/