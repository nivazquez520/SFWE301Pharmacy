package ReportGenerationFolder;
import TransactionLoggingFolder.Transaction;
import TransactionLoggingFolder.TransactionLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;


public class TransactionReport {
    Scanner scanner = new Scanner(System.in);
    LocalDateTime currentDateTime = LocalDateTime.now();

    public void generateReport() throws IOException {
        TransactionLog transactionLog = new TransactionLog();

         // try to open file 
        try (FileOutputStream fileStream = new FileOutputStream("TransactionReport.txt");
        PrintWriter outFS = new PrintWriter(fileStream)) {

        // add transactions for tests
        Transaction t1 = new Transaction();
        Transaction t2 = new Transaction();
        Transaction t3 = new Transaction();

        transactionLog.logTransaction(t1);
        transactionLog.logTransaction(t2);
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