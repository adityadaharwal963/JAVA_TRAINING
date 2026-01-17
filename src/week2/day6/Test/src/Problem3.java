public class Problem3 {

    public static void main(String[] args) {
        Account acc = new SavingAccount("ram",10000,1);
        acc.calculateInterest();
    }
}

abstract class Account{
    private int accountNumber;
    private String name;
    private int balance;

    abstract void calculateInterest();

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

class SavingAccount extends Account{
    public SavingAccount(String name, int balance , int accountNumber) {
        this.setBalance(balance);
        this.setName(name);
        this.setAccountNumber(accountNumber);
    }

    @Override
    void calculateInterest() {
        System.out.println("Interest for SavingAccount is 5%");
        System.out.println(this.getBalance()*0.05);
    }
}

class FixedDepositAccount extends Account{
    @Override
    void calculateInterest() {
        System.out.println("Interest for FixedDeposit is 9%");
        System.out.println(this.getBalance()*0.09);
    }
}