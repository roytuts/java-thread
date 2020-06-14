package com.roytuts.java.exchanger.example;

import java.util.concurrent.Exchanger;

public class Producer implements Runnable {

	private String msg;
	private Exchanger<String> exchanger;

	public Producer(String msg, Exchanger<String> exchanger) {
		this.msg = msg;
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		while (true) {
			try {
				msg = exchanger.exchange(msg);
				System.out.println("Producer got message: " + msg);
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
