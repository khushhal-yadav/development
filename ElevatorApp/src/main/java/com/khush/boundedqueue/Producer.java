package com.khush.boundedqueue;

/**
 * Created by khush on 14/03/2017.
 */
public class Producer implements Runnable {

    private ThreadSafeBoundedQueue<StringMessage> taskQueue;

    public Producer(ThreadSafeBoundedQueue<StringMessage> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        int counter = 0;
        StringMessage stringMessage = new StringMessage();
        while ( true) {
            try {
                stringMessage.setMessage("Message - " + counter++);
                taskQueue.put(stringMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
