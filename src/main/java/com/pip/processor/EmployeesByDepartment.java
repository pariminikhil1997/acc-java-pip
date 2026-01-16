package com.pip.processor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pip.model.Employee;

public class EmployeesByDepartment implements DataProcessor<List<Employee>, Map<String, List<Employee>>> {

	@Override
	public Map<String, List<Employee>> process(List<Employee> employees) {
		// TODO Auto-generated method stub
		return employees.stream().collect(Collectors.groupingBy(Employee::department));
	}

}
