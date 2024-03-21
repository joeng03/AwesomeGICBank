package exceptions;

public class DepositAmountNonPositiveException extends BankAccountOperationException {
    public static final String MESSAGE = "Deposit amount must be positive.";
    public DepositAmountNonPositiveException() {
        super(MESSAGE);
    }
}
