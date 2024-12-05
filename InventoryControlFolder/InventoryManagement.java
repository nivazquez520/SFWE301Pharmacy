package InventoryControlFolder;
import BackEndFolder.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagement {
    Scanner scnr = new Scanner(System.in);
    Employee currEmployee = null;
    Employee secEmployee = null;
    public ArrayList<Employee> EmployeeCreate() {
        ArrayList<Employee> Employees = new ArrayList<Employee>();
        Employee testManager = new Employee("Manager", "1", "testing", 3);
        Employee testPharmacist = new Employee("Pharmacist", "2", "testing", 2);
        Employee testPharmacyTech = new Employee("Pharmacy Tech", "3", "testing", 1);
        Employee testCashier = new Employee("Cashier", "4", "testing", 0);
        Employees.add(testManager);
        Employees.add(testPharmacist);
        Employees.add(testPharmacyTech);
        Employees.add(testCashier);
        return Employees;
    }
    public Employee InventorySystem() {
        boolean loggedIn = false;
        System.out.println("Entering inventory system");
        Employee currentEmployee = null;
        while (!loggedIn) {
            int test = 0;
        String userName = null;
        String password = null;
        System.out.print("Please enter your username: ");
        userName = scnr.next();
        System.out.print("Please enter your password: ");
        password = scnr.next();
        ArrayList<Employee> Employees = EmployeeCreate();
        for (int i = 0; i < Employees.size(); i++) {
            if (userName.equals(Employees.get(i).getUserName())) {
                if (password.equals(Employees.get(i).setPassword())) {
                    loggedIn = true;
                    System.out.println("Logged in succesfully");
                    currentEmployee = Employees.get(i);
                    test = 1;
                }
                else {
                    System.out.println("Invalid username or password, try again");
                }
            }
        }
        if (test == 0) {
                System.out.println("Invalid username or password, try again");
        }
        }
        currEmployee = currentEmployee;
        return currentEmployee;
    }

    public Employee SecondaryEmployee() {
        boolean loggedIn = false;
        Employee currentEmployee = null;
        int test = 0;
        while (!loggedIn) {
        String userName = null;
        String password = null;
        System.out.print("Please enter secondary username: ");
        userName = scnr.next();
        System.out.print("Please enter secondary password: ");
        password = scnr.next();
        ArrayList<Employee> Employees = EmployeeCreate();
        for (int i = 0; i < Employees.size(); i++) {
            if (userName.equals(Employees.get(i).getUserName())) {
                if (password.equals(Employees.get(i).setPassword())) {
                    loggedIn = true;
                    System.out.println("Logged in succesfully");
                    currentEmployee = Employees.get(i);
                    test = 1;
                }
                else {
                    System.out.println("Invalid username or password, try again");
                }
            }
        }
        if (test == 0) {
                System.out.println("Invalid username or password, try again");
        }
        }
        secEmployee = currentEmployee;
        return currentEmployee;
    }

    public void InventoryManage(Inventory inv) {
        char input = 'y';
        while (input != 'n') {
        System.out.println("Select an option:\na) Add inventory (Manager required)\nb) Delete inventory of controlled substance (Manager+ and Pharmacist+ required)\nc) Remove inventory (Pharmacist+ required)\nn) Exit");
        input = scnr.next().charAt(0);
        if (input == 'a') {
            System.out.println("Enter the product ID");
            int productID = scnr.nextInt();
            System.out.println("Enter the product quantity:");
            int productToAdd = scnr.nextInt();
            System.out.println("Is this a controlled substance? (true or false)");
            boolean control = Boolean.valueOf(scnr.next());
            inv.addInventory(productID, productToAdd, control, currEmployee, 120);
        }
        else if (input == 'b') {
            System.out.println("Enter the product ID");
            int productID = scnr.nextInt();
            System.out.println("Enter the product quantity:");
            int productQuantityToDelete = scnr.nextInt();
            inv.deleteInventoryControlled(productID, productQuantityToDelete, currEmployee, SecondaryEmployee());
        }
        else if (input == 'c') {
            System.out.println("Enter the product ID");
            int productID = scnr.nextInt();
            System.out.println("Enter the product quantity:");
            int productQuantityToDelete = scnr.nextInt();
            inv.deleteInventory(productID, productQuantityToDelete, currEmployee);
        }
        else if (input == 'n') {
        }
        else {
            System.out.println("Invalid input, try again");
        }
        }
    }

    public void SimulateExpire(Inventory inv) {
        System.out.println("Simulating expiration days:");
        System.out.println("Simulating 90 days passed"); 
        inv.decrementExpireEOD(90);
        System.out.println("Simulating 16 more days");
        inv.decrementExpireEOD(16);
        System.out.println("Simulating 7 more days passed");
        inv.decrementExpireEOD(7);
        System.out.println("Simulating 4 more days");
        inv.decrementExpireEOD(4);
        System.out.println("Simulating 3 more days");
        inv.decrementExpireEOD(3);
    }
}
