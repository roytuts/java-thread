package com.roytuts.java.deadlock.solution;

public class Thread1 extends Thread {

	@Override
	public void run() {
		synchronized (Person.class) {
			System.out.println("Thread1: Holding lock on Person");

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Thread1: Waiting for lock on Address");

			synchronized (Address.class) {
				System.out.println("Thread1: Holding lock on Person and Address");
			}
		}
	}

}
