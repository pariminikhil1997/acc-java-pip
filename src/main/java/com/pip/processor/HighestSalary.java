package com.pip.processor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.pip.model.Employee;

public class HighestSalary implements DataProcessor<List<Employee>, Optional<Employee>> {
	
	@Override
	public Optional<Employee> process(List<Employee> employees) {
		return employees.stream()
				        .filter(e -> e.salary() > 0)
				        .max(Comparator.comparingDouble(Employee::salary));
	}
}
