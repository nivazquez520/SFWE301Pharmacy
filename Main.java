
import BackEndFolder.Backend;
import FrontEndFolder.FrontEnd;



public class Main {
    public static void main(String[] args) {
        ReportGenerationFolder.Reports report = new ReportGenerationFolder.Reports();
        Backend backend = new Backend("Accounts.csv", "CreditCard.csv");
        FrontEnd frontend = new FrontEnd(backend, "Prescriptions.csv");
        frontend.start();

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
