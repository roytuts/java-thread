package com.roytuts.java.busy.waiting.spinning;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Producer implements Runnable {

	private volatile boolean isBusy;
	private List<String> uuidList;

	public Producer() {
		this.isBusy = true;
		this.uuidList = new ArrayList<>();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			String uuid = UUID.randomUUID().toString();

			System.out.println("Producing UUID: " + uuid);

			uuidList.add(uuid);
		}

		isBusy = false;
	}

	public boolean isBusy() {
		return isBusy;
	}

	public List<String> getUuidList() {
		return uuidList;
	}

}
