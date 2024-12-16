package BackEndFolder;
public class Customer extends Account { //sub class of account
    private boolean LoyaltyProgram;
    private ShoppingCart Cart;
    private boolean RefillNoti;
    private boolean autoOrder;
    private int LoyaltyPoints;
    private String CardNumber;

    public Customer() {
        super();
        this.LoyaltyProgram = false;
        this.Cart = new ShoppingCart();
        this.RefillNoti = false;
        this.autoOrder = false;
        this.LoyaltyPoints = 0;
        this.CardNumber = "";
    }
    
    public Customer(String username, String ID, String password, boolean LProg, boolean RNoti, boolean AOrder, int LoyaltyPoints, String CardNumber) {
        super(username, ID, password);
        this.LoyaltyProgram = LProg;
        this.Cart = new ShoppingCart();
        this.RefillNoti = RNoti;
        this.autoOrder = AOrder;
        this.LoyaltyPoints = LoyaltyPoints;
        this.CardNumber = CardNumber;
    }
    // set modifiers
    @Override
    public void setLoyalty(boolean set) {
        LoyaltyProgram = set;
    }
    @Override
    public void addPoints(int points) {
        LoyaltyPoints += points;
    }
    @Override
    public void spendPoints(int spent) {
        LoyaltyPoints -= spent;
    }
    @Override
    public void setRefillNoti(boolean ReNoti) {
        RefillNoti = ReNoti;
    }
    @Override
    public void setAutoOrder(boolean Auto) {
        autoOrder = Auto;
    }
    @Override
    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }
    @Override
    // get methods
    public boolean getLoyalty() {
        return LoyaltyProgram;
    }
    @Override
    public int getPoints() {
        return LoyaltyPoints;
    }
    @Override
    public boolean getRefillNoti() {
        return RefillNoti;
    }
    @Override
    public boolean getAutoOrder() {
        return autoOrder;
    }
    @Override
    public String getCardNumber() {
        return CardNumber;
    }
    @Override
    public void addItem(int productID, String name, double price, int quant) {
        Cart.addItem(productID, name, price, quant);
    }
    @Override
    public boolean removeItem(String name) {
        return Cart.removeItem(name);
    }
    @Override
    public boolean changeQuantItem(String name, int newQuant) {
        return Cart.changeQuantity(name, newQuant);
    }
    @Override
    public double CartTotal() { //returns the total of the customers cart
        return Cart.cartTotal();
    }
    @Override
    public void removeCart() {
        Cart.removeCart();
    }
    
}
