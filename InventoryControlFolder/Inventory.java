package InventoryControlFolder;
import java.util.ArrayList;

public class Inventory {
    public ArrayList<Product> products = new ArrayList<Product>();

    public void addInventory(int productID, int productQuantityToAdd) {
        boolean itemFound = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                products.get(i).setProductQuantity(products.get(i).getProductQuantity() + productQuantityToAdd);
                itemFound = true;
            }
        }
        // if productID is not found in the list or product list is emtpty, add new product to inventory
       if (!itemFound) {
            products.add(new Product(productID, productQuantityToAdd));
       }

    }

    public void deleteInventory(int productID, int productQuantityToDelete) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                products.get(i).setProductQuantity(products.get(i).getProductQuantity() - productQuantityToDelete);
            }
        }

    }

    public String displayInfo() {
        StringBuilder report = new StringBuilder();
    
        // Add the header
        report.append("| Product ID | Product Name | Quantity on hand | Price |\n");
        
        // Add the details for each product
        for (int i = 0; i < products.size(); i++) {
            report.append("| #").append(products.get(i).getProductID()).append(" | ");
            report.append(products.get(i).getProductName()).append(" | ");
            report.append(products.get(i).getProductQuantity()).append(" | ");
            report.append(products.get(i).getProductPrice()).append(" |\n");
        }
        
        return report.toString();     // returns info as string

        /*
        System.out.println("| Product ID | Product Name | Quantity on hand | Price |");
        for (int i = 0; i < products.size(); i++) {
            System.out.print("| #" + products.get(i).getProductID() + " | ");
            System.out.print(products.get(i).getProductName() + " | ");
            System.out.print(products.get(i).getProductQuantity() + " | ");
            System.out.println(products.get(i).getProductPrice() + " |");
        }
        */
    }
}
