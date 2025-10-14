import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ledger {


    private ArrayList<Transaction> list = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        if (list.add(transaction))
            System.out.println("Transaction Added!");// optional desription add - " + transaction.getDescription() + "$" + transaction.getAmount());
        else {
            System.out.println("Oops, try again...");
        }
    }
    public void showTransactions() {
    }
    public void saveToCsv() {
        try {
            FileWriter writer = new FileWriter("transactions.csv",true);
            for (Transaction t : list) {
                writer.write(t.getDate() + "|" + t.getTime() + "|" + t.getDescription() + "|" + t.getVendor() + "|" + t.getAmount() + "\n");
            }
            writer.close();
            System.out.println("Transaction(s) saved successfully!"); //optional - add description of transaction amount etc..

        } catch (IOException e) {
            System.out.println("Error writing transactions.csv, try again...");
        }
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

