package com.roytuts.java.thread.join.execution.order;

public class ThreadJoinExecutionOrder {

	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread [" + Thread.currentThread().getName() + "] executing");
		};

		Thread t1 = new Thread(r, "Thread 1");
		Thread t2 = new Thread(r, "Thread 2");
		Thread t3 = new Thread(r, "Thread 3");
		Thread t4 = new Thread(r, "Thread 4");

		t1.start();
		t1.join();

		t2.start();
		t2.join();

		t3.start();
		t3.join();

		t4.start();
		t4.join();
	}

}
