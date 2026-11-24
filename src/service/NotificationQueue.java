
package service;

import java.util.LinkedList;
import java.util.Queue;

public class NotificationQueue {

    private Queue<String> queue = new LinkedList<>();

    public synchronized void produce(String message)
            throws InterruptedException {

        while (queue.size() == 5) {
            wait();
        }

        queue.add(message);

        System.out.println("Notification added: " + message);

        notifyAll();
    }

    public synchronized String consume()
            throws InterruptedException {

        while (queue.isEmpty()) {
            wait();
        }

        String message = queue.remove();

        notifyAll();

        return message;
    }
}
