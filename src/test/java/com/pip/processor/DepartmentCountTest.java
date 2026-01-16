package com.pip.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.pip.model.Employee;

public class DepartmentCountTest {
	
	@Test
	void testDepartmentCounts() {
		List<Employee> employees = List.of(
			new Employee("Alice", "HR", 60000),
			new Employee("Bob", "IT", 75000),
			new Employee("Charlie", "HR", 62000),
			new Employee("David", "Finance", 80000),
			new Employee("Eve", "IT", 72000)
		);
		
		DepartmentCount deptCount = new DepartmentCount();
		var result = deptCount.departmentCounts(employees);
		assertEquals(3, result.size());
		assertEquals(2, result.get("HR"));
		assertEquals(2, result.get("IT"));
		assertEquals(1, result.get("Finance"));
	}

}
