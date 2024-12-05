package BackEndFolder;

public class CardAccount {

    protected String NameOnCard;
    protected String CardNum;
    protected String CVV;
    protected String ZipCode;
    protected double balance;

    public CardAccount () {
        this.NameOnCard = "";
        this.CardNum = "";
        this.CVV = "";
        this.ZipCode = "";
        this.balance = 0.0;
    }
    public CardAccount(String NameonCard, String CardNum, String CVV, String ZipCode, double balance) {
        this.NameOnCard = NameonCard;
        this.CardNum = CardNum;
        this.CVV = CVV;
        this.ZipCode = ZipCode;
        this.balance = balance;
    }
    //setters
    public void setNewBalance(double newBalance) {
        balance = newBalance;
    }
    //getters
    public String getNameOnCard() {
        return NameOnCard;
    }
    public String getCardNum() {
        return CardNum;
    }
    public String getCVV() {
        return CVV;
    }
    public String getZipCode() {
        return ZipCode;
    }
    public double getBalance() {
        return balance;
    }
}
