import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Ledger {

    private static String fileName = "transactions.csv";
    private final ArrayList<Transaction> list = new ArrayList<>();

    public Ledger() {
    }
    public void showTransactions() {
        for (Transaction t : list) {
            System.out.println(t);

        }

    //public void showDeposits() {}
    //public void showPayments() {}
//    public void addTransaction(Transaction transaction) {
//        if (list.add(transaction))
//            System.out.println("Transaction Added!");// optional description add - " + transaction.getDescription() + "$" + transaction.getAmount());
//        else {
//            System.out.println("Oops, try again...");
//        }
//    }

    //public void saveToCsv() {
    }
    public void loadFromCsv() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                Transaction t = new Transaction(
                        LocalDate.parse(parts[0]),
                        LocalTime.parse(parts[1]),
                        parts[2],
                        parts[3],
                        Double.parseDouble(parts[4])
            );
                list.add(t);
            }
            reader.close();
            System.out.println("Transaction loaded successfully!");
        } catch (Exception e) {
            System.out.println("Error reading transactions.csv, try again...");
        }
    }

    }




