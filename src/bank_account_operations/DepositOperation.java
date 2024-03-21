package bank_account_operations;

import java.util.Scanner;

import accounts.BankAccount;
import exceptions.BankAccountOperationException;
import exceptions.DepositAmountNonPositiveException;

/**
 * Concrete implementation of BankAccountOperation interface for deposit action.
 */
public class DepositOperation implements BankAccountOperation {
    public static final String DEPOSIT_MESSAGE = "Please enter the amount to deposit:";

    public static final String THANK_YOU_DEPOSIT = "Thank you. $%.2f has been deposited to your account.";
    private Scanner scanner;
    private BankAccount account;

    public DepositOperation(Scanner scanner, BankAccount account) {
        this.scanner = scanner;
        this.account = account;
    }

    public void execute() throws BankAccountOperationException {
        System.out.println(DEPOSIT_MESSAGE);
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
        System.out.printf(THANK_YOU_DEPOSIT, depositAmount);
    }
}