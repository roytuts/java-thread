package com.roytuts.completablefuture.fetchdata.asynchronously;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.completablefuture.fetchdata.asynchronously.service.PersonProductService;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private PersonProductService personProductService;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args).close();
	}

	@Override
	public void run(String... args) throws Exception {
		personProductService.printPersons();

		System.out.println("Product Details");
		System.out.println("=========================================");
		personProductService.getProducts().forEach(p -> System.out.println(p));
	}

}
