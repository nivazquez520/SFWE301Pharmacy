package InventoryControlFolder;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
   // The single instance of Inventory
    private static Inventory instance;

    // The list of products in the inventory
    public ArrayList<Product> products = new ArrayList<>();

    // Private constructor to prevent instantiation
    private Inventory() {}

    // Public method to provide access to the single instance
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addInventory(int productID, int productQuantityToAdd) {
        boolean itemFound = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                products.get(i).setProductInventoryQuantity(products.get(i).getProductInventoryQuantity() + productQuantityToAdd);
                itemFound = true;
            }
        }
        // if productID is not found in the list or product list is emtpty, add new product to inventory
       if (!itemFound) {
            Scanner scanner = new Scanner(System.in); // Import java.util.Scanner
            System.out.print("Item not found in system. Please enter the product name for product ID " + productID + ": ");
            String productName = scanner.nextLine();
            System.out.print("Please enter the unit price for " + productName + ": ");
            double productPrice = scanner.nextDouble();

            // add product to inventory
            products.add(new Product(productID, productName, productQuantityToAdd, productPrice));
            System.out.println("New product added: " + productName);
       }

    }

    public void deleteInventory(int productID, int productQuantityToDelete) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                products.get(i).setProductInventoryQuantity(products.get(i).getProductInventoryQuantity() - productQuantityToDelete);
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
