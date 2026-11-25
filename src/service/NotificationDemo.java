package service;

public class NotificationDemo {

    public static void runDemo() {

        NotificationQueue queue = new NotificationQueue();

        Thread consumer = new Thread(
                new NotificationService(queue));

        consumer.start();

        try {
            queue.produce("Appointment Booked");
            queue.produce("Payment Received");
            queue.produce("Doctor Assigned");
            queue.produce("STOP");

            consumer.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Notification demo interrupted.");
        }
    }
}