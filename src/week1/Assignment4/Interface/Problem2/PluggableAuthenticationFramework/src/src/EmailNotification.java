package src;

public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Initializing Email Server");
        System.out.println("Sending Mail");
        System.out.println("To: "+ recipient);
        System.out.println("Message: "+message);
        System.out.println("Mail Send");
    }
}
