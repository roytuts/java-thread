package com.roytuts.java.fork.join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EmployeeHalfYearlyAppraisalApp {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Employee> employees1 = new ArrayList<>();
		employees1.add(new Employee("Rajiv", 3.0f));
		employees1.add(new Employee("Alinaksha", 2.0f));
		employees1.add(new Employee("Rajat", 2.5f));
		employees1.add(new Employee("Sushil", 3.0f));
		employees1.add(new Employee("Shelshi", 3.2f));

		List<Employee> employees2 = new ArrayList<>();
		employees2.add(new Employee("Pavni", 3.0f));
		employees2.add(new Employee("Suprabhat", 2.0f));
		employees2.add(new Employee("Anindya", 2.5f));
		employees2.add(new Employee("Saugata", 3.0f));
		employees2.add(new Employee("Rajesh", 3.2f));

		List<Employee> employees3 = new ArrayList<>();
		employees3.add(new Employee("Shirisha", 3.0f));
		employees3.add(new Employee("Satish", 2.0f));
		employees3.add(new Employee("Luke", 2.5f));
		employees3.add(new Employee("Seham", 3.0f));
		employees3.add(new Employee("Vandana", 3.2f));

		List<Employee> employees4 = new ArrayList<>();
		employees4.add(new Employee("Abhisekh", 3.0f));
		employees4.add(new Employee("Rania", 2.0f));
		employees4.add(new Employee("Prakhar", 2.5f));
		employees4.add(new Employee("Princy", 3.0f));
		employees4.add(new Employee("Bharti", 3.2f));

		List<Employee> employees5 = new ArrayList<>();
		employees5.add(new Employee("Ahmed", 3.0f));
		employees5.add(new Employee("Mohamed", 2.0f));
		employees5.add(new Employee("Aditi", 2.5f));
		employees5.add(new Employee("Zainab", 3.0f));
		employees5.add(new Employee("Rashmi", 3.2f));

		EmployeeHalfYearlyAppraisal halfYearlyAppraisal1 = new EmployeeHalfYearlyAppraisal(employees1);
		EmployeeHalfYearlyAppraisal halfYearlyAppraisal2 = new EmployeeHalfYearlyAppraisal(employees2);
		EmployeeHalfYearlyAppraisal halfYearlyAppraisal3 = new EmployeeHalfYearlyAppraisal(employees3);
		EmployeeHalfYearlyAppraisal halfYearlyAppraisal4 = new EmployeeHalfYearlyAppraisal(employees4);
		EmployeeHalfYearlyAppraisal halfYearlyAppraisal5 = new EmployeeHalfYearlyAppraisal(employees5);

		List<EmployeeHalfYearlyAppraisal> appraisals = new ArrayList<EmployeeHalfYearlyAppraisal>();

		appraisals.add(halfYearlyAppraisal1);
		appraisals.add(halfYearlyAppraisal2);
		appraisals.add(halfYearlyAppraisal3);
		appraisals.add(halfYearlyAppraisal4);
		appraisals.add(halfYearlyAppraisal5);

		ExecutorService service = Executors.newFixedThreadPool(5);

		List<Future<Float>> results = service.invokeAll(appraisals);

		float sum = 0;
		for (Future<Float> result : results) {
			sum += result.get();
		}

		System.out.println("Average half-yearly rating for all employees: " + (sum / results.size()));

		service.shutdown();
	}

}
