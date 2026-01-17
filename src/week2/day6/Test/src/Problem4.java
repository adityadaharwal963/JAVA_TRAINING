public class Problem4 {

    public static void main(String[] args) {
        PaymentService upi = new UPIPayment();
        PaymentService card = new CardPayment();
        upi.processPayment(100);
        card.processPayment(1000);
    }
}

abstract class PaymentService{

    abstract  void processPayment(double amount);
}

class UPIPayment extends PaymentService{

    @Override
    void processPayment(double amount) {
        System.out.println("Amount processed by UPI :"+amount);
    }
}

class CardPayment extends PaymentService{

    @Override
    void processPayment(double amount) {
        System.out.println("Amount processed by Card :"+amount);
    }
}