package InventoryControlFolder;

public class Product {
    private int productID = 0;
    private String productName = "";
    private double productPrice = 0.0;
    private int productInventoryQuantity;
    private int productQuantityPurchased;

    private boolean controlledStatus = false;
    private int daysToExpire = -1;

    public Product(int productID, int productQuantity, int daysToExpire) { // use this for testing, probably remove once and use the method below when testing is done
        this.productID = productID;
        this.productInventoryQuantity = productQuantity;
        this.daysToExpire = daysToExpire;
    }

    public Product(int productID, String productName, double productPrice, int productQuantityPurchased) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantityPurchased = productQuantityPurchased;
        this.productInventoryQuantity = 0;
    }

    public Product(int productID, String productName, double productPrice, int productQuantityPurchased, boolean controlledStatus, int daysToExpire) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantityPurchased = productQuantityPurchased;
        this.productInventoryQuantity = 0;
        this.controlledStatus = controlledStatus;
        this.daysToExpire = daysToExpire;
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

    public boolean getControlledStatus() {
        return controlledStatus;
    }

    public int getDaysToExpire() {
        return daysToExpire;
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

    public void setControlledStatus(boolean controlledStatus) {
        this.controlledStatus = controlledStatus;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }
}
