package bank_account_operations;

import exceptions.BankAccountOperationException;

/**
 * Interface for bank account operations.
 */
public interface BankAccountOperation {
    void execute() throws BankAccountOperationException;
}