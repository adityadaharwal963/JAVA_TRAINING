import java.util.Scanner;

public class Main {

    public static void test(){
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Bank Account Menu");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Fixed Deposit Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter initial balance for Savings Account: ");
                    double sBalance = sc.nextDouble();

                    System.out.print("Enter number of years: ");
                    int sYears = sc.nextInt();

                    BankAccount savings = new SavingsAccount(sBalance);
                    savings.calculateInterest(sYears);
                    break;

                case 2:
                    System.out.print("Enter initial balance for Fixed Deposit Account: ");
                    double fBalance = sc.nextDouble();

                    System.out.print("Enter number of years: ");
                    int fYears = sc.nextInt();

                    BankAccount fd = new FixedDepositAccount(fBalance);
                    fd.calculateInterest(fYears);
                    break;

                case 3:
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 3);
        sc.close();
    }

    public static void main(String[] args) {
        test();
    }
}
