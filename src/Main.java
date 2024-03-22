import java.util.Scanner;

import accounts.BankAccount;
import bank_account_operations.BankAccountOperationFactory;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount();
        BankAccountOperationFactory operationFactory = new BankAccountOperationFactory();
        BankTeller bankTeller = new BankTeller(scanner, account, operationFactory);
        bankTeller.start();
    }
}
