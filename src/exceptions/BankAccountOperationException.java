package exceptions;

public abstract class BankAccountOperationException extends Exception {
    public BankAccountOperationException(String message) {
        super(message);
    }
}
