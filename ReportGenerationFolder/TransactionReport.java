package ReportGenerationFolder;
import InventoryControlFolder.Product;
import TransactionLoggingFolder.Transaction;
import TransactionLoggingFolder.TransactionLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


public class TransactionReport {
    LocalDateTime currentDateTime = LocalDateTime.now();

    public void generateReport() throws IOException {
        TransactionLog transactionLog = TransactionLog.getInstance();

         // try to open file 
        try (FileOutputStream fileStream = new FileOutputStream("TransactionReport.txt");
        PrintWriter outFS = new PrintWriter(fileStream)) {

        // add transactions for tests
        Transaction t1 = new Transaction("Sale", 123456, "Seti", "Cash");
        Transaction t2 = new Transaction();
        Transaction t3 = new Transaction("Return", 456789, "Ali", "Credit");

        t1.getProductsPurchased().add(new Product(101, "Ibuprofen", 9.99, 2));
        transactionLog.logTransaction(t1);

        t2.getProductsPurchased().add(new Product(102, "Excedrin", 20.99, 4));
        t2.getProductsPurchased().add(new Product(101, "Ibuprofen", 9.99, 1));
        transactionLog.logTransaction(t2);

        t3.getProductsPurchased().add(new Product(103, "Tylenol", 15.99, 6));
        transactionLog.logTransaction(t3);


        System.out.println("Starting report generation...");

        // Arriving here implies that the file can now be written
        // to, otherwise an exception would have been thrown.
        outFS.println("Date of Report: " + currentDateTime + "\n");
        outFS.println("------------------------------------------------------------ TRANSACTION REPORT ------------------------------------------------------------\n");
        outFS.println(transactionLog.displayInfo());
        outFS.println("--------------------------------------------------------------------------------------------------------------------------------------------");

        
        // Done with file, so try to close
        // Note that close() may throw an IOException on failure
        outFS.flush();
        outFS.close();


        // print statement for testing
        System.out.println("Report successfully generated.");
        }
    }
    
}