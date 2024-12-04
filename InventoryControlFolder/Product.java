package InventoryControlFolder;

public class Product {
    private int productID = 0;
    private String productName = "";
    private double productPrice = 0.0;
    private int productInventoryQuantity;
    private int productQuantityPurchased;


    public Product(int productID, int productQuantity) {
        this.productID = productID;
        this.productInventoryQuantity = productQuantity;
    }

    public Product(int productID, String productName, double productPrice, int productQuantityPurchased) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantityPurchased = productQuantityPurchased;
        this.productInventoryQuantity = 0;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double newProductPrice) {
        this.productPrice = newProductPrice;
    }

    public int getProductInventoryQuantity() {
        return productInventoryQuantity;
    }

    public void setProductInventoryQuantity(int newProductQuantity) {
        this.productInventoryQuantity = newProductQuantity;
    }

    public int getQuantityPurchased() {
        return productQuantityPurchased;
    }

    public void setQuantityPurchased(int quantityPurchased) {
        this.productQuantityPurchased = quantityPurchased;
    }


}