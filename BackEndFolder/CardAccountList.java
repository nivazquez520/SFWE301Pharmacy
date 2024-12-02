
import java.util.ArrayList;

public class CardAccountList {//CardAccount List uses CardAccount
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
    private ArrayList<CardAccount> CardList;
    public CardAccountList() {
        CardList = new ArrayList<>();
    }
    public void addAccount(CardAccount cAcc) { //returns true if account is added successfully
        CardList.add(cAcc);
    }
    public void addAccount(String nameOnCard, String CardNum, String CVV, String ZipCode, double balance) {
        CardAccount newAccount = new CardAccount(nameOnCard, CardNum, CVV, ZipCode, balance);
        CardList.add(newAccount);
    }
    public boolean setNewBalance(String cardNumber, double newBalance) {//returns true if card number is found
        int i;
        boolean retval = false;
        for (i = 0; i < CardList.size(); i++) {
            if (CardList.get(i).getCardNum().equals(cardNumber)) {
                CardList.get(i).setNewBalance(newBalance);
                retval = true;
                break;
            }
        }
        return retval;
    }
    //getters
    // public String getNameOnCard() {
    //     String returnString = "null";
        
    //     return returnString;
    // }
    // public String getCardNum() {
    //     return CardNum;
    // }
    // public String getCVV() {
    //     return CVV;
    // }
    // public String getZipCode() {
    //     return ZipCode;
    // }
    public double getBalance(String CardNumber) {
        int i;
        double balance = -1.0;
        for (i = 0; i < CardList.size(); i++) {
            if (CardList.get(i).getCardNum().equals(CardNumber)) {
                balance = CardList.get(i).getBalance();
                break;
            }
        }
        return balance;
    }
    public int size() {
        return CardList.size();
    }
}
