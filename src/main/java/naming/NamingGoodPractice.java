package naming;

import java.util.HashMap;
import java.util.Map;

public class NamingGoodPractice {

    static class PaymentHandler {

        private static final double MAX_TRANSACTION_AMOUNT = 100.0;

        private final String paymentGateway;
        private final Map<String, Double> transactionHistory;

        public PaymentHandler(String paymentGateway) {
            this.paymentGateway = paymentGateway;
            this.transactionHistory = new HashMap<>();
        }

        public void processPayment(String customerName, double amount) {
            System.out.println("Processing payment of $" + amount + " for customer " + customerName + " via " + paymentGateway);
            validateTransactionAmount(amount);
            transactionHistory.put(customerName, transactionHistory.getOrDefault(customerName, 0.0) + amount);
        }

        public void validateTransactionAmount(double amount) {
            if (amount > MAX_TRANSACTION_AMOUNT) {
                throw new RuntimeException("Cannot process more than " + MAX_TRANSACTION_AMOUNT + " per transaction");
            }
        }

        public void refundPayment(String customerName, double amount) {
            System.out.println("Refunding $" + amount + " for customer " + customerName);
            double currentBalance = transactionHistory.getOrDefault(customerName, 0.0);
            validateSufficientBalanceForRefund(currentBalance, amount);
            transactionHistory.put(customerName, currentBalance - amount);
        }

        public void validateSufficientBalanceForRefund(double currentBalance, double amount) {
            if (currentBalance < amount) {
                throw new RuntimeException("Insufficient balance to refund.");
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
