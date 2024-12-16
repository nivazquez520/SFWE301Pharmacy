
import BackEndFolder.Backend;



public class Main {
    public static void main(String[] args) {
        ReportGenerationFolder.Reports report = new ReportGenerationFolder.Reports();
        Backend backend = new Backend("Accounts.csv", "CreditCard.csv");

        InventoryControlFolder.InventoryManagement inventory = new InventoryControlFolder.InventoryManagement();
        InventoryControlFolder.Inventory inv = new InventoryControlFolder.Inventory();
        // System.out.println("Account list Size: " + backend.sizeAccountList()); // helps test the amount of accounts in accounts.csv
        backend.LoadAccountInformation();
        // System.out.println("Account list size: " + backend.sizeAccountList()); 
        backend.LoadCardInformation();
        // System.out.println("CardList size: " + backend.sizeCardList());//helps test cards in creditcard.csv
        
        //boolean custLogSucc = backend.customerLogin(); // tests customer login
        // if (custLogSucc) { 
             backend.addCustomerAccount(); //tests creating new account
        // }
        // backend.Close();
        // // testing Report Generation Menu
        // report.displayReportMenu();
        
        // inventory.EmployeeCreate();
        // inventory.InventorySystem();
        // inventory.InventoryManage(inv);
        // inventory.SimulateExpire(inv);
    }
}
