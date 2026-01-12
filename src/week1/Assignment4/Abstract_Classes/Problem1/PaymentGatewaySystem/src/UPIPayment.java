public class UPIPayment extends Payment{
    private final String UPIServiceName;


    UPIPayment(String serviceProvider){
        this.UPIServiceName = serviceProvider;
    }

    @Override
    void processPayment(String senderId, String receiverId,double amount) {
        boolean success = requestUPIServe();
        System.out.println("From: " + senderId + " To: " + receiverId);
        if(success){
            Payment.transactions.add(amount);
            this.printReceipt(amount);
        }
    }

    boolean requestUPIServe(){
        System.out.println("Send Request to UPI Service by "+UPIServiceName+"Server");
        return true;
    }

}
