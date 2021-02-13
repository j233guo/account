package account;

import java.util.Scanner;

public class SavingsAccount extends Account {
    public SavingsAccount(Customer customer, double initialBalance, double balance) {
        super(customer, initialBalance, balance);
        this.type = "Savings";
    }

    @Override
    public void withdrawal() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the amount you want to withdraw: ");
        double amt = Double.parseDouble(input.nextLine());
        if (amt > balance) {
            System.out.println("The amount you are trying to withdraw exceeds you current balance\n");
        } else {
            balance -= amt;
        }
    }
}
