package com.roytuts.java.deadlock.solution;

public class Thread2 extends Thread {

	@Override
	public void run() {
		// synchronized (Address.class) {
		synchronized (Person.class) {
			System.out.println("Thread2: Holding lock on Address");

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Thread2: Waiting for lock on Person");

			// synchronized (Person.class) {
			synchronized (Address.class) {
				System.out.println("Thread2: Holding lock on Address and Person");
			}
		}
	}

}
