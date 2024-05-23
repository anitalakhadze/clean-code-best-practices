package conciseMethods;

import java.util.List;
import java.util.Objects;

public class ConciseMethodsBadPractice {

    public void processOrder(Order order) {
        // Validation logic
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (Objects.isNull(order.getItems()) || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }
        if (Objects.isNull(order.getCustomer())) {
            throw new IllegalArgumentException("Order must have a customer");
        }

        for (OrderItem item : order.getItems()) {
            if (item.quantity() <= 0) {
                throw new IllegalArgumentException("Item quantity must be greater than zero");
            }
            if (item.price() < 0) {
                throw new IllegalArgumentException("Item price cannot be negative");
            }
        }

        // Calculation logic
        double total = 0;
        for (OrderItem item : order.getItems()) {
            double itemTotal = item.quantity() * item.price();
            total += itemTotal;
        }
        double tax = total * 0.1; // Example tax calculation
        double discount = total > 100 ? 10 : 0; // Example discount logic
        double finalTotal = total + tax - discount;

        order.setSubTotal(total);
        order.setTax(tax);
        order.setDiscount(discount);
        order.setTotal(finalTotal);

        // Saving logic
        // Here, we would typically interact with a database
        System.out.println("Saving order to the database...");
        System.out.println("Order Details:");
        System.out.println("Customer: " + order.getCustomer().name());
        System.out.println("Subtotal: $" + total);
        System.out.println("Tax: $" + tax);
        System.out.println("Discount: $" + discount);
        System.out.println("Total: $" + finalTotal);
        System.out.println("Order saved successfully.");
    }

    public static class Order {
        private List<OrderItem> items;
        private Customer customer;
        private double subTotal;
        private double tax;
        private double discount;
        private double total;

        public Order(List<OrderItem> items,
                     Customer customer,
                     double subTotal,
                     double tax,
                     double discount,
                     double total) {
            this.items = items;
            this.customer = customer;
            this.subTotal = subTotal;
            this.tax = tax;
            this.discount = discount;
            this.total = total;
        }

        public List<OrderItem> getItems() {
            return items;
        }

        public Customer getCustomer() {
            return customer;
        }

        public double getSubTotal() {
            return subTotal;
        }

        public double getTax() {
            return tax;
        }

        public double getDiscount() {
            return discount;
        }

        public double getTotal() {
            return total;
        }

        public void setItems(List<OrderItem> items) {
            this.items = items;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public void setSubTotal(double subTotal) {
            this.subTotal = subTotal;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }

    public record OrderItem(String name, int quantity, double price) {}

    public record Customer(String name) {}

}
