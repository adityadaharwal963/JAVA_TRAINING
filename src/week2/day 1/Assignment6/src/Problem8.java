import java.util.Scanner;

public class Problem8 {
    /*
    8. Bank Account Management
    Simulate a simple banking system:
        ● Implement a withdraw(double amount) method.
        ● If the withdrawal amount exceeds the account balance, throw a custom
        InsufficientFundsException.
        ● Handle the exception in the main program and display a user-friendly error
        message.
     */
    public static void simulateBank(){
        Scanner sc = new Scanner(System.in);
        //create a demo account
        System.out.println("Initial Account Opening: ");
        System.out.println("Enter Username:");
        String username = sc.next();
        System.out.println("Enter initial deposit amount: ");
        int balance = sc.nextInt();
        Account account = new Account(balance,username);
        int choice;

        do {
            System.out.println("1. withdraw");
            System.out.println("2. exit");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Withdraw amount");
                    int withDrawAmount = sc.nextInt();
                    try{
                        account.withdraw(withDrawAmount);
                    }catch (InsufficientFundsException e){
                        System.out.println("Transaction Failed");
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("invalid Choice");
            }
        }while (choice!=2);
        sc.close();
    }

}

class Account{

    private int balance;
    private String username;

    public int getBalance() {
        return balance;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Account(int balance, String username) {
        this.balance = balance;// set initial balance
        this.username = username;
    }

    public void withdraw(int amount) throws InsufficientFundsException{
        if(balance<amount){
            throw new InsufficientFundsException("Your balance is insufficient for given amount");
        }
        balance -= amount;
        System.out.println("Current Balance after Withdraw: "+balance);
    }
}

class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String msg){
        super(msg);
    }
}