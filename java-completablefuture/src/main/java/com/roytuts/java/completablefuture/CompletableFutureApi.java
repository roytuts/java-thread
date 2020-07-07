package com.roytuts.java.completablefuture;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureApi {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFutureApi example = new CompletableFutureApi();

		// chain example
		example.exampleOp();

		// explicitly complete
		example.completeOp();

		// return known value
		example.knownValueOp();

		// separate task using the async suffix
		example.separateTasksOp();

		// exceptionally
		// example.exceptionallyOp();
		// thenCombine
		example.combineOp();

		// acceptEither
		example.acceptEitherOp();
	}

	public void exampleOp() throws InterruptedException, ExecutionException {
		// block and wait for the result
		// CompletableFuture allows you to build pipeline executed
		// asynchronously within the ForkJoinPool
		CompletableFuture<?> cf = CompletableFuture.supplyAsync(this::createId).thenApply(this::convert)
				.thenAccept(this::store);
		System.out.println("null : " + cf.get());
	}

	public void completeOp() throws InterruptedException, ExecutionException {
		CompletableFuture<Double> cf = CompletableFuture.supplyAsync(this::createRandomNumber);
		// if you want to control concurrency using ExecutorService, i.e., if
		// you do not want to submit the task to default
		// ForkJoinPool.commonPool(), then pass es as second argument to the
		// supplyAsync method
		/*
		 * ExecutorService es = Executors.newFixedThreadPool(2);
		 * CompletableFuture<Double> cf =
		 * CompletableFuture.supplyAsync(this::createRandomNumber, es);
		 */
		// explicitly complete and return default value if you do not want to
		// wait for the task to complete
		cf.complete(434345.8765);
		System.out.println("Random Number : " + cf.get());
	}

	public void knownValueOp() throws InterruptedException, ExecutionException {
		// create a completed CompletableFuture in advance that returns a known
		// value
		// this might come in handy in testing environment, in case you will
		// want to combine that known value with one that needs to be computed
		CompletableFuture<String> cf = CompletableFuture.completedFuture("I'm done");
		cf.isDone(); // return true
		cf.join(); // return "I'm done"
		System.out.println("Known value : " + cf.get());
	}

	public void separateTasksOp() throws InterruptedException, ExecutionException {
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(this::findURL);
		// execute the below task on separate thread on completion of previous
		// task cf
		CompletableFuture<String> resp1 = cf.thenApplyAsync(this::sendURL);
		// execute the below task on separate thread on completion of previous
		// task cf
		CompletableFuture<String> resp2 = cf.thenApplyAsync(this::sendURL);
		cf.thenAccept(System.out::println);
		// cf.thenAcceptAsync(System.out::println);
		resp1.thenAccept(System.out::println);
		// resp1.thenAcceptAsync(System.out::println);
		resp2.thenAccept(System.out::println);
		// resp2.thenAcceptAsync(System.out::println);
	}

	public void exceptionallyOp() throws InterruptedException, ExecutionException {
		CompletableFuture<?> cf = CompletableFuture.supplyAsync(this::failureMsg).exceptionally(ex -> notify(ex))
				.thenAccept(this::notify);
		cf.get();
	}

	public void combineOp() throws InterruptedException, ExecutionException {
		// what we want to do with the result of these two computations
		CompletableFuture<Double> cfNum = CompletableFuture.supplyAsync(this::createRandomNumber);
		CompletableFuture<String> cfUrl = CompletableFuture.supplyAsync(this::findURL);
		CompletableFuture<String> resp = cfNum.thenCombine(cfUrl, this::notify);
		System.out.println("Combine : " + resp.get());
	}

	public void acceptEitherOp() throws InterruptedException, ExecutionException {
		// what we want to do with the result of any of the two computations
		CompletableFuture<String> cfName = CompletableFuture.supplyAsync(this::findName);
		CompletableFuture<String> cfUrl = CompletableFuture.supplyAsync(this::findURL);
		cfName.acceptEither(cfUrl, this::sendMsg);
	}

	private Double createRandomNumber() {
		return Math.random();
	}

	private UUID createId() {
		return UUID.randomUUID();
	}

	private String convert(UUID input) {
		return input.toString();
	}

	private String findURL() {
		return "roytuts.com";
	}

	private String findName() {
		return "Roy Tutorials";
	}

	private String sendURL(String url) {
		return "Sending " + url + " to destination";
	}

	private String failureMsg() {
		throw new RuntimeException("Failured due to Exception");
	}

	private String notify(Throwable t) {
		throw new RuntimeException(t.getMessage());
	}

	private void notify(String msg) {
		System.out.println("The message : " + msg);
	}

	private void sendMsg(String msg) {
		System.out.println("The message : " + msg);
	}

	private String notify(Double num, String msg) {
		return msg + "," + num;
	}

	private void store(String message) {
		System.out.println("message : " + message);
	}

}
