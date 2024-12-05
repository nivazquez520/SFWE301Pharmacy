package BackEndFolder;
import java.util.ArrayList;

public class CardAccountList {//CardAccount List uses CardAccount

    //CardAccountList class
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

    public CardAccount get(int i) {// returns card account in list, if out of bounds, returns null
        try {
            System.out.println("Account Found");
            return CardList.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Account out of bounds: " + e.getMessage());
            return null;
        }
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
