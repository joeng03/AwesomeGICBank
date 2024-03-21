package accounts;

import java.util.ArrayList;

import transactions.Transaction;

/**
 * accounts.BankAccount class represents a single bank account.
 */
public class BankAccount {
    private double balance = 0.0;
    private ArrayList<Transaction> transactions = null;

    /**
     * Constructor to initialize a bank account with zero balance.
     */
    public BankAccount() {
        balance = 0.0;
        transactions = new ArrayList<Transaction>();

        assert balance >= 0.0 : "Balance should be non-negative after initializing BankAccount.";
    }

    /**
     * Method to deposit an amount into the account.
     * @param amount The amount to be deposited.
     */
    public void deposit(double amount) {
        assert balance >= 0.0 : "Balance should be non-negative before depositing.";

        balance += amount;
        transactions.add(new Transaction(amount, balance));

        assert balance >= 0.0 : "Balance should be non-negative after depositing.";
    }

    /**
     * Method to withdraw an amount from the account.
     * @param amount The amount to be withdrawn.
     */
    public void withdraw(double amount) {
        assert balance >= 0.0 : "Balance should be non-negative before withdrawing.";

        balance -= amount;
        transactions.add(new Transaction(-amount, balance));

        assert balance >= 0.0 : "Balance should be non-negative after withdrawing.";
    }

    /**
     * Method to print the account statement.
     */
    public void printStatement() {
        assert balance >= 0.0 : "Balance should be non-negative before printing bank statement.";

        System.out.println("Date\t\t\t| Amount\t| Balance");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
