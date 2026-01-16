package com.pip.processor;

import java.util.Comparator;
import java.util.List;

import com.pip.model.Employee;

public class EmployeeSorting {
	
	public List<Employee> sortBySalaryDesc(List<Employee> employees){
		return employees.stream()
				        .sorted(Comparator.comparingDouble(Employee::salary).reversed())
				        .toList();
	}

}
