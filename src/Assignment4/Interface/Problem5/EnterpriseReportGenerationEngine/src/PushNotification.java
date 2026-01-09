public class PushNotification implements NotificationService{
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Connecting Firebase Push Notification");
        System.out.println("Sending Push Notification");
        System.out.println("To: "+ recipient);
        System.out.println("Message: "+message);
        System.out.println("Push Notification Send");
    }
}
