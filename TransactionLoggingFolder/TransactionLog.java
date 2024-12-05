package TransactionLoggingFolder;
import java.util.ArrayList;

public class TransactionLog {
    public ArrayList<Transaction> transactions;

    // Singleton instance
    public static TransactionLog instance;

    // Private constructor to enforce singleton pattern
    private TransactionLog() {
        transactions = new ArrayList<>();
    }

    // Method to get the singleton instance
    public static TransactionLog getInstance() {
        if (instance == null) {
            instance = new TransactionLog();
        }
        return instance;
    }

    // Method to log a transaction
    public void logTransaction(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaction logged: " + transaction);
    }

    // Method to retrieve the list of transactions
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Method to display the transaction log
    public String displayInfo() {
        StringBuilder report = new StringBuilder();
        String header;
        String row;
        String totalsHeader;
        String totalsRow;
        int transactionNumWidth = 20;      ///  define widths to each table column
        int patientIDWidth = 20;
        int itemsSoldWidth = 20;
        int transactionTypeWidth = 20;
        int transactionAmountWidth = 20;
        int totalNumTransactionsWidth = 25;      // column widths for totals
        int totalItemsSoldWidth = 25;
        int totalSalesWidth = 25;
        int totalItemsSold = 0;
        double totalSales = 0.0;
    
        // Add the header
        header = String.format(
        "| %-"+transactionNumWidth+"s | %-"+patientIDWidth+"s | %-"+itemsSoldWidth+"s | %-"+transactionTypeWidth+"s | %-"+transactionAmountWidth+"s |\n",
        "Transaction Number", "Patient ID", "Items Sold", "Transaction Type", "Transaction Amount ($)");
        report.append(header);
        report.append("\n");
        
        // Add the details for each transaction
        for (int i = 0; i < transactions.size(); i++) {
            row = String.format(
                "| %-"+transactionNumWidth+"s | %-"+patientIDWidth+"s | %-"+itemsSoldWidth+"d | %-"+transactionTypeWidth+"s | %-"+transactionAmountWidth+".2f   |\n",
                "#" + transactions.get(i).getTransactionNumber(),  // Transaction number with #
                transactions.get(i).getPatientID(),                // Patient ID
                transactions.get(i).getNumProductsPurchased(),                // Quantity of items sold
                transactions.get(i).getTransactionType(),          // Transaction type
                transactions.get(i).getTransactionAmount()         // Amount (formatted to 2 decimals)
            );
            totalItemsSold += transactions.get(i).getNumProductsPurchased();
            totalSales += transactions.get(i).getTransactionAmount();
            report.append(row);
        }


        // add totals to the report 
        report.append("\n\n\n\n\n\n\n\n"); // Blank lines before totals
        totalsHeader = String.format(
        "| %-"+totalNumTransactionsWidth+"s | %-"+totalItemsSoldWidth+"s | %-"+totalSalesWidth+"s |\n", 
        "Total # of Transactions", "Total Items Sold", "Total Sales ($)");
        report.append(totalsHeader);
        report.append("\n");

        // Add totals row
        totalsRow = String.format(
        "| %-"+totalNumTransactionsWidth+"d | %-"+totalItemsSoldWidth+"d | %-"+totalSalesWidth+".2f |\n",
         transactions.size(), // Total number of transactions
        totalItemsSold,      // Total items sold
        totalSales);           // Total sales amount (formatted to 2 decimals)
        report.append(totalsRow); 

        return report.toString();     // returns info as string
    }
}