package meaningfulNames;

import java.util.HashMap;
import java.util.Map;

public class MeaningfulNamesBadPractice {

    static class Handler {

        private static final double MAX_AMOUNT = 100.0;

        private final String provider;
        private final Map<String, Double> transactions;

        public Handler(String provider) {
            this.provider = provider;
            this.transactions = new HashMap<>();
        }

        public void pay(String customerName, double amount) {
            System.out.println("Pmt process $" + amount + " for customer " + customerName + " via " + provider);
            check(amount);
            transactions.put(customerName, transactions.getOrDefault(customerName, 0.0) + amount);
        }

        public void check(double amount) {
            if (amount > MAX_AMOUNT) {
                throw new RuntimeException("Cannot process more than " + MAX_AMOUNT + " per transaction");
            }
        }

        public void returnBack(String customerName, double amount) {
            System.out.println("Refund $" + amount + " for customer " + customerName);
            double currentAmount = transactions.getOrDefault(customerName, 0.0);
            checkEnoughAmount(currentAmount, amount);
            transactions.put(customerName, currentAmount - amount);
        }

        public void checkEnoughAmount(double currentAmount, double amount) {
            if (currentAmount < amount) {
                throw new RuntimeException("Insufficient balance to refund.");
            }
        }

        public void getReceipt(String customerName) {
            double total = transactions.getOrDefault(customerName, 0.0);
            System.out.println("Generating receipt for customer " + customerName + " for total $" + total);
        }

        public static void main(String[] args) {
            Handler ph = new Handler("Stripe");
            ph.pay("Alice", 100.0);
            ph.pay("Bob", 150.0);
            ph.returnBack("Alice", 50.0);
            ph.getReceipt("Alice");
            ph.getReceipt("Bob");
        }
    }

}
