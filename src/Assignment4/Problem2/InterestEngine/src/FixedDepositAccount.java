import java.util.UUID;

public class FixedDepositAccount extends BankAccount{

    FixedDepositAccount(double initialBalance){
        this.interestRate = 0.09; // 9% interest rate on FD account
        this.accountId = UUID.randomUUID();
        this.balance = initialBalance;
    }
    @Override
    void calculateInterest(int years) {
        double interestAmount = years*this.balance*this.interestRate;
        System.out.println("Your Saving Account interest amount is : "+interestAmount+" for "+years+" years");
    }
}
