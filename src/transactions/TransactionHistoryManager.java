package transactions;

import java.util.ArrayList;

public class TransactionHistoryManager {

    public static final String TRANSACTIONS_HISTORY_TABLE_HEADER = String.format("%-23s | %-12s | %s", "Date", "Amount",
            "Balance");

    private ArrayList<Transaction> transactions = null;

    public TransactionHistoryManager() {
        transactions = new ArrayList<>();
    }

    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TRANSACTIONS_HISTORY_TABLE_HEADER + "\n");
        for (Transaction transaction : transactions) {
            sb.append(transaction + "\n");
        }

        return sb.toString();
    }
}
