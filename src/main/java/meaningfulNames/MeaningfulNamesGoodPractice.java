package meaningfulNames;

import java.util.HashMap;
import java.util.Map;

public class MeaningfulNamesGoodPractice {

    static class PaymentHandler {

        private final String paymentGateway;
        private final Map<String, Double> transactionHistory;

        public PaymentHandler(String paymentGateway) {
            this.paymentGateway = paymentGateway;
            this.transactionHistory = new HashMap<>();
        }

        public void processPayment(String customerName, double amount) {
            System.out.println("Processing payment of $" + amount + " for customer " + customerName + " via " + paymentGateway);
            transactionHistory.put(customerName, transactionHistory.getOrDefault(customerName, 0.0) + amount);
        }

        public void refundPayment(String customerName, double amount) {
            System.out.println("Refunding $" + amount + " for customer " + customerName);
            double currentBalance = transactionHistory.getOrDefault(customerName, 0.0);
            if (currentBalance >= amount) {
                transactionHistory.put(customerName, currentBalance - amount);
            } else {
                System.out.println("Insufficient balance to refund.");
            }
        }

        public void generateReceipt(String customerName) {
            double totalAmount = transactionHistory.getOrDefault(customerName, 0.0);
            System.out.println("Generating receipt for customer " + customerName + " for total amount $" + totalAmount);
        }

        public static void main(String[] args) {
            PaymentHandler paymentHandler = new PaymentHandler("Stripe");
            paymentHandler.processPayment("Alice", 100.0);
            paymentHandler.processPayment("Bob", 150.0);
            paymentHandler.refundPayment("Alice", 50.0);
            paymentHandler.generateReceipt("Alice");
            paymentHandler.generateReceipt("Bob");
        }
    }

}
