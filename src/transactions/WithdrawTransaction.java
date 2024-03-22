package transactions;

import exceptions.TransactionException;

public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(double amount, double balance) throws TransactionException {
        super(-amount, balance);
    }
}
