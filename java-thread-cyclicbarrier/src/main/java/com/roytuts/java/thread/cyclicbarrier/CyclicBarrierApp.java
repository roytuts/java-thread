package com.roytuts.java.thread.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CyclicBarrierApp {

    public static void main(String[] args) {
        int noOfThreads = 3;

        CyclicBarrier barrier = new CyclicBarrier(noOfThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(noOfThreads);

        PersonFileService fileService = new PersonFileService(barrier);
        PersonDBService personDBService = new PersonDBService(barrier);
        PersonRestService personRestService = new PersonRestService(barrier);

        List<Future<Job>> futures = new ArrayList<>();
        futures.add(executorService.submit(fileService));
        futures.add(executorService.submit(personDBService));
        futures.add(executorService.submit(personRestService));

        try {
            List<Person> aggregatedList = new ArrayList<>();

            for (Future<Job> future : futures) {
                List<Person> persons = future.get().getPersons();
                aggregatedList.addAll(persons);
            }

            System.out.println("Aggregated List size : " + aggregatedList.size());

            executorService.shutdown();
            // do something with aggregatedList
            // main tasks start here
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
