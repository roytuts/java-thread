package com.roytuts.java.fork.join;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class EmployeeHalfYearlyAverageRatingTask extends RecursiveTask<Float> {

	private static final long serialVersionUID = 1L;

	private List<Employee> employees;

	public EmployeeHalfYearlyAverageRatingTask(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	protected Float compute() {
		if (employees == null || employees.size() < 1) {
			return 0f;
		} else if (employees.size() == 1) {
			return getRating(employees.get(0));
		}

		List<Employee> empList1 = employees.subList(0, employees.size() / 2);
		List<Employee> empList2 = employees.subList(employees.size() / 2, employees.size());

		EmployeeHalfYearlyAverageRatingTask cTaskOne = new EmployeeHalfYearlyAverageRatingTask(empList1);
		cTaskOne.fork();

		EmployeeHalfYearlyAverageRatingTask cTaskTwo = new EmployeeHalfYearlyAverageRatingTask(empList2);

		return cTaskTwo.compute() + cTaskOne.join();
	}

	private Float getRating(Employee employee) {
		return employee.getHalfYear();
	}

}
