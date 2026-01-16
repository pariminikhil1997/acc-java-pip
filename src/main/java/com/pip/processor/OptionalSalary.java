package com.pip.processor;

import java.util.List;
import java.util.Optional;

import com.pip.model.Employee;

public class OptionalSalary {
	
	public Optional<Double> getSalaryByName(List<Employee> employees, String name){
		return employees.stream()
				        .filter(e -> e.name().equalsIgnoreCase(name))
				        .map(Employee::salary)
				        .filter(salary -> salary > 0)
				        .findFirst();
	}

}
