package com.roytuts.java.parallelstream.computablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureApp {

	public static void main(String[] args) {
		List<String> emailList = EmailUtils.getEmailList(100);

		EmailNotifier emailNotifier = new EmailNotifier();

		long start = System.nanoTime();

		CompletableFuture[] futures = emailList.stream().map(email -> CompletableFuture.supplyAsync(() -> email))
				.map(future -> future.thenAcceptAsync(email -> emailNotifier.sendEmailNotification(email)))
				.toArray(CompletableFuture[]::new);

		CompletableFuture.allOf(futures).join();

		long duration = (System.nanoTime() - start) / 1_000_000;

		System.out.printf("CompletableFutureApp: Sent %d emails in %d millis\n", emailList.size(), duration);
	}
}
