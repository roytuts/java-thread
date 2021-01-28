package com.roytuts.java.parallelstream.computablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class EmailUtils {

	private EmailUtils() {
	}

	public static List<String> getEmailList(int length) {
		final List<String> emailList = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			emailList.add(EmailUtils.generateMailinatorEmail());
		}

		return emailList;
	}

	public static String generateMailinatorEmail() {
		return String.format("%s@%s", getUniqueId(), "domain.com");
	}

	public static String getUniqueId() {
		return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);
	}
}
