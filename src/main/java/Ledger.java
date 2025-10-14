import java.util.ArrayList;

public class Ledger {


    private ArrayList<Transaction> list = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        if (list.add(transaction))
            System.out.println("Transaction Added: " + transaction.getDescription() + "$" + transaction.getAmount());
        else {
            System.out.println("Oops, try again...");
        }
    }
    public void showTransactions() {
    }
    public void saveToCsv() {
    }
    public void loadFromCsv() {
    }
    public void showDeposits() {
    }
    public void showPayments() {
    }
    public Ledger() {

    }

}

