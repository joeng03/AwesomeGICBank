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
    public static final String PROMPT_MESSAGE = "Is there anything else you'd like to do?\n[D]eposit\n[W]ithdraw\n[P]rint statement\n[Q]uit";

    public static final String DEPOSIT_COMMAND_MESSAGE = "[D]eposit";

    public static final String WITHDRAW_COMMAND_MESSAGE = "[W]ithdraw";

    public static final String PRINT_STATEMENT_COMMAND_MESSAGE = "[P]rint statement";

    public static final String QUIT_COMMAND_MESSAGE = "[Q]uit";


    // Method to start the BankTeller service.
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount();
        BankAccountOperationFactory operationFactory = new BankAccountOperationFactory();

        System.out.println(WELCOME_MESSAGE);
        System.out.println(DEPOSIT_COMMAND_MESSAGE);
        System.out.println(WITHDRAW_COMMAND_MESSAGE);
        System.out.println(PRINT_STATEMENT_COMMAND_MESSAGE);
        System.out.println(QUIT_COMMAND_MESSAGE);

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
        }
    }
}









