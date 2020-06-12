package com.roytuts.java.fork.join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EmployeeAppraisalApp {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<EmployeeAppraisal> appraisals = new ArrayList<EmployeeAppraisal>();

		appraisals.add(new EmployeeAppraisal("Rajiv", 3.0f, 3.5f));
		appraisals.add(new EmployeeAppraisal("Alinaksha", 2.0f, 2.5f));
		appraisals.add(new EmployeeAppraisal("Rajat", 2.5f, 3.0f));
		appraisals.add(new EmployeeAppraisal("Sushil", 3.0f, 3.1f));
		appraisals.add(new EmployeeAppraisal("Shelshi", 3.2f, 3.5f));
		appraisals.add(new EmployeeAppraisal("Pavni", 2.2f, 2.5f));
		appraisals.add(new EmployeeAppraisal("Suprabhat", 1.5f, 2.5f));
		appraisals.add(new EmployeeAppraisal("Anindya", 1.0f, 1.5f));
		appraisals.add(new EmployeeAppraisal("Saugata", 2.2f, 2.5f));

		ExecutorService service = Executors.newFixedThreadPool(3);

		List<Future<String>> results = service.invokeAll(appraisals);

		for (Future<String> result : results) {
			System.out.println(result.get());
		}

		service.shutdown();
	}

}
