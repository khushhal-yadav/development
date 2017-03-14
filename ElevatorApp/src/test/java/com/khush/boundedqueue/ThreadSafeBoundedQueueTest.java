package com.khush.boundedqueue;

import org.junit.Test;

import java.util.function.*;

import static org.junit.Assert.*;

/**
 * Created by khush on 14/03/2017.
 */
public class ThreadSafeBoundedQueueTest {

    private ThreadSafeBoundedQueue<StringMessage> threadSafeBoundedQueue =
            new ThreadSafeBoundedQueue<StringMessage>(20);

    @Test
    public void testBoundedQueue() throws InterruptedException {
        Producer producer1 = new Producer(threadSafeBoundedQueue);
        Producer producer2 = new Producer(threadSafeBoundedQueue);

        Consumer consumer1 = new Consumer(threadSafeBoundedQueue);
        Consumer consumer2 = new Consumer(threadSafeBoundedQueue);

        new Thread(producer1, "producer1").start();
        new Thread(producer2, "producer2").start();
        new Thread(consumer1, "consumer1").start();
        new Thread(consumer2, "consumer2").start();

        Thread.sleep(5000);

    }

}