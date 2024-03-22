package bank_accounts;

import exceptions.BankAccountOperationException;
import exceptions.DepositAmountNonPositiveException;
import exceptions.TransactionException;
import exceptions.WithdrawAmountExceedDepositException;
import exceptions.WithdrawAmountNonPositiveException;
import transactions.DepositTransaction;
import transactions.Transaction;
import transactions.TransactionHistoryManager;
import transactions.WithdrawTransaction;

/**
 * accounts.BankAccount class represents a single bank account.
 */
public class BankAccount implements DepositService, WithdrawService, PrintStatementService {
    private double balance = 0.0;
    private TransactionHistoryManager transactionHistoryManager = null;

    /**
     * Constructor to initialize a bank account with zero balance.
     * Uses the default transaction history manager.
     */
    public BankAccount() {
        this(new TransactionHistoryManager());

        assert balance == 0.0 : "Balance should be zero after initializing BankAccount.";
    }

    /**
     * Constructor to initialize a bank account with zero balance and a transaction history manager.
     * @param transactionHistoryManager The transaction history manager to be used.
     */
    public BankAccount(TransactionHistoryManager transactionHistoryManager) {
        this.balance = 0.0;
        this.transactionHistoryManager = transactionHistoryManager;

        assert balance == 0.0 : "Balance should be zero after initializing BankAccount.";
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
        try {
            Transaction depositTransaction = new DepositTransaction(amount, balance);
            transactionHistoryManager.add(depositTransaction);
        } catch(TransactionException e) {
            System.out.println(e.getMessage());
        }

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

        try {
            Transaction withdrawTransaction = new WithdrawTransaction(amount, balance);
            transactionHistoryManager.add(withdrawTransaction);
        } catch(TransactionException e) {
            System.out.println(e.getMessage());
        }

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

        return transactionHistoryManager.toString();
    }
}
