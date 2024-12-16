package BackEndFolder;

import java.util.ArrayList;
public class AccountList {
    private final ArrayList<Account> AccList;
    private int Accounts;

    public AccountList() {
        this.AccList = new ArrayList<>();
        this.Accounts = 0;
    }

    public int size() {
        return Accounts;
    }

    public boolean addAccount(Account account) {
        boolean retval = false;
        int i;
        
        if (AccList.isEmpty()) {
            retval = true;
            AccList.add(account);
            Accounts++;
            return retval;
        }
        else {
            for (i = 0; i < AccList.size(); i++) {
                if (AccList.get(i).getID().equals(account.getID())) {
                    retval = false;
                    return retval;
                }
            }
            retval = true;
            AccList.add(account);
            Accounts++;
            return retval;
        }
    }

    public boolean addAccount(Employee account) { //for employees
        boolean retval = false;
        int i;
        
        if (AccList.isEmpty()) {
            retval = true;
            AccList.add(account);
            Accounts++;
            return retval;
        }
        else {
            for (i = 0; i < AccList.size(); i++) {
                if (AccList.get(i).getID().equals(account.getID())) {
                    retval = false;
                    return retval;
                }
            }
            retval = true;
            AccList.add(account);
            Accounts++;
            return retval;
        }
    }

    public boolean addAccount(Customer account) {
        boolean retval = false;
        int i;
        
        if (AccList.isEmpty()) {
            retval = true;
            AccList.add(account);
            Accounts++;
            return retval;
        }
        else {
            for (i = 0; i < AccList.size(); i++) {
                if (AccList.get(i).getID().equals(account.getID())) {
                    retval = false;
                    return retval;
                }
            }
            retval = true;
            AccList.add(account);
            Accounts++;
            return retval;
        }
    }

    public Account get(int i) { //returns account found at index, otherwise throws exception and returns null
        try {
            return AccList.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of range:" + e.getMessage());
            return null;
        }
    }

    
}
