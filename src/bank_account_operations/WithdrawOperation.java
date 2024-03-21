package bank_account_operations;

import java.util.Scanner;

import accounts.BankAccount;

/**
 * Concrete implementation of BankAccountOperation interface for withdraw action.
 */
public class WithdrawOperation implements BankAccountOperation {
    public static final String WITHDRAW_MESSAGE = "Please enter the amount to withdraw:";
    public static final String THANK_YOU_WITHDRAW = "Thank you. $%.2f has been withdrawn.";

    private Scanner scanner;
    private BankAccount account;

    public WithdrawOperation(Scanner scanner, BankAccount account) {
        this.scanner = scanner;
        this.account = account;
    }

    public void execute() {
        System.out.println(WITHDRAW_MESSAGE);
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);
        System.out.printf(THANK_YOU_WITHDRAW, withdrawAmount);
    }
}