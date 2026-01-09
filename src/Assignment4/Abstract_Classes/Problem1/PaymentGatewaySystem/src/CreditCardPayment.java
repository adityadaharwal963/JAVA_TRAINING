public class CreditCardPayment extends Payment{
    private final String cardServiceName;

    CreditCardPayment(String serviceProvider){
        this.cardServiceName = serviceProvider;
    }
    @Override
    void processPayment(String senderId, String receiverId,double amount) {
        boolean success = requestCreditServe();
        System.out.println("From: " + senderId + " To: " + receiverId);
        if(success){
            Payment.transactions.add(amount);
            this.printReceipt(amount);
        }
    }

    boolean requestCreditServe(){
        System.out.println("Send Request to  Card Service by "+cardServiceName+"Server");
        return true;
    }
}
