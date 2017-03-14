package com.khush.boundedqueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by khush on 14/03/2017.
 */
public class ThreadSafeBoundedQueue<T extends Message> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private List<T> queue = new LinkedList<T>();
    private int limit = 10;

    public ThreadSafeBoundedQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void put(T item) throws InterruptedException {
        while (this.queue.size() ==  this.limit) {
            log.info("Queue is full. " + Thread.currentThread().getName() + " is waiting...");
            wait();
        }
        if (this.queue.size() == 0) {
            notify();
        }
        log.info("Queue is not full. " + Thread.currentThread().getName() + " is producing " + item.getMessage());
        this.queue.add(item);
    }

    public synchronized T remove() throws InterruptedException {
        while (this.queue.size() == 0) {
            log.info("Queue is empty. " + Thread.currentThread().getName() + " is waiting...");
            wait();
        }

        T item = this.queue.remove(0);
        log.info("Queue is not empty. " + Thread.currentThread().getName() + " is consuming " + item.getMessage());
        notify();
        return item;
    }
}
