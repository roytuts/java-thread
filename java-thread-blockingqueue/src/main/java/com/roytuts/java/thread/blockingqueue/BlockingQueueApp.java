package com.roytuts.java.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueApp {

    public static void main(String[] args) {
        BlockingQueue<Item> queue = new LinkedBlockingQueue<Item>();

        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }

}
