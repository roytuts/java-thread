package com.roytuts.java.thread.blockingqueue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Item> queue;

    public Producer(BlockingQueue<Item> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String uuid = UUID.randomUUID().toString();
                
                System.out.println("Produced Item Id : " + uuid);
                
                Item item = new Item(uuid);
                queue.put(item);
                
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
