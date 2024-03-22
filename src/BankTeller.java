import java.util.Scanner;

import bank_accounts.BankAccount;
import bank_account_operations.BankAccountOperationFactory;
import bank_account_operations.BankAccountOperation;
import exceptions.BankAccountOperationException;
import exceptions.TransactionException;

/**
 * Acts as a bank teller which handles I/O operations
 * (user requests and bank responses).
 * The entry point to interact with a bank account.
 */
public class BankTeller {
    public static final String WELCOME_MESSAGE = "Welcome to AwesomeGIC Bank! What would you like to do?";
    public static final String INVALID_OPTION_MESSAGE = "Invalid option. Please select again.";
    private Scanner scanner = null;
    private BankAccount account = null;
    private BankAccountOperationFactory operationFactory = null;

    /**
     * Constructor to initialize a bank teller with a scanner, bank account, and operation factory.
     * Uses the default scanner, bank account, and operation factory.
     */
    public BankTeller() {
        this(new Scanner(System.in), new BankAccount(), new BankAccountOperationFactory());
    }

    /**
     * Constructor to initialize a bank teller with a scanner, bank account, and operation factory.
     * @param scanner The scanner to be used for input.
     * @param account The bank account to be used.
     * @param operationFactory The operation factory to be used.
     */
    public BankTeller(Scanner scanner, BankAccount account, BankAccountOperationFactory operationFactory) {
        this.scanner = scanner;
        this.account = account;
        this.operationFactory = operationFactory;
    }

    // Method to start the BankTeller service.
    public void start() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(BankAccountOperation.OPTIONS_LIST_MESSAGE);

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
        }
    }
}









