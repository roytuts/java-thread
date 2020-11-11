package com.roytuts.java.thread.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;

public final class PersonRepo {

    private PersonRepo() {
    }

    public static List<Person> buildPersonData() {
        Person p1 = new Person();
        p1.setId("1000");
        p1.setName("Debabrata");
        p1.setEmail("debabrata@gmail.com");
        p1.setPhone("1234567890");

        // set other fields for p1
        Person p2 = new Person();
        p2.setId("1000");
        p2.setName("Debina");
        p2.setEmail("debina@gmail.com");
        p2.setPhone("1234567890");

        // set other fields for p2
        Person p3 = new Person();
        p3.setId("1000");
        p3.setName("Baishali");
        p3.setEmail("baishali@gmail.com");
        p3.setPhone("1234567890");

        // set other fields for p3
        Person p4 = new Person();
        p4.setId("1000");
        p4.setName("Liton");
        p4.setEmail("liton@gmail.com");
        p4.setPhone("1234567890");

        // set other fields for p4
        List<Person> persons = new ArrayList<>();

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        return persons;
    }

}
