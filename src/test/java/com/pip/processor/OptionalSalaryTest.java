package com.pip.processor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.pip.model.Employee;

public class OptionalSalaryTest {
	
	@Test
	void testGetSalaryByName() {
		List<Employee> employees = List.of(
			new Employee("Alice", "HR", 50000),
			new Employee("Bob", "IT", 60000),
			new Employee("Charlie", "HR", 55000),
			new Employee("David", "IT", 65000)
		);
		OptionalSalary optionalSalary = new OptionalSalary();
		Optional<Double> salary = optionalSalary.getSalaryByName(employees, "Bob");
		assertTrue(salary.isPresent());
		assertEquals(60000.0, salary.get());
	}

}
