package com.pip.processor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.pip.model.Employee;

public class SalaryByDepartmentProcessorTest {
	
	@Test
	void testProcess() {
		List<Employee> employees = List.of(
			new Employee("Alice", "HR", 50000),
			new Employee("Bob", "IT", 60000),
			new Employee("Charlie", "HR", 55000),
			new Employee("David", "IT", 65000)
		);
		
		AverageSalaryByDepartment processor = new AverageSalaryByDepartment();
		Map<String, Double> result = processor.process(employees);
		assertEquals(2,result.size());
		assertEquals(52500.0, result.get("HR"));
		assertEquals(62500.0, result.get("IT"));
	}

}
