import java.util.UUID;

public class FixedDepositAccount extends BankAccount{

    FixedDepositAccount(double initialBalance){
        this.setInterestRate(0.09); // 9% interest rate on FD account
        this.setAccountId(UUID.randomUUID());
        this.setBalance(initialBalance);
    }
    @Override
    void calculateInterest(int years) {
        double interestAmount = years*this.getBalance()*this.getInterestRate();
        System.out.println("Your Saving Account interest amount is : "+interestAmount+" for "+years+" years");
    }
}
