package transactions;

import exceptions.TransactionException;

public class DepositTransaction extends Transaction {
    public DepositTransaction(double amount, double balance) throws TransactionException {
        super(amount, balance);
    }
}
