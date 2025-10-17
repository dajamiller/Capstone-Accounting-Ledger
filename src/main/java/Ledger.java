import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Collections;

public class Ledger {

    private static String fileName = "transactions.csv";
    private final ArrayList<Transaction> list = new ArrayList<>();

    public Ledger() {
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

    public void saveToCsv() {

    }

    public void loadFromCsv() {
        list.clear();
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

            Collections.reverse(list); // reversed list to show newest first
            System.out.println("Transaction loaded successfully!");
        } catch (Exception e) {
            System.out.println("Error reading transactions.csv, try again...");
        }
    }
    public void showAllTransactions() {
        //loadFromCsv();
        System.out.println("All transactions, from newest to oldest:");
        for (Transaction t : list) {
            System.out.println(t);
    }
}

    public void showDeposits() {
        System.out.println("\n~~~~ Showing All Deposits ~~~~");
        for (Transaction t : list) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }

    public void showPayments() {
        //loadFromCsv();

        System.out.println("\n~~~~ Showing All Payments ~~~~");
        for (Transaction t : list) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }

    public void addTransaction(Transaction transaction) {
        list.add(0, transaction);
    }
    public void monthToDate() {
        LocalDate today = LocalDate.now();


    }
    public void showByVendor(String vendor) {
        //loadFromCsv();
        System.out.println("All transactions from " +  vendor);
        boolean vendorFound = false;

        for (Transaction t : list) {
            if (t.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println(t);
                vendorFound = true;
            }
        }
        if (!vendorFound) {
            System.out.println("Sorry, there are no matching transactions for " +  vendor);
        }

    }
}




