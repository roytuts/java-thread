package com.roytuts.java.inter.thread.communication.wait.notify.notifyall;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer<E> implements Runnable {

	private static final Logger LOGGER = Logger.getLogger(Producer.class.getName());

	private E e;
	private final Queue<E> queue;

	public Producer(E e, Queue<E> queue) {
		this.e = e;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (!queue.isEmpty()) {
					try {
						LOGGER.log(Level.INFO, "[" + Thread.currentThread().getName() + "]: Queue is full. Waiting...");
						queue.wait();
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
				LOGGER.log(Level.INFO, "[" + Thread.currentThread().getName() + "]: Producing..." + e);
				queue.add(e);
				// queue.notify();
				queue.notifyAll();
			}
		}
	}

}
