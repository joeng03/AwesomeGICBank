package exceptions;

public class WithdrawAmountExceedDepositException extends BankAccountOperationException {
    public static final String MESSAGE = "Withdraw amount cannot exceed deposit amount.";
    public WithdrawAmountExceedDepositException() {
        super(MESSAGE);
    }
}
