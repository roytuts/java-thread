package com.roytuts.java.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Item> queue;

    public Consumer(BlockingQueue<Item> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Item item = queue.take();
                
                System.out.println("Consumed Item Id : " + item.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
