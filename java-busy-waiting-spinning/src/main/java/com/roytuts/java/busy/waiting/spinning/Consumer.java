package com.roytuts.java.busy.waiting.spinning;

import java.util.Iterator;

public class Consumer implements Runnable {

	private Producer producer;

	public Consumer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void run() {
		while (producer.isBusy()) {
			System.out.println("Producer busy... Consumer waiting...");
		}

		System.out.println("Consumer started consuming");

		Iterator<String> it = this.producer.getUuidList().iterator();

		while (it.hasNext()) {
			String uuid = it.next();

			System.out.println("Consumed UUID: " + uuid);

			it.remove();
		}
	}

}
