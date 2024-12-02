package ReportGenerationFolder;
import InventoryControlFolder.Inventory;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class InventoryReport {
    LocalDateTime currentDateTime = LocalDateTime.now();

    public void generateReport() throws IOException {
        Inventory inventory = new Inventory();

        // try to open file 
        try (FileOutputStream fileStream = new FileOutputStream("InventoryReport.txt");
        PrintWriter outFS = new PrintWriter(fileStream)) {


        // adding inventory for tests
        inventory.addInventory(11111, 3);    // addInventory(productID, quantityToAdd)
        inventory.addInventory(11112, 5);
        

        // test 
        System.out.println("Starting report generation...");

        // Arriving here implies that the file can now be written
        // to, otherwise an exception would have been thrown.
        outFS.println("Date of Report: " + currentDateTime + "\n");
        outFS.println("---------------------- Inventory Report ----------------------\n");
        outFS.println(inventory.displayInfo());
        outFS.println("--------------------------------------------------------------");

        
        // Done with file, so try to close
        // Note that close() may throw an IOException on failure
        outFS.flush();
        outFS.close();


        // print statement for testing
        System.out.println("Report successfully generated.");
        }
    }
    
}