package bank_account_operations;

import java.util.Scanner;

/**
 * Concrete implementation of BankAccountOperation interface for quit action.
 */
public class QuitOperation implements BankAccountOperation {
    public static final String GOODBYE_MESSAGE = "Thank you for banking with AwesomeGIC Bank.\nHave a nice day!";

    private Scanner scanner;

    public QuitOperation(Scanner scanner) {
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println(GOODBYE_MESSAGE);
        scanner.close();
        System.exit(0);
    }
}
