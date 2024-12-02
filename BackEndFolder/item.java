public class item {
    public String itemName;
    public double itemPrice;
    public int itemQuantity;
    public item() {
        itemName = "null";
        itemPrice = -1.0;
        itemQuantity  = -1;
    }
    public item(String itemName, double itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }
    // setters
    public void setName(String itemName) {
        this.itemName = itemName;
    }
    public void setPrice(double Price) {
        itemPrice = Price;
    }
    public void setQuantity (int Quantity) {
        itemQuantity = Quantity;
    }
    // getters
    public double getTotalPrice() { //returns total price of multiple of same item
        return itemPrice * (double)itemQuantity;
    }
    public String getName() {
        return itemName;
    }
    public double getPrice() {
        return itemPrice;
    }
    public int getQuantity() {
        return itemQuantity;
    }
}