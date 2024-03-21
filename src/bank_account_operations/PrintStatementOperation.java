package bank_account_operations;

import accounts.BankAccount;

/**
 * Concrete implementation of BankAccountOperation interface for print statement action.
 */
public class PrintStatementOperation implements BankAccountOperation {
    private BankAccount account;

    public PrintStatementOperation(BankAccount account) {
        this.account = account;
    }

    public void execute() {
        account.printStatement();
    }
}