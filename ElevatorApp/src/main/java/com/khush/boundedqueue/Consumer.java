package com.khush.boundedqueue;

/**
 * Created by khush on 14/03/2017.
 */
public class Consumer implements Runnable{

    private ThreadSafeBoundedQueue<StringMessage> taskQueue;

    public Consumer(ThreadSafeBoundedQueue<StringMessage> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                taskQueue.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
