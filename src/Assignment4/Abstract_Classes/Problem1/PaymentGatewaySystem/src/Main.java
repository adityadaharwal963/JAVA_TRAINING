import java.util.Scanner;

public class Main {

    public static void test(){
        Scanner sc = new Scanner(System.in);
        Payment payment = null;
        while (true) {
            System.out.println("\nChoose Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice;

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 0) {
                System.out.println("Exiting payment system...");
                break;
            }



            switch (choice) {
                case 1:
                    payment = new CreditCardPayment("Visa");
                    break;

                case 2:
                    payment = new UPIPayment("Google Pay");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            System.out.print("Enter Sender ID: ");
            String senderId = sc.nextLine();

            System.out.print("Enter Receiver ID: ");
            String receiverId = sc.nextLine();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine(); // consume newline

            payment.processPayment(senderId, receiverId, amount);
        }

        assert payment != null;
        payment.printSummary();
        sc.close();
    }

    public static void main(String[] args) {
        test();
    }
}
