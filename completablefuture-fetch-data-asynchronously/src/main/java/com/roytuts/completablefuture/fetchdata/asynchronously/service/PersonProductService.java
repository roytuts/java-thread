package com.roytuts.completablefuture.fetchdata.asynchronously.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.completablefuture.fetchdata.asynchronously.entity.Product;
import com.roytuts.completablefuture.fetchdata.asynchronously.repository.PersonRepository;
import com.roytuts.completablefuture.fetchdata.asynchronously.repository.ProductRepository;

@Service
public class PersonProductService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private ProductRepository productRepository;

	public void printPersons() throws InterruptedException, ExecutionException {
		System.out.println("Person Details");
		System.out.println("=========================================");

		CompletableFuture.supplyAsync(() -> personRepository.findAll()).thenAccept(System.out::println);

		// CompletableFuture<List<Person>> completableFuture = CompletableFuture
		// .supplyAsync(() -> personRepository.findAll());
		// completableFuture.thenAccept(System.out::println);
		System.out.println();
	}

	public List<Product> getProducts() throws InterruptedException, ExecutionException {
		return CompletableFuture.supplyAsync(() -> productRepository.findAll()).get();
	}

}
