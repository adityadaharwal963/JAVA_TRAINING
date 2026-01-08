import java.util.UUID;

public abstract class BankAccount {
    protected UUID accountId;
    protected double balance;
    protected double interestRate;
    abstract void calculateInterest(int years);
}