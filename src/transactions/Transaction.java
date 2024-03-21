package transactions;

import java.util.Date;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Transaction class represents a single transaction.
 */
public class Transaction {
    private Date date;
    private double amount;
    private double balance;

    /**
     * Constructor to initialize a transaction with the current date, amount, and balance.
     * @param amount The amount of the transaction.
     * @param balance The balance after the transaction.
     */
    public Transaction(double amount, double balance) {
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * Method to get the transaction date in a formatted string.
     * @return The formatted transaction date.
     */
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
        return sdf.format(date);
    }

    /**
     * Method to get the transaction amount.
     * @return The transaction amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Method to get the account balance after the transaction.
     * @return The account balance after the transaction.
     */
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("%s\t| %.2f\t| %.2f\t", this.getDate(), this.getAmount(), this.getBalance());
    }
}

