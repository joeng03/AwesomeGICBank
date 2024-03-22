package accounts;

import java.util.ArrayList;

import exceptions.BankAccountOperationException;
import exceptions.DepositAmountNonPositiveException;
import exceptions.WithdrawAmountExceedDepositException;
import exceptions.WithdrawAmountNonPositiveException;
import transactions.DepositTransaction;
import transactions.Transaction;
import transactions.WithdrawTransaction;

/**
 * accounts.BankAccount class represents a single bank account.
 */
public class BankAccount implements DepositService, WithdrawService, PrintStatementService {

    public static final String TRANSACTIONS_TABLE_HEADER = String.format("%-23s | %-12s | %s", "Date", "Amount",
            "Balance");

    private double balance = 0.0;
    private ArrayList<Transaction> transactions = null;

    /**
     * Constructor to initialize a bank account with zero balance.
     */
    public BankAccount() {
        assert balance == 0.0 : "Balance should be zero before initializing BankAccount.";

        balance = 0.0;
        transactions = new ArrayList<>();

        assert balance >= 0.0 : "Balance should be non-negative after initializing BankAccount.";
    }

    /**
     * Method to deposit an amount into the account.
     * @param amount The amount to be deposited.
     */
    @Override
    public void deposit(double amount) throws BankAccountOperationException {
        assert balance >= 0.0 : "Balance should be non-negative before depositing.";

        if(amount <= 0.0) {
            throw new DepositAmountNonPositiveException();
        }

        balance += amount;
        transactions.add(new DepositTransaction(amount, balance));

        assert balance >= 0.0 : "Balance should be non-negative after depositing.";
    }

    /**
     * Method to withdraw an amount from the account.
     * @param amount The amount to be withdrawn.
     */
    @Override
    public void withdraw(double amount) throws BankAccountOperationException {
        assert balance >= 0.0 : "Balance should be non-negative before withdrawing.";

        if(amount <= 0.0) {
            throw new WithdrawAmountNonPositiveException();
        }

        if(amount > balance) {
            throw new WithdrawAmountExceedDepositException();
        }

        balance -= amount;
        transactions.add(new WithdrawTransaction(amount, balance));

        assert balance >= 0.0 : "Balance should be non-negative after withdrawing.";
    }

    /**
     * Method to return the account statement.
     * Note: This method is defined instead of overriding the toString() method
     * to increase readability and allow flexibility for potential future changes,
     * such as returning account details together with the account holder's name.
     */
    @Override
    public String getStatement() {
        assert balance >= 0.0 : "Balance should be non-negative before printing account statement.";

        StringBuilder sb = new StringBuilder();
        sb.append(TRANSACTIONS_TABLE_HEADER + "\n");
        for (Transaction transaction : transactions) {
            sb.append(transaction + "\n");
        }

        return sb.toString();
    }
}
