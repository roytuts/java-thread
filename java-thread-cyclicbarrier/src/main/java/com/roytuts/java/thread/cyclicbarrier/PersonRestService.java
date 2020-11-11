package com.roytuts.java.thread.cyclicbarrier;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class PersonRestService implements Callable<Job> {
    private CyclicBarrier barrier;

    public PersonRestService(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public Job call() throws Exception {
        // Dummy set of persons
        // the actual data for person should come from REST webservice
        List<Person> persons = PersonRepo.buildPersonData();

        Job job = new Job();
        job.setPersons(persons);

        System.out.println(this.getClass().getName() + " is waiting on the barrier");

        // await
        barrier.await();

        System.out.println(this.getClass().getName() + " has crossed the barrier");
        return job;
    }

}
