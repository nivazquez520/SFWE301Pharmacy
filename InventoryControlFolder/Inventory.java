package InventoryControlFolder;
import java.util.ArrayList;

public class Inventory {
    public ArrayList<Product> products = new ArrayList<>();

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
            products.get(i).getProductQuantity(),         // Quantity
            products.get(i).getProductPrice());   // Price to 2 decimal places
            
            report.append(row);
        }
        return report.toString();     // returns info as string
    }
}
