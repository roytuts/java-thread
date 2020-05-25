package com.roytuts.java.inter.thread.communication.wait.notify.notifyall;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer<E> implements Runnable {

	private static final Logger LOGGER = Logger.getLogger(Consumer.class.getName());

	private final Queue<E> queue;

	public Consumer(Queue<E> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						LOGGER.log(Level.INFO,
								"[" + Thread.currentThread().getName() + "]: Queue is empty. Waiting...");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				E e = queue.poll();
				LOGGER.log(Level.INFO, "[" + Thread.currentThread().getName() + "]: Consuming..." + e);
				// queue.notify();
				queue.notifyAll();
			}
		}
	}

}
