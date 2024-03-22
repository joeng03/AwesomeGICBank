package accounts;

import exceptions.BankAccountOperationException;

public interface DepositService {
    void deposit(double amount) throws BankAccountOperationException;
}
