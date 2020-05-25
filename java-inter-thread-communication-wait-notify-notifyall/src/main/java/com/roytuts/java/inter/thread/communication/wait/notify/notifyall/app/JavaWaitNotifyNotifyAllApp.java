package com.roytuts.java.inter.thread.communication.wait.notify.notifyall.app;

import java.util.LinkedList;
import java.util.Queue;

import com.roytuts.java.inter.thread.communication.wait.notify.notifyall.Consumer;
import com.roytuts.java.inter.thread.communication.wait.notify.notifyall.Producer;
import com.roytuts.java.inter.thread.communication.wait.notify.notifyall.enums.Currency;
import com.roytuts.java.inter.thread.communication.wait.notify.notifyall.model.Money;

public class JavaWaitNotifyNotifyAllApp {

	public static void main(String[] args) {
		Money money = new Money(6454.00, Currency.RUPEE);

		Queue<Money> queue = new LinkedList<Money>();

		Producer<Money> producer = new Producer<Money>(money, queue);

		Consumer<Money> consumer1 = new Consumer<Money>(queue);
		Consumer<Money> consumer2 = new Consumer<Money>(queue);

		new Thread(producer, "Producer").start();
		new Thread(consumer1, "Consumer1").start();
		new Thread(consumer2, "Consumer2").start();
	}

}
