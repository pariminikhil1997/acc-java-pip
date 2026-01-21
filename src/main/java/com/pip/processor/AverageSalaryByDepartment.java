package com.pip.processor;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pip.model.Employee;

public class AverageSalaryByDepartment implements DataProcessor<List<Employee>, Map<String, Double>> {
	@Override
	public Map<String, Double> process(List<Employee> employees) {
		if (employees == null || employees.isEmpty()) {
			return Collections.emptyMap();
		}
		return employees.stream().filter(e -> e.salary() > 0)
							.collect(Collectors.groupingBy(Employee::department,
									Collectors.averagingDouble(Employee::salary)));
	}

}