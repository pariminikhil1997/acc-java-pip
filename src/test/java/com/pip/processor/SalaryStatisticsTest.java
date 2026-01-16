package com.pip.processor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.pip.model.Employee;

public class SalaryStatisticsTest {
	
	@Test
	void testStats() {
		
		List<Employee> employees = List.of(
			new Employee("Alice", "HR", 50000),
			new Employee("Bob", "IT", 60000),
			new Employee("Charlie", "HR", 55000),
			new Employee("David", "IT", 65000)
		);
		
		SalaryStatistics salaryStats = new SalaryStatistics();
		var stats = salaryStats.stats(employees);
		assertEquals(4, stats.getCount());
		assertEquals(57500.0, stats.getAverage());
		assertEquals(50000.0, stats.getMin());
		assertEquals(65000.0, stats.getMax());
		assertEquals(230000.0, stats.getSum());
		
	}

}
