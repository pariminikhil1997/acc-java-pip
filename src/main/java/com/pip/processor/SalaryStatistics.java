package com.pip.processor;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import com.pip.model.Employee;

public class SalaryStatistics {
	
	public DoubleSummaryStatistics stats(List<Employee> employees) {
		
		return employees.stream()
				        .filter(e -> e.salary() > 0)
				        .mapToDouble(Employee::salary)
				        .summaryStatistics();
	}

}
