package com.roytuts.java.custom.threadpool;

public class CustomThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " is executing task.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		CustomThreadPool threadPool = new CustomThreadPool(2);

		threadPool.execute(r);
		threadPool.execute(r);
		threadPool.shutdown();

		// threadPool.execute(r);
	}

}
