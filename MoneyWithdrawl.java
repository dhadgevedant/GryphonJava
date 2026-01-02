public class MoneyWithdrawl {
    
    private int balance = 1000;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println("Withdrawing " + amount);
            balance -= amount;
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of " + amount);
        }
    }

    public static void main(String[] args) {
        MoneyWithdrawl account = new MoneyWithdrawl();

        Thread t1 = new Thread(() -> account.withdraw(700));
        Thread t2 = new Thread(() -> account.withdraw(500));

        t1.start();
        t2.start();
    }
}
