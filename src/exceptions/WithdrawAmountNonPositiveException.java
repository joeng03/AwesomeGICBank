package exceptions;

public class WithdrawAmountNonPositiveException extends BankAccountOperationException {
    public static final String MESSAGE = "Withdraw amount must be positive.";
    public WithdrawAmountNonPositiveException() {
        super(MESSAGE);
    }
}
