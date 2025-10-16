import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Menu {

    public static void ShowHome() {
        Scanner scanner = new Scanner(System.in);
        Transaction list = new Transaction();
        Transaction t = new Transaction();

        boolean running = true;

        while (running) {
            // create home menu options
            System.out.println("\nWelcome to Quantify! - Your Favorite Financial Manager \uD83D\uDCB0");
            System.out.println("What would you like to do?:");
            System.out.println("(D) Add a Deposit");
            System.out.println("(P) Make a Payment");
            System.out.println("(L) Ledger");
            System.out.println("(X) Exit");


            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine().trim().toUpperCase(); // prompt user input make it uppercase and trim spaces

            switch (choice) {
                case "D" -> {
                    addDeposit(list, scanner);
                    break;
                }
                case "P" -> {
                    makePayment(list, scanner);
                    break;
                    //case "L": showLedger???()
                }
                case "L" -> {
                    showLedger(list, scanner);
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

    //private static void addDeposit(Transaction list, Scanner scanner) {}

    //private static void showLedger(Transaction list, Scanner scanner) {}

    private static void showTransactions() {
    }

    private static void showDeposits() {
    }

    private static void showPayments() {
    }

    private static void makePayment(Transaction list, Scanner scanner) {
        System.out.println("Please enter the payment amount: ex. 129.55");
        double amount = scanner.nextDouble();
        System.out.println("Please enter the vendor name: ex. Etsy");
        scanner.nextLine();
        String vendor = scanner.nextLine().trim().toUpperCase();
        System.out.println("Enter a brief description of the payment: ex. Crochet Hats");
        String description = scanner.nextLine().trim().toUpperCase();

        // file reader/writer
        boolean running = true;
        LocalDateTime today = LocalDateTime.now();
        try {
            FileWriter myWriter = new FileWriter("transactions.csv", running);
            String Entry = (today + " | " + vendor + " | " + description + " | " + (amount *= -1));
            myWriter.write(Entry);
            myWriter.close();  // must close manually
            System.out.println("Payment successful");
        } catch (IOException e) {
            System.out.println("An error occurred, please try again");
            e.printStackTrace();

            // list.addTransaction();// adds to array list
            //list.saveToCsv();//saves to csv file

        }
    }

    private static void addDeposit(Transaction list, Scanner scanner) {
        System.out.println("Please enter the deposit amount: ex. 12.95");
        double amount = scanner.nextDouble();
        System.out.println("Please enter the vendor name: ex. YUU");
        scanner.nextLine();// needed to switch from number to text
        String vendor = scanner.nextLine().trim().toUpperCase();
        System.out.println("Please enter a description of the deposit: ex. Weekly Pay");
        String description = scanner.nextLine().trim().toUpperCase();

            boolean running = true;
            try {
                FileWriter myWriter = new FileWriter("transactions.csv");
                String Entry = (LocalDate.now() + " | " + LocalTime.now() + " | " + vendor + " | " + description + " | " + amount);
                myWriter.write(Entry);
                myWriter.close();  // must close manually
                System.out.println("Deposit successful");
            } catch (IOException e) {
                System.out.println("An error occurred, please try again");
                e.printStackTrace();
            }
//        }
        //list.addTransaction(date, time, description,vendor, amount);
        //list.saveToCsv();
        Transaction t = new Transaction(
                LocalDate.now(),
                LocalTime.now(),
                vendor,
                description,
                amount);
        //list.addTransaction();
        //list.saveToCsv();
    }

    private static void showLedger (Transaction list, Scanner scanner){
            System.out.println("Welcome to your Ledger Options!\n");
            System.out.println("(A) Show all transactions");
            System.out.println("(D) Show Deposits");
            System.out.println("(P) Show Payments");
            System.out.println("(R) Run Report");
            System.out.println("(H) Return to Home screen");
            // make selection
            System.out.println("What would you like to do?");
            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "A" -> {
                    showTransactions();
                    break;
                }
                case "D" -> {
                    showDeposits();
                    break;
                }
                case "P" -> {
                    showPayments();
                    break;
                }
                case "R" -> {
                }
                case "H" -> {
                    ShowHome();
                    break;
                }
            }

        }

    }



