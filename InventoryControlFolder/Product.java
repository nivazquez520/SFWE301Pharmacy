package InventoryControlFolder;

public class Product {
    private int productID;
    private String productName;
    private double productPrice;
    private int productQuantity;

    public Product(int productID, int productQuantity) {
        this.productID = productID;
        this.productQuantity = productQuantity;
    }

    public Product(int productID, String productName, double productPrice, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
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

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int newProductQuantity) {
        this.productQuantity = newProductQuantity;
    }


}