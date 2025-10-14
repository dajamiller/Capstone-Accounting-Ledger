import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Ledger {


    private ArrayList<Transaction> list = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
    }
    public void showTransactions() {
        list.forEach(transaction -> System.out.println(transaction.toString()));
    }
    public void saveToCsv() {
    }
    public void loadFromCsv() {
    }
    public void showDeposits() {
        list.forEach(transaction -> System.out.println(transaction.toString()));
    }
    public void showPayments() {
        list.forEach(transaction -> System.out.println(transaction.toString()));
    }

    public Ledger() {

    }

}

