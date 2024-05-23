package comments;

public class CommentsGoodPractice {

    private double balance;

    /**
     * Initializes the balance with the given amount.
     *
     * @param initialBalance the initial balance
     */
    public CommentsGoodPractice(double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Adds the specified amount to the balance.
     *
     * @param amount the amount to add
     */
    public void addToBalance(double amount) {
        this.balance += amount;
    }

    /**
     * Subtracts the specified amount from the balance if sufficient funds are available.
     *
     * @param amount the amount to subtract
     * @throws IllegalArgumentException if amount exceeds balance
     */
    public void subtractFromBalance(double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Amount exceeds current balance");
        }
        this.balance -= amount;
    }

    /**
     * Prints the current balance to the standard output.
     */
    public void printBalance() {
        System.out.println("Current balance: " + this.balance);
    }
}
