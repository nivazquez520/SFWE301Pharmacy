package TransactionLoggingFolder;
import InventoryControlFolder.Product;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transaction {
    private static int nextTransactionNumber = 1;
    private int transactionNumber;
    private String transactionType; // (Sale, Return, Pharmacy_Order) 
    private double transactionAmount = 0.0; 
    private String transactionDate;
    private String transactionTime; 
    private int patientID;
    private String cashierName;
    private ArrayList<Product> productsPurchased = new ArrayList<>(); 
    private int numProductsPurchased = 0;
    private String paymentMethod;   // (Cash, Credit, Debit, Check, Insurance)


    public Transaction(String transactionType, int patientID, String cashierName, String paymentMethod) {
        // Format date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        this.transactionNumber = nextTransactionNumber++;
        this.transactionType = transactionType; 
        this.transactionDate = currentDateTime.format(dateFormatter); // e.g., "2024-12-04"
        this.transactionTime = currentDateTime.format(timeFormatter); // e.g., "15:30:45"
        this.patientID = patientID; 
        this.cashierName = cashierName; 
        this.paymentMethod = paymentMethod;

        /*
        // Automatically add a transaction created to the transaction log
        TransactionLog.getInstance().logTransaction(this);
        */
     }

     public Transaction() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format date and time
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


         this.transactionNumber = nextTransactionNumber++;
         this.transactionType = "";
         this.transactionAmount = 0.0;
         this.transactionDate = currentDateTime.format(dateFormatter); // e.g., "2024-12-04"
         this.transactionTime = currentDateTime.format(timeFormatter); // e.g., "15:30:45"
         this.patientID = 0;
         this.cashierName = "";
         this.productsPurchased = new ArrayList<>();
         this.numProductsPurchased = 0;
         this.paymentMethod = "";
     }

     public int getTransactionNumber() {
         return this.transactionNumber;
     }

     public int getPatientID() {
         return this.patientID;
     }

     public String getDate() {
        return this.transactionDate;
     }

     public String getTime() {
        return this.transactionTime;  
     }

     public String getCashierName() {
        return this.cashierName;
     }

     public String getPaymentMethod() {
        return this.paymentMethod;
     }

     public int getNumProductsPurchased() {
         int totalQuantity = 0;
         for (int i = 0; i < productsPurchased.size(); ++i) {
            totalQuantity += productsPurchased.get(i).getQuantityPurchased();
         }
         this.numProductsPurchased = totalQuantity;
         return this.numProductsPurchased;
     }

     public String getTransactionType() {
         return this.transactionType;
     }

     public double getTransactionAmount() {
        double totalAmount = 0.0; 
        // iterate through items purchased list and accumulate total transaction amount 
        // ************** TO DO : implement adding sales tax?
        for (int i = 0; i < productsPurchased.size(); ++i) {
            totalAmount += productsPurchased.get(i).getProductPrice() * productsPurchased.get(i).getQuantityPurchased();
        }
        
        this.transactionAmount = totalAmount;
        return this.transactionAmount; 
     }

     public ArrayList<Product> getProductsPurchased() {
         return this.productsPurchased;
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
         this.productsPurchased.add(purchasedProduct);

         // update total number of products sold in the transaction
         this.numProductsPurchased += quantityPurchased;

         // update transaction amount
         this.transactionAmount += product.getProductPrice() * quantityPurchased;

         // reduce inventory quantity 
         product.setProductInventoryQuantity(product.getProductInventoryQuantity() - quantityPurchased); 
     }

}