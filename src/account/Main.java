package account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        FakeDB db = new FakeDB(accounts);

        // fetch the data into fakeDB
	    try {
            BufferedReader input = new BufferedReader(new FileReader("accounts.txt"));
            String line = input.readLine();

            while (line != null) {
                String[] data = line.split(",");
                String username = data[0];
                String password = data[1];
                String fName = data[2];
                String lName = data[3];
                String type = data[4];
                double balance = Double.parseDouble(data[5]);

                Customer c = new Customer(fName, lName, username, password);
                if (type.equals("Checking")) {
                    CheckingAccount ca = new CheckingAccount(c, balance, balance);
                    db.addAccount(ca);
                } else {
                    SavingsAccount sa = new SavingsAccount(c,balance, balance);
                    db.addAccount(sa);
                }
                line = input.readLine();
            }
            input.close();
        } catch(Exception ex) {
	        System.out.println("Error: " + ex.getMessage());
        }

	    // start
	    while (true) {
	        System.out.println("Please enter username: ");
	        String username = userInput.nextLine();
	        if (db.searchForUser(username)) {
	            while (true) {
                    System.out.println("Please enter password: ");
                    String password = userInput.nextLine();
                    if (db.loginSuccessful(username, password)) {

                        System.out.println("\nWelcome " + db.getFullNameByUsername(username) + "\n");

                        while (true) {
                            System.out.println("Which account do you wish to gain access to: \n\n" +
                                " • S or s for Savings\n • C or c for Chequings");
                            String Type = userInput.nextLine();
                            if ((Type.equals("S") || Type.equals("s")) &&
                                    db.typeAvailableForUser(username, "Savings")) {
                                db.AccountOperation(username, "Savings");
                                break;
                            } else if ((Type.equals("C") || Type.equals("c")) &&
                                    db.typeAvailableForUser(username, "Checking")) {
                                db.AccountOperation(username, "Checking");
                                break;
                            } else {
                                System.out.println("This option isn't available for " + username + ". Please try again.\n");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Incorrect password. Try again.");
                    }
                }
	            break;
            } else {
	            System.out.println("This user does not exist. Try Again.");
            }
        }
    }
}
