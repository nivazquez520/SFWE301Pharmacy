package BackEndFolder;
import InventoryControlFolder.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

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

    public void addCustomerAccount () {
        Scanner scnr = new Scanner(System.in);
        int i;
        
        System.out.println("Enter desired Username: ");
        String newUser = scnr.next();
        System.out.println("Enter desired Password: ");
        String newPass = scnr.next();
        for (i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUserName() == newUser) {
                System.out.println("Username already taken");
                i = 0;
                System.out.println("Enter desired Username: ");
                newUser = scnr.next();
                System.out.println("Enter desired Password: ");
                newPass = scnr.next();
            }
        }
        Random rand = new Random();
        int custID = rand.nextInt(1000000);
        //Integer.toString(custID);
        Customer tempCust = new Customer(newUser, Integer.toString(custID), newPass, false, false, false, 0, "");
        boolean Rnoti = false, Aorder = false, LProg = false;
        System.out.println("Would you like refill Notifications? (y/n): ");
        if ("y".equals(scnr.next())) {
            tempCust.setRefillNoti(true);
        }
        System.out.println("Would you like Automatic ordering for Prescriptions? (y/n): ");
        if ("y".equals(scnr.next())) {
            tempCust.setAutoOrder(true);
        }
        System.out.println("Would you like to join the Loyalty program? (y/n): ");
        if ("y".equals(scnr.next())) {
            tempCust.setLoyalty(true);
        }
        accountList.addAccount(tempCust);
        int custMenuChoice = 0;
        while (custMenuChoice != 6) {
            System.out.println("Menu for Customer: " + tempCust.getUserName());
            System.out.println("1) Purchase items");
            System.out.println("2) Change Refill Notifications");
            System.out.println("3) Change Automatic Ordering");
            System.out.println("4) Check loyalty points");
            System.out.println("5) Add payment method");
            System.out.println("6) LogOut");
            custMenuChoice = scnr.nextInt();
            switch (custMenuChoice) {
                case 1: 
                    simShoppingCart(tempCust);
                    break;
                case 2:
                    System.out.println("Current Refill Notification Status: " + ((tempCust.getRefillNoti()) ? "ON" : "Off"));
                    System.out.println("Change? (y/n)");
                    if (scnr.next().equals("y")) { tempCust.setRefillNoti(!tempCust.getRefillNoti()); } // sets opposite if change
                    break;
                case 3:
                    System.out.println("Current Auto Order Status: " + ((tempCust.getAutoOrder()) ? "ON" : "Off"));
                    System.out.println("Change? (y/n)");
                    if (scnr.next().equals("y")) { tempCust.setAutoOrder(!tempCust.getAutoOrder()); } // sets opposite if change
                    break;
                case 4:
                    System.out.println("Loyalty points: " + tempCust.getPoints());
                    break;
                case 5:
                    System.out.println("Enter 16 digit Card Number: ");
                    String tempCard = scnr.next();
                    if (tempCard.length() != 16) {
                        System.out.println("Invalid Card Number");
                        break;
                    }
                    tempCust.setCardNumber(tempCard);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
        
    }

    private void simShoppingCart(Customer customer) {
        Scanner scnr = new Scanner(System.in);
        String testIbu = "Ibuprofen";
        double testIbuPrice = 12.00;
        Product product = new Product(5146, testIbu, testIbuPrice, 1);
        String custChoice = "y";
        while (custChoice.equals("y")) {
            System.out.println("Add item by Name: ");
            scnr.next();
            customer.addItem(product.getProductID(), product.getProductName(), product.getProductPrice(), product.getQuantityPurchased());
            System.out.println("Cart Total: $" + customer.CartTotal());
            System.out.println("Add Another item? (y/n)");
            custChoice = scnr.next();
        }
        if (customer.getCardNumber() != "") {
            CustomerPurchaseCart(customer, false);
        }
        else {
            boolean cardComp = false;
            while (!cardComp) {
                System.out.println("Enter payment method (Card Number): ");
                String newCard = scnr.next();
                if (newCard.length() != 16) {
                    System.out.println("Invalid Card Number");
                }
                else {
                    System.out.println("Valid Number");
                    customer.setCardNumber(newCard);
                    cardComp = true;
                }
            }
            CustomerPurchaseCart(customer, false);
        }
    }

    public boolean customerLogin() {
        Scanner scnr = new Scanner(System.in);
        int i;
        boolean retval = false;
        String userName, password;
        System.out.println("Enter userName: ");
        userName = scnr.next();
        System.out.println("Enter Password: ");
        password = scnr.next();
        for (i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUserName().equals(userName) && accountList.get(i).getPassword().equals(password)) {
                System.out.println("Customer login successful");
                retval = true;
                break;
            }
        }
        if (!retval) {
            System.out.println("Customer login unsuccessful");
        }
        return retval;
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

    public int sizeAccountList() {
        return accountList.size();
    }

    public int sizeCardList() {
        return CardList.size();
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
            line = reader.readLine();
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