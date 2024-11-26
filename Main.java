public class Main {
    public static void main(String[] args) {
        // Testing Report Generation 
        ReportGenerationFolder.InventoryReport inventoryReport = new ReportGenerationFolder.InventoryReport();

        try {
            inventoryReport.generateReport();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}