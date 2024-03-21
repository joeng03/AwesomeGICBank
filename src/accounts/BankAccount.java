package accounts;

import java.util.ArrayList;

import exceptions.BankAccountOperationException;
import exceptions.DepositAmountNonPositiveException;
import exceptions.WithdrawAmountExceedDepositException;
import exceptions.WithdrawAmountNonPositiveException;
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
        transactions = new ArrayList<>();

        assert balance >= 0.0 : "Balance should be non-negative after initializing BankAccount.";
    }

    /**
     * Method to deposit an amount into the account.
     * @param amount The amount to be deposited.
     */
    public void deposit(double amount) throws BankAccountOperationException {
        assert balance >= 0.0 : "Balance should be non-negative before depositing.";

        if(amount < 0.0) {
            throw new DepositAmountNonPositiveException();
        }

        balance += amount;
        transactions.add(new Transaction(amount, balance));

        assert balance >= 0.0 : "Balance should be non-negative after depositing.";
    }

    /**
     * Method to withdraw an amount from the account.
     * @param amount The amount to be withdrawn.
     */
    public void withdraw(double amount) throws BankAccountOperationException {
        assert balance >= 0.0 : "Balance should be non-negative before withdrawing.";

        if(amount < 0.0) {
            throw new WithdrawAmountNonPositiveException();
        }

        if(amount > balance) {
            throw new WithdrawAmountExceedDepositException();
        }

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
