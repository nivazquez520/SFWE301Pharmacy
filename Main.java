
import BackEndFolder.Backend;



public class Main {
    public static void main(String[] args) {
        ReportGenerationFolder.Reports report = new ReportGenerationFolder.Reports();
        Backend backend = new Backend("Accounts.csv", "CreditCard.csv");

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
