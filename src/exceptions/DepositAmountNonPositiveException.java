package exceptions;

public class DepositAmountNonPositiveException extends BankAccountOperationException {
    public static final String MESSAGE = "Deposit amount cannot be negative.";
    public DepositAmountNonPositiveException() {
        super(MESSAGE);
    }
}
