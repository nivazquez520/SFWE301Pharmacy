package TransactionLoggingFolder;
import InventoryControlFolder.Product;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaction {
    LocalDateTime currentDateTime = LocalDateTime.now();
    private int transactionNumber;
    private String transactionType; 
    private double transactionAmount; 
    private String transactionDate;
    private String transactionTime; 
    private int patientID;
    private String cashierName;
    private ArrayList<Product> productsSold; 
    private int numProductsSold;
    private String paymentMethod;


    public Transaction(int transactionNumber, String transactionType, double transactionAmount,
     String transactionDate, String transactionTime, int patientID, String cashierName, ArrayList<Product> productsSold,
     int numProductsSold, String paymentMethod) {
        this.transactionNumber = transactionNumber;
        this.transactionType = transactionType; 
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.patientID = patientID; 
        this.cashierName = cashierName; 
        this.productsSold = productsSold;
        this.numProductsSold = numProductsSold;
        this.paymentMethod = paymentMethod;

        // Automatically add a transaction created to the transaction log
        TransactionLog.getInstance().logTransaction(this);
     }

     public Transaction() {
         this.transactionNumber = 0;
         this.transactionType = "";
         this.transactionAmount = 0.0;
         this.transactionDate = currentDateTime.toLocalDate().toString();
         this.transactionTime = currentDateTime.toLocalTime().toString();
         this.patientID = 0;
         this.cashierName = "";
         this.productsSold = new ArrayList<>();
         this.numProductsSold = 0;
         this.paymentMethod = "";
     }

     public int getTransactionNumber() {
         return this.transactionNumber;
     }

     public int getPatientID() {
         return this.patientID;
     }

     public int getNumProductsSold() {
         return this.numProductsSold;
     }

     public String getTransactionType() {
         return this.transactionType;
     }

     public double getTransactionAmount() {
         return this.transactionAmount; 
     }

     public ArrayList<Product> getProductsSold() {
         return this.productsSold;
     }

     public void addProductToTransaction (Product product, int quantityPurchased) {
         if (quantityPurchased > product.getProductInventoryQuantity()) {
            System.out.println("Error: Insufficient stock for " + product.getProductName());
            return;     
         }
         
         // clone product to avoid changing original inventory object
         Product purchasedProduct = new Product(
            product.getProductID(),
            product.getProductName(),
            product.getProductPrice(),
            product.getProductInventoryQuantity()
         );

         // set quantity purchased
         purchasedProduct.setQuantityPurchased(quantityPurchased); // set quantity purchased

         // add product to the productsSold list
         this.productsSold.add(purchasedProduct);

         // update total number of products sold in the transaction
         this.numProductsSold += quantityPurchased;

         // update transaction amount
         this.transactionAmount += product.getProductPrice() * quantityPurchased;

         // reduce inventory quantity 
         product.setProductInventoryQuantity(product.getProductInventoryQuantity() - quantityPurchased); 
     }

}