package factory_pattern;

public class FactoryMethodPattern {

    public static void main(String[] args) {
        Notification smsNotification = NotificationFactory.createNotification("SMS");
        smsNotification.notifyUser();
        Notification emailNotification = NotificationFactory.createNotification("EMAIL");
        emailNotification.notifyUser();
    }

}

interface Notification {
    void notifyUser();
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification..");
    }
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending Email notification..");
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equals("EMAIL")) {
            return new EmailNotification();
        } else if (type.equals("SMS")) {
            return new SMSNotification();
        }
        return null;
    }
}
