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
