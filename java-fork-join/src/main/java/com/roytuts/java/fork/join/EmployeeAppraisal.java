package com.roytuts.java.fork.join;

import java.util.concurrent.Callable;

public class EmployeeAppraisal implements Callable<String> {

	private String name;
	private float halfYear1;
	private float halfYear2;

	public EmployeeAppraisal(String name, float halfYear1, float halfYear2) {
		this.name = name;
		this.halfYear1 = halfYear1;
		this.halfYear2 = halfYear2;
	}

	@Override
	public String call() throws Exception {
		return "Yearly appraisal's final rating for " + name + ": " + ((halfYear1 + halfYear2) / 2);
	}

}
