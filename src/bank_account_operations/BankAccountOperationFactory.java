package bank_account_operations;

import java.util.Scanner;

import bank_accounts.BankAccount;

/**
 * Factory class for creating bank account operations.
 */
public class BankAccountOperationFactory {
    public BankAccountOperation createOperation(char option, Scanner scanner, BankAccount account) {
        switch (option) {
        case 'D':
        case 'd':
            return new DepositOperation(scanner, account);
        case 'W':
        case 'w':
            return new WithdrawOperation(scanner, account);
        case 'P':
        case 'p':
            return new PrintStatementOperation(account);
        case 'Q':
        case 'q':
            return new QuitOperation(scanner);
        default:
            return null;
        }
    }
}