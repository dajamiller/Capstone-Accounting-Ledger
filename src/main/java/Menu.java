import java.util.Scanner;

public class Menu {
    public static void ShowHome() {
        Scanner scanner = new Scanner(System.in);
        Ledger list = new Ledger();

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
                case "D" -> addDeposit(list, scanner);

                case "P" -> makePayment(list, scanner);

                //case "L": showLedger???()
                case "L" -> showLedger(list, scanner);
                case "X" -> {
                    System.out.println("Thank you for using Quantify, goodbye!");
                    running = false;
                }

                default -> System.out.println("Invalid choice, please try again");
            }
        }


    }


    private static void makePayment(Ledger list, Scanner scanner) {
        System.out.println("Please enter the payment amount: ex. 129.55");
        double amount = scanner.nextDouble();
        System.out.println("Please enter the vendor name: ex. Etsy");
        String vendor = scanner.nextLine().trim().toUpperCase();
        System.out.println("Enter a brief description of the payment: ex. Crochet Hats");
        String description = scanner.nextLine().trim().toUpperCase();

        list.addTransaction(date, time, description,vendor, amount);
        list.saveToCsv()

    }

    private static void addDeposit(Ledger list, Scanner scanner) {
        System.out.println("Please enter the deposit amount: ex. 12.95");
        double amount = scanner.nextDouble();
        System.out.println("Please enter the vendor name: ex. YUU");
        scanner.nextLine();
        String vendor = scanner.nextLine().trim().toUpperCase();
        System.out.println("Please enter a description of the deposit: ex. Weekly Pay");
        String description = scanner.nextLine().trim().toUpperCase();
    }

    private static void showLedger(Ledger list, Scanner scanner) {
    }

}


