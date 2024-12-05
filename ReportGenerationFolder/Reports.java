package ReportGenerationFolder;
import java.io.IOException;
import java.util.Scanner;

public class Reports {
    Scanner scanner = new Scanner(System.in);

        public void displayReportMenu() {
            char reportType;
            char response = 'y';
            ReportGenerationFolder.InventoryReport inventoryReport = new ReportGenerationFolder.InventoryReport();
            ReportGenerationFolder.SalesReport salesReport = new ReportGenerationFolder.SalesReport();
            ReportGenerationFolder.TransactionReport transactionReport = new ReportGenerationFolder.TransactionReport();

            try {

            while (response == 'y') {
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
                        case 'c' -> {
                            System.out.println("Would you like to generate a report for a specific transaction? (y/n)");
                            char specificTransaction = scanner.next().charAt(0);
                            if (specificTransaction == 'y') {
                                System.out.println("Please enter the transaction number: ");
                                int transactionNumber = scanner.nextInt();
                                transactionReport.displayIndividualTransaction(transactionNumber);
                            }
                            else {
                                System.out.println("Generating report for all transactions...");
                                transactionReport.generateReport();
                            }
                        }
                        case 'x' -> {response = 'n'; // Ensure the outer loop exits.
                                    break;     // Exit the menu loop immediately.
                        }
                        default -> System.out.println("Invalid input.Please enter valid menu option.");
                    }

                    if (reportType == 'x') {         // break out of menu if Exit option is selected
                        break;
                    }

                    System.out.println("\n\nWould you like to generate another report? (y/n)");
                    response = scanner.next().charAt(0);
            }

            if (response != 'y') {
                System.out.println("Exiting Report Generation Menu...");
            }

            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}