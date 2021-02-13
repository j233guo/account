package account;

import java.util.ArrayList;

public class FakeDB {
    private ArrayList<Account> accounts;

    public FakeDB() {
    }

    public FakeDB(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public boolean searchForUser(String userName) {
        boolean result = false;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(userName)) {
                result = true;
            }
        }
        return result;
    }

    public boolean loginSuccessful(String username, String password) {
        boolean result = false;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).authenticate(username, password)) {
                result = true;
            }
        }
        return result;
    }

    public String getFullNameByUsername(String username) {
        String name = "";
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                name += accounts.get(i).getCustomer().getFirstName() + " " +
                        accounts.get(i).getCustomer().getLastName();
                break;
            }
        }
        return name;
    }

    public boolean typeAvailableForUser(String username, String type) {
        boolean result = false;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) &&
            accounts.get(i).getType().equals(type)) {
                result = true;
            }
        }
        return result;
    }

    public void AccountOperation(String username, String type) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) &&
            accounts.get(i).getType().equals(type)) {
                accounts.get(i).Operation();
            }
        }
    }

    @Override
    public String toString() {
        return "FakeDB{" +
                "accounts=" + accounts +
                '}';
    }
}
