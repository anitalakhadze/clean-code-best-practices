package lineMargins;

public class LineMarginsBadPractice {

    public static class OrderProcessor {

        public void processOrder(String orderId, String customerName, String customerEmail, String shippingAddress, String billingAddress, double orderTotal, String paymentMethod, String deliveryInstructions, boolean giftWrap, boolean expeditedShipping) {
            System.out.println("Processing order: " + orderId + " for customer: " + customerName + " with total amount: " + orderTotal);
            // Additional processing logic...
        }

    }

}
