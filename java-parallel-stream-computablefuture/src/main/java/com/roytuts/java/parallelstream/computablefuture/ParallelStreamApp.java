package com.roytuts.java.parallelstream.computablefuture;

import java.util.List;

public class ParallelStreamApp {

	public static void main(String[] args) {
		List<String> emailList = EmailUtils.getEmailList(100);

		EmailNotifier emailNotifier = new EmailNotifier();

		long start = System.nanoTime();

		emailList.parallelStream().forEach(email -> emailNotifier.sendEmailNotification(email));

		long duration = (System.nanoTime() - start) / 1_000_000;

		System.out.printf("ParallelStreamApp: Sent %d emails in %d millis\n", emailList.size(), duration);
	}

}
