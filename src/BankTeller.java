import java.util.Scanner;

import accounts.BankAccount;
import bank_account_operations.BankAccountOperationFactory;
import bank_account_operations.BankAccountOperation;
import exceptions.BankAccountOperationException;

/**
 * Acts as a bank teller which handles I/O operations
 * (user requests and bank responses).
 * The entry point to interact with a bank account.
 */
public class BankTeller {
    public static final String WELCOME_MESSAGE = "Welcome to AwesomeGIC Bank! What would you like to do?";
    public static final String INVALID_OPTION_MESSAGE = "Invalid option. Please select again.";
    public static final String OPTIONS_LIST_MESSAGE = "[D]eposit\n[W]ithdraw\n[P]rint statement\n[Q]uit";
    public static final String PROMPT_MESSAGE = "Is there anything else you'd like to do?";

    private Scanner scanner = null;
    private BankAccount account = null;
    private BankAccountOperationFactory operationFactory = null;

    public BankTeller(Scanner scanner, BankAccount account, BankAccountOperationFactory operationFactory) {
        this.scanner = scanner;
        this.account = account;
        this.operationFactory = operationFactory;
    }

    // Method to start the BankTeller service.
    public void start() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(OPTIONS_LIST_MESSAGE);

        while (true) {
            char option = scanner.next().charAt(0);
            BankAccountOperation operation = operationFactory.createOperation(option, scanner, account);
            if (operation != null) {
                try {
                    operation.execute();
                } catch (BankAccountOperationException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println(INVALID_OPTION_MESSAGE);
            }
            System.out.println(PROMPT_MESSAGE);
            System.out.println(OPTIONS_LIST_MESSAGE);
        }
    }
}









