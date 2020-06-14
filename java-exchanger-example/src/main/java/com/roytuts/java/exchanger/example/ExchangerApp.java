package com.roytuts.java.exchanger.example;

import java.util.concurrent.Exchanger;

public class ExchangerApp {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();

		Producer p = new Producer("I am Producer", exchanger);
		Consumer c = new Consumer("I am Consumer", exchanger);

		(new Thread(p)).start();
		(new Thread(c)).start();
	}

}
