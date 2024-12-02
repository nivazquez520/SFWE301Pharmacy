package TransactionLoggingFolder;
import java.util.ArrayList;
import InventoryControlFolder.Product;

public class Transaction {
    private int transactionNumber;
    private String transactionType; 
    private double transactionAmount; 
    private String transactionDate;
    private String transactionTime; 
    private int patientID;
    private String cashierName;
    private ArrayList<Product> productsSold; 
    private int itemsSold;
    private String paymentMethod;


    public Transaction(int transactionNumber, String transactionType, double transactionAmount,
     String transactionDate, String transactionTime, int patientID, String cashierName, ArrayList<Product> productsSold,
     int itemsSold, String paymentMethod) {
        this.transactionNumber = transactionNumber;
        this.transactionType = transactionType; 
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.patientID = patientID; 
        this.cashierName = cashierName; 
        this.productsSold = productsSold;
        this.itemsSold = itemsSold;
        this.paymentMethod = paymentMethod;

        // Automatically add a transaction created to the transaction log
        TransactionLog.getInstance().logTransaction(this);
     }

}