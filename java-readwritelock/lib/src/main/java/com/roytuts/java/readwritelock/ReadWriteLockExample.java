package com.roytuts.java.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		Map<String, String> map = new HashMap<>();
		
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		executorService.submit(() -> {
			lock.writeLock().lock();
			try {
				map.put("site", "https://roytuts.com");
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.writeLock().unlock();
			}
		});
		
		Runnable readTask = () -> {
			lock.readLock().lock();
			try {
				System.out.println(map.get("site"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.readLock().unlock();
			}
		};
		
		executorService.submit(readTask);
		executorService.submit(readTask);
		
		executorService.shutdown();
	}

}
