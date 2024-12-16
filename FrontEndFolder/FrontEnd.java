package FrontEndFolder;
import BackEndFolder.Backend;
import BackEndFolder.ShoppingCart;
import InventoryControlFolder.Inventory;
import PrescriptionsProcessingFolder.PrescriptionsProcessing;
import java.util.Scanner;


public class FrontEnd {
    Backend backend;
    PrescriptionsProcessing prescriptions;
    Inventory inventories;
    ShoppingCart cart;

    private void pharmacist() {
        int choice;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1. Desplay Prescriptions");
            System.out.println("2. Desplay Inventory");
            System.out.println("3. Delete/Add Prescription");

            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("\nDisplay Prescreptions");
                prescriptions.displayPrescriptions();
            }
            else if (choice == 2) {
                System.out.println("\nDisplay Inventory");
                inventories.displayInfo();
            }
            else if (choice == 3) {
                System.out.println("\n1. Add Prescription");
                System.out.println("3. Delete Prescription");
                
                choice = scanner.nextInt();
                if (choice == 1) {
                    // (int id, String patientName, String medication, String dosage, String instructions)
                    System.out.print("\nEnter patient ID: ");
                    int id = scanner.nextInt();
                    System.out.print("\nEnter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("\nEnter patient medication: ");
                    String medication = scanner.nextLine();
                    System.out.print("\nEnter patient dosage: ");
                    String dosage = scanner.nextLine();
                    System.out.print("\nEnter patient instructions: ");
                    String instructions = scanner.nextLine();

                    prescriptions.add(id, patientName, medication, dosage, instructions);
                }
                
                else if (choice == 2) {
                    System.out.print("\nEnter patient ID: ");
                    int id = scanner.nextInt();
                    System.out.print("\nEnter patient name: ");
                    String patientName = scanner.nextLine();

                    prescriptions.remove(id, patientName);
                }

                else {
                    System.out.println("\nInvalid choice.");
                }
            }

            else {
                System.out.println("\nInvalid choice.");
            }
        }
    }

    public FrontEnd(String accFilePath, String credFilePath, String prescFilePath) {
        try (Scanner scanner = new Scanner(System.in)) {
            char select;
            this.backend = new Backend(accFilePath, credFilePath);
            this.prescriptions = new PrescriptionsProcessing();
            this.prescriptions.loadPrescriptions(prescFilePath);
            this.cart = new ShoppingCart();
            
            backend.LoadAccountInformation();
            backend.LoadCardInformation();

            System.out.print("Employee or Custemr? (e or c) ");
            select = scanner.next().charAt(0);
            
            if (select == 'e') {
                boolean login = false;
                //Account account;

                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                
                for (int i = 0; i < backend.sizeAccountList(); i++) {
                    if (backend.getAccount(i).getUserName().equals(username)) {
                        if (backend.getAccount(i).getPassword().equals(password)) {
                            System.out.println("Login successful!");
                            //account = backend.getAccount(i);
                        }
                    }
                }

                if (!login) {
                    System.out.println("Invalid username or password.");
                }
                else {
                    System.out.println("Are you a pharmacist? (p)");
                    char choice = scanner.next().charAt(0);

                    switch (choice) {
                        case 'p':
                            pharmacist();
                        default:
                            System.out.println("Invalid choice.");
                    }

                }
            }

            else if (select == 'c') {
                boolean login = false;

                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();

                for (int i = 0; i < backend.sizeAccountList(); i++) {
                    if (backend.getAccount(i).getUserName().equals(username)) {
                        if (backend.getAccount(i).getPassword().equals(password)) {
                            System.out.println("Login successful!");
                            login = true;
                        }
                    }
                }

                if (!login) {
                    System.out.println("Invalid username or password.");
                }
                else {
                    System.out.println("\n1. Add items");
                    System.out.println("2. Change quantity");
                    System.out.println("3. Delete item");
                    System.out.println("4. Exit");

                    while (true) {
                        int choice = scanner.nextInt();
                        
                        if (choice == 1) {
                            // int productID, String name, double price, int quantity 
                            System.out.print("\n1. Enter product ID: ");
                            int productID = scanner.nextInt();
                            System.out.print("\n2. Enter product name: ");
                            String name = scanner.nextLine();
                            System.out.print("\n3. Enter product price: ");
                            double price = scanner.nextDouble();
                            System.out.print("\n3. Enter product quantity: ");
                            int quantity = scanner.nextInt();

                            cart.addItem(productID, name, price, quantity);
                        }
                        else if (choice == 2) {
                            System.out.print("\n2. Enter product name: ");
                            String name = scanner.nextLine();
                            System.out.print("\n2. Enter new quantity for product: ");
                            int quantity = scanner.nextInt();

                            cart.changeQuantity(name, quantity);
                        }
                        else if (choice == 3) {
                            System.out.print("\n2. Enter product name: ");
                            String name = scanner.nextLine();
                            
                            cart.removeItem(name);
                        }

                        else if (choice == 4) {
                            break;
                        }
                        else {
                            System.out.println("Invalid choice.");
                        }
                    }
                }
            }

            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
