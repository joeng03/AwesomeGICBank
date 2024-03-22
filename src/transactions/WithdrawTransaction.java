package transactions;

public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(double amount, double balance) {
        super(-amount, balance);
    }
}
