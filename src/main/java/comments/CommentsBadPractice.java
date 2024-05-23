package comments;

public class CommentsBadPractice {

    private double balance;

    // Constructor to set the balance
    public CommentsBadPractice(double initialBalance) {
        // Set the initial balance
        this.balance = initialBalance;
    }

    // Add to balance
    public void addToBalance(double amount) {
        this.balance += amount; // Add the amount to the balance
    }

    // Subtract amount from balance
    public void subtractFromBalance(double amount) {
        this.balance -= amount; // Subtract the amount from the balance
    }

    // Print the current balance
    public void printBalance() {
        System.out.println("Current balance: " + this.balance); // Print the balance
    }

}
