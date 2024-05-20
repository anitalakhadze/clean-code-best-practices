package conciseMethods;

public class ConciseMethodsGoodPractice {

    // Good - Separate Methods for Each Responsibility
    public void processOrder(Order order) {
        validateOrder(order);
        calculateTotal(order);
        saveOrder(order);
    }

    // Method for Validating the Order
    private void validateOrder(Order order) {
        // Validation code
    }

    // Method for Calculating the Total Amount of the Order
    private void calculateTotal(Order order) {
        // Calculation code
    }

    // Method for Saving the Order to the Database
    private void saveOrder(Order order) {
        // Save order code
    }


    static class Order {
    }

}
