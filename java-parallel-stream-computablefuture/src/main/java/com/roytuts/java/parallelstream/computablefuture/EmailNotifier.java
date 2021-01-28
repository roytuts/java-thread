package com.roytuts.java.parallelstream.computablefuture;

public class EmailNotifier {

	public void sendEmailNotification(final String email) {
		// send email to the customer
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1000); // for example only
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
