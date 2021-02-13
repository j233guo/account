package account;

import java.util.Scanner;

public class CheckingAccount extends Account{
    public CheckingAccount(Customer customer, double initialBalance, double balance) {
        super(customer, initialBalance, balance);
        this.type = "Checking";
    }

    @Override
    public void withdrawal() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the amount you want to withdraw: ");
        double amt = Double.parseDouble(input.nextLine());
        if (amt > balance) {
            System.out.println("Please enter an overdraft limit: ");
            double overdraft = Double.parseDouble(input.nextLine());
            if (amt > balance+overdraft) {
                System.out.println("The amount you are trying to withdraw exceeds you current balance\n");
            } else {
                balance -= amt;
            }
        } else {
            balance -= amt;
        }
    }
}
