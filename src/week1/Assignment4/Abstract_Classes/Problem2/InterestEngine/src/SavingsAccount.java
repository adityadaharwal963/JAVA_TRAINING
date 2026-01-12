import java.util.UUID;

public class SavingsAccount extends BankAccount{

    SavingsAccount(double initialBalance){
        this.setInterestRate(0.03); // 3% interest rate on FD account
        this.setAccountId(UUID.randomUUID());
        this.setBalance(initialBalance);
    }
    @Override
    void calculateInterest(int years) {
        double interestAmount = years*this.getBalance()*this.getInterestRate();
        System.out.println("Your Saving Account interest amount is : "+interestAmount+" for "+years+" years");
    }
}
