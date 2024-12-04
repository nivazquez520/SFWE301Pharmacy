package BackEndFolder;
import java.util.ArrayList;

public class ShoppingCart { //uses item.java for items.
    //private item [] itemArray;
    private ArrayList<item> itemArray = new ArrayList<>();
    //private int arraySize;
    private int items;
    //private final double OverRatio = 0.75; //used to determine when to resize, now useless now that we use lists
    //private final double underRatio = 0.25; //used to determine when to resize

    public ShoppingCart() { //default constructor
        itemArray = new ArrayList<>();
        //itemArray = new item[100];
        //arraySize = 100;
        items = 0;
    }
    public ShoppingCart(int size) { // constructor with size, useless now that we use lists
        //itemArray = new item[size];
        itemArray = new ArrayList<>();
        //arraySize = size;
        items = 0;
    }
    public int Length() {
        return itemArray.size(); //returns the size of whole list
    }
    public int numItems() { //returns the number of items, independent of quantity, just by name
        return items;
    }
    public void addItem(String name, double price, int quantity) {
        int i;
        item newItem = new item(name, price, quantity);
        for (i = 0; i < itemArray.size(); i++) { //checks to see if item is already in list
            if (itemArray.get(i).getName().equals(name)) {
                int oldquant = itemArray.get(i).getQuantity();
                itemArray.get(i).setQuantity(quantity + oldquant);
            }
        }
        for (i = 0; i < itemArray.size(); i++) { //checks after item isn't already found
            if (itemArray.get(i).getName().equals("null")) { // if the array element is empty
                itemArray.set(i, newItem);
                items++;
                break;
            }
        }
        
    }
    public boolean removeItem(String name) { //returns true if item is found and removed, false otherwise
        //item removedItem = new item();
        int i;
        boolean retval = false;
        for (i = 0; i < itemArray.size(); i++) {
            if (itemArray.get(i).getName().equals(name)) {
                //removedItem = itemArray.get(i);
                itemArray.remove(i);
                retval = true;
            }
        }
        return retval;
    }
    public boolean changeQuantity(String name, int newQuant) { //changes quantity of an item given the name, returns false if item is not found
        int i;
        //item newQuantItem = new item();
        boolean retval = false;
        for (i = 0; i < itemArray.size(); i++) {
            if (itemArray.get(i).getName().equals(name)) {
                itemArray.get(i).setQuantity(newQuant);
                return true;
            }
        }
        return retval;
    }
    public double cartTotal() {
        double total = 0.0;
        int i;
        for (i = 0; i < itemArray.size(); i++) {
            if (itemArray.get(i).getPrice() >= -1.0) {
                total += itemArray.get(i).getTotalPrice();
            }
        }
        return total;
    }
    public void removeCart() {
        int i;
        for (i = 0; i < itemArray.size(); i++) {
            itemArray.remove(i);
        }
    }

    
}
