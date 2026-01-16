package com.pip.processor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.pip.model.Employee;

public class HighSalaryFilterTest {
	
	@Test
	void testProcess() {
		List<Employee> employees = List.of(
				new Employee("Alice", "HR", 50000),
				new Employee("Bob", "IT", 60000),
				new Employee("Charlie", "HR", 55000),
				new Employee("David", "IT", 65000));
		HighSalaryFilter highSalaryFilter = new HighSalaryFilter(55000);
		List<Employee> result = highSalaryFilter.process(employees);
		assertEquals(2, result.size());
		assertTrue(result.stream().anyMatch(e -> e.name().equals("Bob")));
		assertTrue(result.stream().anyMatch(e -> e.name().equals("David")));
	}

}
