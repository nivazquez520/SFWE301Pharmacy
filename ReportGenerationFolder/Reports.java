package ReportGenerationFolder;
import java.io.IOException;
import java.util.Scanner;

public class Reports {
    Scanner scanner = new Scanner(System.in);

        public void displayReportMenu() {
            char reportType;
            ReportGenerationFolder.InventoryReport inventoryReport = new ReportGenerationFolder.InventoryReport();
            ReportGenerationFolder.SalesReport salesReport = new ReportGenerationFolder.SalesReport();
            ReportGenerationFolder.TransactionReport transactionReport = new ReportGenerationFolder.TransactionReport();

            try {

            System.out.println("Which kind of report would you like to generate?");
            System.out.println("a) Inventory Report");
            System.out.println("b) Sales Report");
            System.out.println("c) Transaction Report");
            System.out.println("x) Exit Report Generation menu");
            reportType = scanner.next().charAt(0);

           // generate report based on user input
                switch(reportType) {
                    case 'a' -> inventoryReport.generateReport();
                    case 'b' -> salesReport.generateReport();
                    case 'c' -> transactionReport.generateReport();
                    case 'x' -> System.out.println("Exiting Report Generation menu...");
                    default -> System.out.println("Invalid input.Please enter valid menu option.");
                }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}