

public class Main {
    public static void main(String[] args) {
        ReportGenerationFolder.Reports report = new ReportGenerationFolder.Reports();

        InventoryControlFolder.InventoryManagement inventory = new InventoryControlFolder.InventoryManagement();
        InventoryControlFolder.Inventory inv = new InventoryControlFolder.Inventory();

        // testing Report Generation Menu
        report.displayReportMenu();

        inventory.EmployeeCreate();
        inventory.InventorySystem();
        inventory.InventoryManage(inv);
        inventory.SimulateExpire(inv);
    }
}
