package accounts;

import exceptions.BankAccountOperationException;

public interface WithdrawService {
    void withdraw(double amount) throws BankAccountOperationException;
}
