package ReportGenerationFolder;
import InventoryControlFolder.Product;
import TransactionLoggingFolder.ProductSales;
import TransactionLoggingFolder.Transaction;
import TransactionLoggingFolder.TransactionLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SalesReport{
    LocalDateTime currentDateTime = LocalDateTime.now();
    TransactionLog transactionLog = TransactionLog.getInstance();

    public void displaySalesByDate(String startDateStr, String endDateStr) throws IOException{
        ArrayList<Transaction> transactionList = transactionLog.getTransactionsByDate(startDateStr, endDateStr);
        int columnWidth = 20;

        // Define a data structure to aggregate sales data
            Map<Integer, ProductSales> salesData = new HashMap<>();

            // Process transactions to aggregate sales data
            for (Transaction transaction : transactionList) {
                for (Product product : transaction.getProductsPurchased()) {
                    int productID = product.getProductID();
                    if (salesData.containsKey(productID)) {
                            ProductSales productSales = salesData.get(productID);
                            productSales.setQuantitySold(productSales.getQuantitySold() + product.getQuantityPurchased());
                            productSales.setTotalSales(productSales.getTotalSales() + product.getProductPrice() * product.getQuantityPurchased());
                    } else {
                            salesData.put(productID, new ProductSales(
                                    productID,
                                    product.getProductName(),
                                    product.getProductPrice(),
                                    product.getQuantityPurchased(),
                                    product.getProductPrice() * product.getQuantityPurchased()
                            ));
                        }
                    }
                }

                 // try to open file 
        try (FileOutputStream fileStream = new FileOutputStream("SalesReport.txt");
        PrintWriter outFS = new PrintWriter(fileStream)) {


        // test 
        System.out.println("Starting report generation...");

        // Arriving here implies that the file can now be written
        // to, otherwise an exception would have been thrown.
        outFS.println("Date of Report: " + currentDateTime + "\n\n");
        outFS.println("*** Displaying Sales data from " + startDateStr + " to " + endDateStr + " ***\n\n");
        outFS.println("------------------------------------------------------- SALES REPORT -------------------------------------------------------\n");

        // Table Header
        outFS.printf(
        "| %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s |\n",
        "Product ID", "Product Name", "Product Price ($)", "Quantity Sold", "Total Sales ($)");
        outFS.println("");

            // Write the sales data
            for (ProductSales productSales : salesData.values()) {
                outFS.printf(
                        "| %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s | %-"+columnWidth+"s |\n",
                        productSales.getProductID(),
                        productSales.getProductName(),
                        productSales.getProductPrice(),
                        productSales.getQuantitySold(),
                        productSales.getTotalSales()
                );
            }

        outFS.println("\n----------------------------------------------------------------------------------------------------------------------------");

        
        // Done with file, so try to close
        // Note that close() may throw an IOException on failure
        outFS.flush();
        outFS.close();


        // print statement for testing
        System.out.println("Report successfully generated.");
        }

    }


    public void generateReport() throws IOException {
        int idWidth = 20;      ///  define widths to each table column
        int nameWidth = 20;
        int priceWidth = 20;
        int quantityWidth = 20;
        int totalSalesWidth = 20;


        // Define a data structure to aggregate sales data
            Map<Integer, ProductSales> salesData = new HashMap<>();

            // Process transactions to aggregate sales data
            for (Transaction transaction : transactionLog.getTransactions()) {
                for (Product product : transaction.getProductsPurchased()) {
                    int productID = product.getProductID();
                    if (salesData.containsKey(productID)) {
                            ProductSales productSales = salesData.get(productID);
                            productSales.setQuantitySold(productSales.getQuantitySold() + product.getQuantityPurchased());
                            productSales.setTotalSales(productSales.getTotalSales() + product.getProductPrice() * product.getQuantityPurchased());
                    } else {
                            salesData.put(productID, new ProductSales(
                                    productID,
                                    product.getProductName(),
                                    product.getProductPrice(),
                                    product.getQuantityPurchased(),
                                    product.getProductPrice() * product.getQuantityPurchased()
                            ));
                        }
                    }
                }



        // try to open file 
        try (FileOutputStream fileStream = new FileOutputStream("SalesReport.txt");
        PrintWriter outFS = new PrintWriter(fileStream)) {


        // test 
        System.out.println("Starting report generation...");

        // Arriving here implies that the file can now be written
        // to, otherwise an exception would have been thrown.
        outFS.println("Date of Report: " + currentDateTime + "\n");
        outFS.println("------------------------------------------------------- SALES REPORT -------------------------------------------------------\n");

        // Table Header
        outFS.printf(
        "| %-"+idWidth+"s | %-"+nameWidth+"s | %-"+priceWidth+"s | %-"+quantityWidth+"s | %-"+totalSalesWidth+"s |\n",
        "Product ID", "Product Name", "Product Price ($)", "Quantity Sold", "Total Sales ($)");
        outFS.println("");

            // Write the sales data
            for (ProductSales productSales : salesData.values()) {
                outFS.printf(
                        "| %-"+idWidth+"s | %-"+nameWidth+"s | %-"+priceWidth+"s | %-"+quantityWidth+"s | %-"+totalSalesWidth+"s |\n",
                        productSales.getProductID(),
                        productSales.getProductName(),
                        productSales.getProductPrice(),
                        productSales.getQuantitySold(),
                        productSales.getTotalSales()
                );
            }

        outFS.println("\n----------------------------------------------------------------------------------------------------------------------------");

        
        // Done with file, so try to close
        // Note that close() may throw an IOException on failure
        outFS.flush();
        outFS.close();


        // print statement for testing
        System.out.println("Report successfully generated.");
        }
    }
    
}