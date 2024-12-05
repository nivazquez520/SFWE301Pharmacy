package BackEndFolder;
import java.util.ArrayList;
//import javax.smartcardio.Card;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Backend { //uses shoppingcart.java for shopping cart
    private String accFilePath; //File path containing data of different accounts
    private String CredFilePath; //File path containg data of different Credits Cards
    private String Address = "4521 Healthy BLVD";
    private String OwnerName = "Barce Farkley";
    private CardAccountList CardList;
    private AccountList accountList;
    private PharmInfo pharmInfo;

    public Backend(String accFilePath, String CredFilePath) { //Backend is initialized with names of data files
        this.accFilePath = accFilePath;
        this.CredFilePath = CredFilePath;
        this.CardList = new CardAccountList();
        this.accountList = new AccountList();
        this.pharmInfo = new PharmInfo(Address, OwnerName, 0);
    }

    public Account getAccount(int i) {
        try {
            accountList.get(i);
            System.out.println("Account Found");
            return accountList.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Account out of bounds: " + e.getMessage());
            return null;
        }
    }

    public CardAccount getCardAccount(int i) {
        try {
            CardList.get(i);
            System.out.println("Account Found");
            return CardList.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Card Account out of bounds: " + e.getMessage());
            return null;
        }
    }
    
    public boolean LoadCardInformation() { // loads card information into cardlist from csv files, returns true if file is found and read from successfully
        boolean retval = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(CredFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) { //adds a new account from every line in the CreditCard.csv File
                String [] values = line.split(",");
                System.out.println("NameOnCard: " + values[0] + ", CardNumber: " + values[1] + ", CVV: " + values[2] + ", ZipCode: " + values[3] + ", Balance: " + values[4]);
                CardList.addAccount(values[0], values[1], values[2], values[3], Double.parseDouble(values[4]));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            retval = false;
        }
        return retval;
    }

    public boolean LoadAccountInformation() {//FIXED: set up an account database with a csv files. 
                                                            //Find account informaton based on ID number
        boolean retval = false; // return true if account is foun
        try (BufferedReader reader = new BufferedReader(new FileReader(accFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) { //     account csv set up as: ID, type, username, password, authlevel(emp), 
                String [] values  = line.split(","); // loyProg(cust), Rnoti(cust), Aorder(cust), loyPoints(cust), CardNum(cust);

                if (values[1].equals("Employee")) {
                    Employee employee = new Employee(values[2], values[0], values[3], Integer.parseInt(values[4]));
                    accountList.addAccount(employee);//FIXED: create add account function in AccountList for employees
                    pharmInfo.addEmployee(employee);
                    retval = true;
                }
                else if (values[1].equals("Customer")) {
                    Customer customer = new Customer(values[2], values[0], values[3], Boolean.parseBoolean(values[5]), Boolean.parseBoolean(values[6])
                                                    , Boolean.parseBoolean(values[7]), Integer.parseInt(values[8]), values[9]);
                    accountList.addAccount(customer); //FIXED: create add account function in AccountList for customers
                }
                
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return retval;
        }
        return retval; // returns null if account is not found
    }

    

    public boolean CustomerPurchaseCart(Customer customer, boolean usePoints) {// returns false if customer is not found or cannot make purchase
        int i;
        String custCardNum = customer.getCardNumber();
        boolean retval = false;
        if (CardList.getBalance(custCardNum) <= 0.0) { //if customer is not found, default return in CardAccountList.java
            return retval;
        }
        else { // if the Credit card has more than 0 dollars and likely exists
            double custBalance = CardList.getBalance(custCardNum);
            if (usePoints) { //if customer wants to use points
                if (customer.getLoyalty()) { //handles whether or not customer is part of loyalty program
                    double oldCartTotal = customer.CartTotal();
                    double loyaltyCash = (double) customer.getPoints() / 100.0;
                    double newCartTotal = oldCartTotal - loyaltyCash;
                    if (custBalance - newCartTotal >= 0.0) {
                        System.out.println("Customer purchased entire cart with points!");
                        double remainingBalance = custBalance - newCartTotal;
                        CardList.setNewBalance(custCardNum, remainingBalance);
                        customer.removeCart();
                        retval = true;
                    } else { // When customer has points but still can't afford
                        System.out.println("Customer cannot afford Cart even with points");
                        return retval;
                    }
                }
                else { /// handles when customer wants to use points but is not part of loyalty program
                    System.out.println("Customer wanted to use points but isn't part of program");
                    return retval;
                }
            } else { //handles when customer doesn't want to use points, they will gain points if they are part of the program.
                double CartTotal = customer.CartTotal();
                if (custBalance - CartTotal >= 0.0) {
                    if (customer.getLoyalty()) {
                        customer.addPoints((int)CartTotal * 100);
                    }
                    System.out.println("Custommer purchased entire cart without Points!");
                    double remainingBalance = custBalance - CartTotal;
                    CardList.setNewBalance(custCardNum, remainingBalance);
                    customer.removeCart();
                    retval = true;
                } else {
                    System.out.println("Customer couldn't afford cart without points.");
                }
            }
        }
        return retval;
    }

    //closes the backend of the system by getting storing accounts on files and freeing space on the program.
    public boolean Close() { //FIXME: setup how to have the CardList and AccountList modify their  respective CSV files.
        return false;
    }


}