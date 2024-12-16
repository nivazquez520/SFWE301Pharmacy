package FrontEndFolder;
import BackEndFolder.Backend;
import java.util.Scanner;

public class FrontEnd {
    public FrontEnd() {
        Scanner scanner = new Scanner(System.in);
        char select;
        
        Backend backend = new Backend("Accounts.csv", "CreditCard.csv");
        backend.LoadAccountInformation();
        backend.LoadCardInformation();

        System.out.print("Employee or Custemr? (e or c) ");
        select = scanner.next().charAt(0);
        
        if (select == 'e') {
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
                System.out.println("Do you want to access to prescriptions? (p)");
                System.out.println("Do you want to access to inventory? (i)");
                System.out.println("Do you want to access to patient data? (d)");
            }
        }

        else if (select == 'c') {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
        }
    }
}
