package com.roytuts.java.fork.join;

import java.util.List;
import java.util.concurrent.Callable;

public class EmployeeHalfYearlyAppraisal implements Callable<Float> {

	private List<Employee> employees;

	public EmployeeHalfYearlyAppraisal(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public Float call() throws Exception {
		float sum = 0;
		for (Employee employee : employees) {
			sum += employee.getHalfYear();
		}
		return (sum / employees.size());
	}

}
