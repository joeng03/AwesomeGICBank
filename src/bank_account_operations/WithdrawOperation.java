package bank_account_operations;

import java.util.Scanner;

import accounts.BankAccount;
import exceptions.BankAccountOperationException;

/**
 * Concrete implementation of BankAccountOperation interface for withdraw operation.
 */
public class WithdrawOperation implements BankAccountOperation {
    public static final String WITHDRAW_MESSAGE = "Please enter the amount to withdraw:";
    public static final String THANK_YOU_WITHDRAW = "Thank you. $%.2f has been withdrawn.\n";

    private Scanner scanner = null;
    private BankAccount account = null;

    public WithdrawOperation(Scanner scanner, BankAccount account) {
        this.scanner = scanner;
        this.account = account;
    }

    @Override
    public void execute() throws BankAccountOperationException {
        System.out.println(WITHDRAW_MESSAGE);
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);
        System.out.printf(THANK_YOU_WITHDRAW, withdrawAmount);
    }
}