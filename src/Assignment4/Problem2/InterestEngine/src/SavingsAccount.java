import java.util.UUID;

public class SavingsAccount extends BankAccount{

    SavingsAccount(double initialBalance){
        this.interestRate = 0.03; // 3% interest rate on FD account
        this.accountId = UUID.randomUUID();
        this.balance = initialBalance;
    }
    @Override
    void calculateInterest(int years) {
        double interestAmount = years*this.balance*this.interestRate;
        System.out.println("Your Saving Account interest amount is : "+interestAmount+" for "+years+" years");
    }
}
