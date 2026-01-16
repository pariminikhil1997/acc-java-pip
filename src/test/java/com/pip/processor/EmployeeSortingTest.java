package com.pip.processor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.pip.model.Employee;

public class EmployeeSortingTest {
	
	@Test
	void testSortBySalaryDesc() {
		List<Employee> employees = List.of(
			new Employee("Alice", "HR", 50000),
			new Employee("Bob", "IT", 60000),
			new Employee("Charlie", "HR", 55000),
			new Employee("David", "IT", 65000)
		);
		
		EmployeeSorting empSorting = new EmployeeSorting();
		List<Employee> sortedEmployees = empSorting.sortBySalaryDesc(employees);
		assertEquals("David", sortedEmployees.get(0).name());
	}

}
