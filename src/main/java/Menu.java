import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {
    LocalDateTime today = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");


    public static void ShowHome() {
        Transaction list = new Transaction();
        Transaction t = new Transaction();
        Ledger ledger = new Ledger();

        ledger.loadFromCsv(); // only loaded once for all options

        boolean running = true;
        while (running) {
            // create home menu options
            System.out.println("   ____                    __  _ ____     \n" +
                    "  / __ \\__  ______ _____  / /_(_) __/_  __\n" +
                    " / / / / / / / __ `/ __ \\/ __/ / /_/ / / /\n" +
                    "/ /_/ / /_/ / /_/ / / / / /_/ / __/ /_/ / \n" +
                    "\\___\\_\\__,_/\\__,_/_/ /_/\\__/_/_/  \\__, /  \n" +
                    "                                 /____/    ");
            System.out.println("\n~~~~~~~~ Welcome to Quantify! ~~~~~~~~");
            System.out.println("~~Your Favorite Financial Manager \uD83D\uDCB0~~");
            System.out.println("\nWhat would you like to do?:");
            System.out.println("(D) Add a Deposit");
            System.out.println("(P) Make a Payment");
            System.out.println("(L) Ledger");
            System.out.println("(X) Exit");


            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().trim().toUpperCase(); // prompt user input make it uppercase and trim spaces

            switch (choice) {
                case "D" -> {
                    addDeposit(ledger, list, scanner);
                    break;
                }
                case "P" -> {
                    makePayment(ledger,
                            list,
                            scanner);
                    break;
                }
                case "L" -> {
                    showLedger(ledger, list, scanner);
                    break;
                }
                case "X" -> {
                    System.out.println("Thank you for using Quantify, goodbye!");
                    running = false;
                    break;
                }

                default -> System.out.println("Invalid choice, please try again");
            }
        }

    }


    private static void makePayment(Ledger ledger, Transaction list, Scanner scanner) {
        System.out.println("Please enter the payment amount: ex. 129.55");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // switched from # to text, need new line
        System.out.println("Please enter the vendor name: ex. Etsy");
        String vendor = scanner.nextLine().trim().toUpperCase();
        System.out.println("Enter a brief description of the payment: ex. Crochet Hats");
        String description = scanner.nextLine().trim().toUpperCase();

        // file reader/writer

        try {

            FileWriter myWriter = new FileWriter("transactions.csv", true);
            LocalDateTime today = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");;
            String Entry = ("\n" + today.format(formatter) + "|" + vendor + "|" + description + "|" + (amount *= -1));
            myWriter.write(Entry);

            myWriter.close();  // must close manually

            System.out.println("Payment successful");
        } catch (IOException e) {
            System.out.println("An error occurred, please try again");
            e.printStackTrace();
        }

        Transaction t = new Transaction(
                LocalDate.now(),
                LocalTime.now(),
                description,
                vendor,
                amount);
        ledger.addTransaction(t);
    }

    private static void addDeposit(Ledger ledger, Transaction list, Scanner scanner) {
        System.out.println("Please enter the deposit amount: ex. 100.00");
        double amount = scanner.nextDouble();
        System.out.println("Please enter the vendor name: ex. Year Up United");
        scanner.nextLine();// needed to switch from number to text
        String vendor = scanner.nextLine().trim().toUpperCase();
        System.out.println("Please enter a description of the deposit: ex. Bi-Weekly Pay");
        String description = scanner.nextLine().trim().toUpperCase();
        // try-catch for file writer
            try {
                FileWriter myWriter = new FileWriter("transactions.csv", true);
                LocalDateTime today = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
                String Entry = ("\n" + today.format(formatter)  + "|" + vendor + "|" + description + "|" + amount);
                myWriter.write(Entry);
                myWriter.close();  // must close manually
                System.out.println("Deposit successful");
            } catch (IOException e) {
                System.out.println("An error occurred, please try again");
                e.printStackTrace();
            }
        Transaction t = new Transaction(
                LocalDate.now(),
                LocalTime.now(),
                description,
                vendor,
                amount);
            ledger.addTransaction(t);
    }

    private static void showLedger (Ledger ledger, Transaction list, Scanner scanner) {


        boolean runningLedger = true;
        while (runningLedger) {
            System.out.println("\n~~~~ Ledger Options ~~~~");
            System.out.println("(A) Show All Transactions");
            System.out.println("(D) Show Deposits");
            System.out.println("(P) Show Payments");
            System.out.println("(R) Run Report");
            System.out.println("(H) Return to Home screen");
            // make selection
            System.out.println("\nWhat would you like to do?");
            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "A" -> {
                    //ledger.loadFromCsv();
                    ledger.showAllTransactions();
                    break;
                }
                case "D" -> {
                    //ledger.loadFromCsv();
                    ledger.showDeposits();
                    break;
                }
                case "P" -> {
                    //ledger.loadFromCsv();
                    ledger.showPayments();
                    break;
                }
                case "R" -> {
                    showReportScreen(ledger, scanner);
                }
                case "H" -> {
                    runningLedger = false;
                    break;
                }
                default -> System.out.println("Invalid choice, please try again");
            }
        }
    }
    private static void showReportScreen(Ledger ledger, Scanner scanner) {
        boolean runningReportScreen = true;
        while (runningReportScreen) {
            System.out.println("\n\n ~~~ Report Options ~~~");

            System.out.println("(1) Month to Date");
            System.out.println("(2) Previous Month");
            System.out.println("(3) Year to Date");
            System.out.println("(4) Previous Year");
            System.out.println("(5) Search by Vendor");
            System.out.println("(0) Return to Ledger screen");
            // make selection
            System.out.println("What kind of report would you like to run?");
            System.out.println("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            LocalDate todaysDate = LocalDate.now();

            switch (choice) {
                case 1 -> {
                    ledger.monthToDate();
                }
                case 2 -> {
                    ledger.previousMonth();
                }
                case 3 -> {
                    ledger.yearToDate();
                }
                case 4 -> {
                    ledger.previousYear();
                }
                case 5 -> {
                    System.out.println("Enter the vendor name: ");
                    String vendor = scanner.nextLine().trim().toUpperCase();
                    ledger.showByVendor(vendor);
                }
                case 0 -> {
                    runningReportScreen = false;
                }
                default -> System.out.println("Invalid choice, please try again");
            }
        }

    }

}



