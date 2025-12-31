public class Payment {
    
    //demonstrate use of interface by offering different payment methods as upi, card, netbanking
    interface PaymentMethod {
        void pay(double amount);
        void processPayment(double amount);
    }
    class UpiPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Processing UPI payment of $" + amount);
            processPayment(amount);
        }

        @Override
        public void processPayment(double amount) {
            System.out.println("UPI payment of $" + amount + " completed successfully.");
        }
    }
    class CardPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Processing Card payment of $" + amount);
            processPayment(amount);
        }

        @Override
        public void processPayment(double amount) {
            System.out.println("Card payment of $" + amount + " completed successfully.");
        }
    }
    class NetBankingPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Processing Net Banking payment of $" + amount);
            processPayment(amount);
        }   
        @Override
        public void processPayment(double amount) {
            System.out.println("Net Banking payment of $" + amount + " completed successfully.");
        }
    }   

    //main meathod to demonstrate payment methods using a menue and user input
    public static void main(String[] args) {
        Payment paymentDemo = new Payment();
        PaymentMethod upi = paymentDemo.new UpiPayment();
        PaymentMethod card = paymentDemo.new CardPayment();
        PaymentMethod netBanking = paymentDemo.new NetBankingPayment(); 
        double amount = 150.0;
        upi.pay(amount);
        card.pay(amount);
        netBanking.pay(amount);
    }
}
