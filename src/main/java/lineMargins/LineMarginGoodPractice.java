package lineMargins;

public class LineMarginGoodPractice {

    public static class OrderProcessor {

        public void processOrder(Order order) {
            System.out.println("Processing order: " + order.getOrderId() +
                    " for customer: " + order.getCustomerName() +
                    " with total amount: " + order.getOrderTotal());
            // Additional processing logic...
        }

    }

    public static class Order {
        private String orderId;
        private String customerName;
        private String customerEmail;
        private String shippingAddress;
        private String billingAddress;
        private double orderTotal;
        private String paymentMethod;
        private String deliveryInstructions;
        private boolean giftWrap;
        private boolean expeditedShipping;

        // Constructor, getters, and setters...

        public Order(String orderId,
                     String customerName,
                     String customerEmail,
                     String shippingAddress,
                     String billingAddress,
                     double orderTotal,
                     String paymentMethod,
                     String deliveryInstructions,
                     boolean giftWrap,
                     boolean expeditedShipping) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.customerEmail = customerEmail;
            this.shippingAddress = shippingAddress;
            this.billingAddress = billingAddress;
            this.orderTotal = orderTotal;
            this.paymentMethod = paymentMethod;
            this.deliveryInstructions = deliveryInstructions;
            this.giftWrap = giftWrap;
            this.expeditedShipping = expeditedShipping;
        }

        public String getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getOrderTotal() {
            return orderTotal;
        }

        // Other getters...
    }


}
