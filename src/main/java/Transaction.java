import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    //create instance variables
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    // create constructors - 1 empty?
    public Transaction() {
    }

    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // getters + setters for each variable
    public LocalDate getDate() {
        return date;
    }


    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        //String transactionType = "Deposit";
//
            return this.date + "|" + this.time + "|" + this.vendor + "|" + this.description + "|" + this.amount;
        }
    }


