package com.pip.processor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pip.model.Employee;

public class DepartmentCount implements DataProcessor<List<Employee>, Map<String, Long>> {

    // Backwards-compatible helper
    public Map<String, Long> departmentCounts(List<Employee> employees){
        return process(employees);
    }

    @Override
    public Map<String, Long> process(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
    }

}