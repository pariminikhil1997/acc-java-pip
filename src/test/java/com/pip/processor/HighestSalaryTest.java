package com.pip.processor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.pip.model.Employee;

public class HighestSalaryTest {
	
	@Test
	void testprocess() {
		
		List<Employee> employees = List.of(
			new Employee("Alice", "HR", 50000),
			new Employee("Bob", "IT", 60000),
			new Employee("Charlie", "HR", 55000),
			new Employee("David", "IT", 65000)
		);
		
		HighestSalary highSalary = new HighestSalary();
		Optional<Employee> employee = highSalary.process(employees);
		assertTrue(employee.isPresent());
		assertEquals("David", employee.get().name());
	}

}
