package exceptions;

public class WithdrawAmountExceedDepositException extends BankAccountOperationException {
    public static final String MESSAGE = "You have insufficient funds! Withdraw amount exceeds deposit amount.";
    public WithdrawAmountExceedDepositException() {
        super(MESSAGE);
    }
}
