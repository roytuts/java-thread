package com.roytuts.completablefuture.fetchdata.asynchronously.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.completablefuture.fetchdata.asynchronously.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
