package ReportGenerationFolder;
import InventoryControlFolder.Product;
import TransactionLoggingFolder.Transaction;
import TransactionLoggingFolder.TransactionLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;


public class TransactionReport {
    LocalDateTime currentDateTime = LocalDateTime.now();
    TransactionLog transactionLog = TransactionLog.getInstance();


    public void displayIndividualTransaction(int transactionNumber) throws IOException {
        int columnWidth = 20;
        Transaction transaction = transactionLog.getIndividualTransaction(transactionNumber);

         // try to open file 
        try (FileOutputStream fileStream = new FileOutputStream("TransactionReport.txt");
        PrintWriter outFS = new PrintWriter(fileStream)) {


        System.out.println("Starting report generation...");

        // Arriving here implies that the file can now be written
        // to, otherwise an exception would have been thrown.
        outFS.println("Date of Report: " + currentDateTime + "\n");
        outFS.println("------------------------------------------------------------ TRANSACTION SUMMARY ------------------------------------------------------------\n");
        
         // Transaction details table header
        outFS.printf(
            "| %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s |\n",
            "Transaction Number", "Patient ID", "Date", "Time", "Cashier Name", "Payment Method");
        outFS.println("| " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " |");

        // Transaction details
        outFS.printf(
            "| %-"+columnWidth+"d | %-"+columnWidth+"d | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s |\n",
            transaction.getTransactionNumber(),
            transaction.getPatientID(),
            transaction.getDate(),
            transaction.getTime(),
            transaction.getCashierName(),
            transaction.getPaymentMethod());
        outFS.println("");


        // Product details table header
        outFS.println("********************************************* PRODUCTS PURCHASED *********************************************\n");
        outFS.printf(
            "| %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s |\n",
            "Product ID", "Product Name", "Product Price ($)", "Quantity Sold");
        outFS.println("| " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " |");

        // Product details rows
        for (Product product : transaction.getProductsPurchased()) {
            outFS.printf(
                "| %-"+columnWidth+"d | %-"+columnWidth+"s | %-"+columnWidth+".2f | %-"+columnWidth+"d |\n",
                product.getProductID(),
                product.getProductName(),
                product.getProductPrice(),
                product.getQuantityPurchased());
        }
        outFS.println("| " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " | " + "-".repeat(columnWidth) + " |");


        // Transaction total
        outFS.printf("\n\n\n>>> Transaction Total:  $%.2f", transaction.getTransactionAmount());

        outFS.println("\n\n--------------------------------------------------------------------------------------------------------------------------------------------");

        
        // Done with file, so try to close
        // Note that close() may throw an IOException on failure
        outFS.flush();
        outFS.close();


        // print statement for testing
        System.out.println("Report successfully generated.");
        }

    }

    public void displayTransactionsByDate(String startDateStr, String endDateStr) throws IOException{
        int columnWidth = 20;
        int totalsColumnWidth = 25;
        int totalItemsSold = 0;
        double totalSales = 0.0;
        ArrayList<Transaction> transactionList = transactionLog.getTransactionsByDate(startDateStr, endDateStr);


         // try to open file 
        try (FileOutputStream fileStream = new FileOutputStream("TransactionReport.txt");
        PrintWriter outFS = new PrintWriter(fileStream)) {
            System.out.println("Starting report generation...");

        // Arriving here implies that the file can now be written
        // to, otherwise an exception would have been thrown.
        outFS.println("Date of Report: " + currentDateTime + "\n\n");
        outFS.println("*** Displaying transactions between " + startDateStr + " and " + endDateStr + " ***\n\n");
        outFS.println("------------------------------------------------------------ TRANSACTION REPORT ------------------------------------------------------------\n");

        // Transaction details table header
        outFS.printf(
        "| %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s |\n",
        "Transaction Number", "Patient ID", "Items Sold", "Transaction Type", "Transaction Amount ($)");
        
        outFS.println();
        // Transaction details
        for (Transaction transaction: transactionList) {
            outFS.printf(
                "| %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"d | %-"+columnWidth+"s | %-"+columnWidth+".2f   |\n",
                "#" + transaction.getTransactionNumber(),
                transaction.getPatientID(),
                transaction.getNumProductsPurchased(),
                transaction.getTransactionType(),
                transaction.getTransactionAmount()
            );
            totalItemsSold += transaction.getNumProductsPurchased();
            totalSales += transaction.getTransactionAmount();
        }

        // add totals to the report 
        outFS.println("\n\n\n\n\n\n\n\n"); // Blank lines before totals
        outFS.printf(
        "| %-"+totalsColumnWidth+"s | %-"+totalsColumnWidth+"s | %-"+totalsColumnWidth+"s |\n", 
        "Total # of Transactions", "Total Units Sold", "Total Sales ($)");
        outFS.println("");

        // Add totals row
        outFS.printf(
        "| %-"+totalsColumnWidth+"d | %-"+totalsColumnWidth+"d | %-"+totalsColumnWidth+".2f |\n",
         transactionList.size(), // Total number of transactions
        totalItemsSold,         // Total items sold
        totalSales);           // Total sales amount (formatted to 2 decimals)

        outFS.println("\n\n\n");


        outFS.println("--------------------------------------------------------------------------------------------------------------------------------------------");

        
        // Done with file, so try to close
        // Note that close() may throw an IOException on failure
        outFS.flush();
        outFS.close();


        // print statement for testing
        System.out.println("Report successfully generated.");
        }

    }

    public void generateReport() throws IOException {

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