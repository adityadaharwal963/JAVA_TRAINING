package src;

public class SMSNotification implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Connecting SMS API");
        System.out.println("Sending SMS");
        System.out.println("To: "+ recipient);
        System.out.println("Message: "+message);
        System.out.println("SMS Send");
    }
}
