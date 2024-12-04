package BackEndFolder;
public class Customer extends Account { //sub class of account
    private boolean LoyaltyProgram;
    private ShoppingCart Cart;
    private boolean RefillNoti;
    private boolean autoOrder;
    private int LoyaltyPoints;
    private String CardNumber;
    public Customer() {
        this.LoyaltyProgram = false;
        this.Cart = new ShoppingCart();
        RefillNoti = false;
        autoOrder = false;
        LoyaltyPoints = 0;
        CardNumber = "";
    }
    public Customer(boolean LProg, boolean RNoti, boolean AOrder, int LoyaltyPoints, String CardNumber) {
        this.LoyaltyProgram = LProg;
        this.RefillNoti = RNoti;
        this.autoOrder = AOrder;
        this.LoyaltyPoints = LoyaltyPoints;
        this.CardNumber = CardNumber;
    }
    // set modifiers
    public void setLoyalty(boolean set) {
        LoyaltyProgram = set;
    }
    public void addPoints(int points) {
        LoyaltyPoints += points;
    }
    public void spendPoints(int spent) {
        LoyaltyPoints -= spent;
    }
    public void setRefillNoti(boolean ReNoti) {
        RefillNoti = ReNoti;
    }
    public void setAutoOrder(boolean Auto) {
        autoOrder = Auto;
    }
    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }
    // get methods
    public boolean getLoyalty() {
        return LoyaltyProgram;
    }
    public int getPoints() {
        return LoyaltyPoints;
    }
    public boolean getRefillNoti() {
        return RefillNoti;
    }
    public boolean getAutoOrder() {
        return autoOrder;
    }
    public String getCardNumber() {
        return CardNumber;
    }
    public void addItem(String name, double price, int quant) {
        Cart.addItem(name, price, quant);
    }
    public boolean removeItem(String name) {
        return Cart.removeItem(name);
    }
    public boolean changeQuantItem(String name, int newQuant) {
        return Cart.changeQuantity(name, newQuant);
    }
    public double CartTotal() { //returns the total of the customers cart
        return Cart.cartTotal();
    }
    public void removeCart() {
        Cart.removeCart();
    }
    
}
