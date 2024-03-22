package transactions;

import java.util.Date;

import java.text.SimpleDateFormat;

import exceptions.NegativeBalanceTransactionException;
import exceptions.TransactionException;

/**
 * Transaction class represents a single transaction.
 */
public abstract class Transaction {

    public static final String DATE_FORMAT = "dd MMM yyyy hh:mm:ss a";
    public static final String ROW_FORMAT = "%-23s | %-12.2f | %.2f";
    private Date date = null;
    private double amount = 0.0;
    private double balance = 0.0;

    /**
     * Constructor to initialize a transaction with the current date, amount, and balance.
     * @param amount The amount of the transaction.
     * @param balance The balance after the transaction.
     */
    public Transaction(double amount, double balance) throws TransactionException {
        if(balance < 0.0) {
            throw new NegativeBalanceTransactionException();
        }

        this.date = new Date();
        this.amount = amount;
        this.balance = balance;

        assert balance >= 0.0 : "Balance should be non-negative after initializing the Transaction instance.";
    }

    /**
     * Method to get the transaction date in a formatted string.
     * @return The formatted transaction date.
     */
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
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
        return String.format(ROW_FORMAT, this.getDate(), this.getAmount(), this.getBalance());
    }
}

