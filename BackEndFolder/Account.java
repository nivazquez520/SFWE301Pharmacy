package BackEndFolder;
public class Account { //Super class for all accounts including customer, employee
    private String userName;
    private String ID;
    private String password;
    public Account() {
        this.userName = "";
        this.ID = "";
        this.password = "";
    }
    public Account (String userName, String ID, String password) {
        this.userName = userName;
        this.ID = ID;
        this.password = password;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getID() {
        return ID;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setLoyalty(boolean set) {
        //LoyaltyProgram = set;
    }
    public void addPoints(int points) {
       // LoyaltyPoints += points;
    }
    public void spendPoints(int spent) {
    //    LoyaltyPoints -= spent;
    }
    public void setRefillNoti(boolean ReNoti) {
    //    RefillNoti = ReNoti;
    }
    public void setAutoOrder(boolean Auto) {
    //    autoOrder = Auto;
    }
    public void setCardNumber(String CardNumber) {
    //    this.CardNumber = CardNumber;
    }
    // get methods
    public boolean getLoyalty() {
    //    return LoyaltyProgram;
    return false;
    }
    public int getPoints() {
     //   return LoyaltyPoints;
     return 0;
    }
    public boolean getRefillNoti() {
    //    return RefillNoti;
    return false;
    }
    public boolean getAutoOrder() {
    //    return autoOrder;
    return false;
    }
    public String getCardNumber() {
    //    return CardNumber;
    return null;
    }
    public void addItem(int productID, String name, double price, int quant) {
    //    Cart.addItem(productID, name, price, quant);
    }
    public boolean removeItem(String name) {
    //    return Cart.removeItem(name);
    return false;
    }
    public boolean changeQuantItem(String name, int newQuant) {
     //   return Cart.changeQuantity(name, newQuant);
     return false;
    }
    public double CartTotal() { //returns the total of the customers cart
    //    return Cart.cartTotal();
    return 0;
    }
    public void removeCart() {
    //    Cart.removeCart();
    }
}
