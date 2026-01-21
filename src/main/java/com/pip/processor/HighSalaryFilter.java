package com.pip.processor;

import java.util.List;

import com.pip.model.Employee;

public class HighSalaryFilter implements DataProcessor<List<Employee>, List<Employee>> {
	
	private final double highsalary;

	public HighSalaryFilter(double highsalary) {
		this.highsalary = highsalary;
	}

	@Override
	public List<Employee> process(List<Employee> employees) {
		return employees.stream()
					.filter(e -> e.salary() > highsalary)
					.toList();
	}

}