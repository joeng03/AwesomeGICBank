package bank_account_operations;

import exceptions.BankAccountOperationException;

/**
 * Interface for bank account operations.
 */
public interface BankAccountOperation {
    public static final String OPTIONS_LIST_MESSAGE = "[D]eposit\n[W]ithdraw\n[P]rint statement\n[Q]uit";
    public static final String PROMPT_MESSAGE = "Is there anything else you'd like to do?";
    public static final String INVALID_INPUT_MESSAGE = "Invalid input. Please try again.";

    void execute() throws BankAccountOperationException;
}