package exceptions;

public class NegativeBalanceTransactionException extends TransactionException {
    public static final String MESSAGE = "Transaction would result in a negative balance.";
    public NegativeBalanceTransactionException() {
        super(MESSAGE);
    }
}
