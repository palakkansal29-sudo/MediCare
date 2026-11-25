package service;

public class NotificationService implements Runnable {

    private NotificationQueue queue;

    public NotificationService(NotificationQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            while (true) {

                String message = queue.consume();

                if (message.equals("STOP")) {
                    break;
                }

                System.out.println(
                        "Notification sent: " + message);

            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Notification interrupted.");
        }
    }
}