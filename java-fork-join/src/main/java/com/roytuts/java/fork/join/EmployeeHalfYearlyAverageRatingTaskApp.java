package com.roytuts.java.fork.join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class EmployeeHalfYearlyAverageRatingTaskApp {

	public static void main(String[] args) {
		int threads = Runtime.getRuntime().availableProcessors();

		ForkJoinPool forkJoinPool = new ForkJoinPool(threads);

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Rajiv", 3.0f));
		employees.add(new Employee("Alinaksha", 2.0f));
		employees.add(new Employee("Rajat", 2.5f));
		employees.add(new Employee("Sushil", 3.0f));
		employees.add(new Employee("Shelshi", 3.2f));

		employees.add(new Employee("Pavni", 3.0f));
		employees.add(new Employee("Suprabhat", 2.0f));
		employees.add(new Employee("Anindya", 2.5f));
		employees.add(new Employee("Saugata", 3.0f));
		employees.add(new Employee("Rajesh", 3.2f));

		employees.add(new Employee("Shirisha", 3.0f));
		employees.add(new Employee("Satish", 2.0f));
		employees.add(new Employee("Luke", 2.5f));
		employees.add(new Employee("Seham", 3.0f));
		employees.add(new Employee("Vandana", 3.2f));

		employees.add(new Employee("Abhisekh", 3.0f));
		employees.add(new Employee("Rania", 2.0f));
		employees.add(new Employee("Prakhar", 2.5f));
		employees.add(new Employee("Princy", 3.0f));
		employees.add(new Employee("Bharti", 3.2f));

		employees.add(new Employee("Ahmed", 3.0f));
		employees.add(new Employee("Mohamed", 2.0f));
		employees.add(new Employee("Aditi", 2.5f));
		employees.add(new Employee("Zainab", 3.0f));
		employees.add(new Employee("Rashmi", 3.2f));

		EmployeeHalfYearlyAverageRatingTask etask = new EmployeeHalfYearlyAverageRatingTask(employees);

		float avgRating = forkJoinPool.invoke(etask) / employees.size();

		System.out.println("Average rating: " + avgRating);
	}

}
