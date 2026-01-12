package Assignment1;

import java.util.Scanner;

class Account {
    private int balance;
    private int dailyWithdrawLimit;
    private int transactionAmount;

    public Account(int balance, int dailyWithdrawLimit) {
        this.balance = balance;
        this.dailyWithdrawLimit = dailyWithdrawLimit;
    }

    public int getBalance() {
        return balance;
    }

    public int deductAmount(int amount) {
        this.balance -= amount;
        return this.balance;
    }

    public void addTransactions(int amount) {
        transactionAmount += amount;
    }

    public int getTransactions() {
        return transactionAmount;
    }

    public boolean dailyLimitOver(){
        return transactionAmount> dailyWithdrawLimit;
    }

}
public class Problem6ATM {
    //Validate withdrawal request;
    void doTransaction(Account a, int amount){
        if(!a.dailyLimitOver()) {
            if (amount % 100 == 0) {
                int balance = a.getBalance();
                if (balance - amount > 2000) {
                    balance = a.deductAmount(amount);
                    a.addTransactions(amount);
                    System.out.println("Current Balance:" + balance);
                } else {
                    System.out.println("Insufficient balance");
                }
            } else {
                System.out.println("Enter amount in multiple 100");
            }
        }else {
            System.out.println("Daily Withdraw Limit Over, pls try Tomorrow");
        }
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Details (banker):");
        System.out.println("Balance:");
        int balance = sc.nextInt();
        System.out.println("Daily Withdraw Limit:");
        int dailyLimit = sc.nextInt();
        Account acc = new Account(balance,dailyLimit);
        System.out.println("Welcome to ATM");
        System.out.println("Do want to Withdraw (yes/no)");
        boolean choice = sc.next().equalsIgnoreCase("yes");
        while (choice) {
            System.out.println("Please Enter Amount:");
            int amount = sc.nextInt();
            doTransaction(acc,amount);
            System.out.println("Do want to Withdraw (yes/no)");
            choice = sc.next().equalsIgnoreCase("yes");
        }
        System.out.println("Total Transactions:"+acc.getTransactions());
        System.out.println("Current Balance:"+acc.getBalance());
        sc.close();
    }

}
