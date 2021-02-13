package account;

import java.util.Scanner;

public abstract class Account {
    protected Customer customer;
    protected double initialBalance;
    protected double balance;
    protected String type;

    public Account(Customer customer, double initialBalance, double balance) {
        this.customer = customer;
        this.initialBalance = initialBalance;
        this.balance = balance;
    }

    public Account() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public String getUsername() {
        return customer.getUsername();
    }

    public String getType() {
        return type;
    }

    public boolean authenticate(String username, String password) {
        return username.equals(customer.getUsername()) &&
                password.equals(customer.getPassword());
    }

    public void withdrawal() {}

    public void deposit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the amount you want to put into the account: ");
        double amt = Double.parseDouble(input.nextLine());
        this.balance += amt;
    }

    public void Operation() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nName " + customer.getFirstName() +" "+ customer.getLastName() + "\n");
            System.out.println("Account: " + type + "\n");
            System.out.println("Balance: " + balance + "\n");
            System.out.println("What do you want to do today? \n" +
                    " • W or w for Withdraw \n • D or d for deposit \n • E or e for Exit");
            String response = input.nextLine();
            if (response.equals("E") || response.equals("e")) {
                System.out.println("\nName " + customer.getFirstName() +" "+ customer.getLastName());
                System.out.println("ID: " + customer.getUsername());
                System.out.println("Initial account balance: " + initialBalance);
                System.out.println("Current balance: " + balance);
                return;
            } else if (response.equals("W") || response.equals("w")) {
                withdrawal();
            } else if (response.equals("D") || response.equals("d")){
                deposit();
            } else {
                System.out.println("This is not a valid operation. Please try again.");
            }
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "customer=" + customer +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }
}
