public class Problem4 {

    public static void main(String[] args) {
        PaymentService upi = new UPIPayment();
        PaymentService card = new CardPayment();
        upi.processPayment(100);
        card.processPayment(1000);
    }
}

interface PaymentService{

    abstract public void processPayment(double amount);
}

class UPIPayment implements PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("Amount processed by UPI :"+amount);
    }
}

class CardPayment implements PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("Amount processed by Card :"+amount);
    }
}