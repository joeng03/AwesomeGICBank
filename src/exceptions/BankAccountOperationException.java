package exceptions;

public class BankAccountOperationException extends Exception {
    public BankAccountOperationException(String message) {
        super(message);
    }
}
