package InventoryControlFolder;
import java.util.ArrayList;
import BackEndFolder.*;

public class Inventory {
    public ArrayList<Product> products = new ArrayList<>();

    public void addInventory(int productID, int productQuantityToAdd, boolean Controlled, Employee employee, int daysToExpire) {
        if (employee.getAuthLevel() < 3) { // check auth level of employee before performing commands
            System.out.println("Auth level too low, failed to add");
            return;
        }
        boolean itemFound = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                products.get(i).setProductInventoryQuantity(products.get(i).getProductInventoryQuantity() + productQuantityToAdd);
                itemFound = true;
            }
        }
        // if productID is not found in the list or product list is emtpty, add new product to inventory
       if (!itemFound) {
            products.add(new Product(productID, productQuantityToAdd, 120));
       }

    }

    public void deleteInventory(int productID, int productQuantityToDelete, Employee employee) {
        if (employee.getAuthLevel() < 2) { // check auth level
            System.out.println("Auth level too low, failed to delete");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getControlledStatus() == true) {
                System.out.println("Further employee authorization required, use the deleteInventoryControlled method instead.");
            }
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                products.get(i).setProductInventoryQuantity(products.get(i).getProductInventoryQuantity() - productQuantityToDelete);
                System.out.println("Succesful");
            }
        }
    }

    public void deleteInventoryControlled(int productID, int productQuantityToDelete, Employee employeeMain, Employee employeeSup) {
        if ((employeeMain.getAuthLevel() < 3 || employeeSup.getAuthLevel() < 2) || (employeeMain.getAuthLevel() < 2 || employeeSup.getAuthLevel() < 3)) {
            System.out.println("Auth level too low, failed to delete controlled substance, further access required");
            return; // check auth level of both employees, fail to delete if employee auth is below 3 and 2
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                products.get(i).setProductInventoryQuantity(products.get(i).getProductInventoryQuantity() - productQuantityToDelete);
                System.out.println("Succesful");
            }
        }
    }

    public void decrementExpireEOD() { // call this at the end of day so that the drugs expire date is decremented.
        for (int i = 0; i < products.size(); i++) {
            products.get(i).setDaysToExpire(products.get(i).getDaysToExpire() - 1);
            if (products.get(i).getDaysToExpire() == 30 || products.get(i).getDaysToExpire() == 14 || products.get(i).getDaysToExpire() == 7 || products.get(i).getDaysToExpire() == 3) {
                System.out.println("Product: " + products.get(i).getProductName() + "has " + products.get(i).getDaysToExpire() + " left till expiry");
            }
            if (products.get(i).getDaysToExpire() == 0) {
                System.out.println("Product: " + products.get(i).getProductName() + " has expired. Please discard.");
            }
        }
    }

    public void decrementExpireEOD(int days) { // call this at the end of day so that the drugs expire date is decremented.
        for (int i = 0; i < products.size(); i++) {
            products.get(i).setDaysToExpire(products.get(i).getDaysToExpire() - days);
            if (products.get(i).getDaysToExpire() == 30 || products.get(i).getDaysToExpire() == 14 || products.get(i).getDaysToExpire() == 7 || products.get(i).getDaysToExpire() == 3) {
                System.out.println("Product: " + products.get(i).getProductName() + "has " + products.get(i).getDaysToExpire() + " left till expiry");
            }
            if (products.get(i).getDaysToExpire() == 0) {
                System.out.println("Product: " + products.get(i).getProductName() + " has expired. Please discard.");
            }
        }
    }

    public String displayInfo() {
        StringBuilder report = new StringBuilder();
        String header;
        String row;
        int idWidth = 12;      ///  define widths to each table column
        int nameWidth = 20;
        int quantityWidth = 18;
        int priceWidth = 10;
    
        // Add the header
        header = String.format("| %-"+idWidth+"s | %-"+nameWidth+"s | %-"+quantityWidth+"s | %-"+priceWidth+"s |\n",
        "Product ID", "Product Name", "Quantity on hand", "Price ($)");
        report.append(header);
        report.append("\n");
        
        // Add the details for each product
        for (int i = 0; i < products.size(); i++) {
            row = String.format(
            "| %-"+idWidth+"s | %-"+nameWidth+"s | %-"+quantityWidth+"d | %-"+priceWidth+".2f |\n",
            "#" + products.get(i).getProductID(),         // Product ID with #
            products.get(i).getProductName(),             // Product Name
            products.get(i).getProductInventoryQuantity(),         // Quantity
            products.get(i).getProductPrice());   // Price to 2 decimal places
            
            report.append(row);
        }
        return report.toString();     // returns info as string
    }
}
