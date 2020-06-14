package com.roytuts.java.exchanger.example;

import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {

	private String msg;
	private Exchanger<String> exchanger;

	public Consumer(String msg, Exchanger<String> exchanger) {
		this.msg = msg;
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		while (true) {
			try {
				msg = exchanger.exchange(msg);
				System.out.println("Consumer got message: " + msg);
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
