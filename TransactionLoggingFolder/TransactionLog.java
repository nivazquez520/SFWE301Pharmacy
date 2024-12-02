package TransactionLoggingFolder;
import java.util.ArrayList;

public class TransactionLog {
    public ArrayList<Transaction> transactions;

    // Singleton instance
    private static TransactionLog instance;

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
}