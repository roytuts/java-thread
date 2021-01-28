package com.roytuts.java.parallelstream.computablefuture;

import java.util.List;

public class SequentialStreamApp {

	public static void main(String[] args) {
		List<String> emailList = EmailUtils.getEmailList(100);

		EmailNotifier emailNotifier = new EmailNotifier();

		long start = System.nanoTime();

		emailList.stream().forEach(email -> emailNotifier.sendEmailNotification(email));

		long duration = (System.nanoTime() - start) / 1_000_000;

		System.out.printf("SequentialStreamApp: Sent %d emails in %d millis\n", emailList.size(), duration);
	}

}
