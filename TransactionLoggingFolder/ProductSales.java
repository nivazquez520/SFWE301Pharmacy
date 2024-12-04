package TransactionLoggingFolder;

public class ProductSales {
    private int productID;
    private String productName;
    private double productPrice;
    private int quantitySold;
    private double totalSales;

    public ProductSales(int productID, String productName, double productPrice, int quantitySold, double totalSales) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantitySold = quantitySold;
        this.totalSales = totalSales;
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

    public int getQuantitySold() {
        return quantitySold;
    }

    public double getTotalSales() {
        totalSales = productPrice * quantitySold;
        return totalSales;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
}