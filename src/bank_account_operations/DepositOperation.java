package bank_account_operations;

import java.util.Scanner;

import bank_accounts.BankAccount;
import exceptions.BankAccountOperationException;

/**
 * Concrete implementation of BankAccountOperation interface for deposit operation.
 */
public class DepositOperation implements BankAccountOperation {
    public static final String DEPOSIT_MESSAGE = "Please enter the amount to deposit:";

    public static final String THANK_YOU_DEPOSIT = "Thank you. $%.2f has been deposited to your account.\n";
    private Scanner scanner = null;
    private BankAccount account = null;

    public DepositOperation(Scanner scanner, BankAccount account) {
        this.scanner = scanner;
        this.account = account;
    }

    @Override
    public void execute() throws BankAccountOperationException {
        System.out.println(DEPOSIT_MESSAGE);
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
        System.out.printf(THANK_YOU_DEPOSIT, depositAmount);
    }
}