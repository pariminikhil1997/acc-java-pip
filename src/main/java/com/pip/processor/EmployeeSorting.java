package com.pip.processor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.pip.model.Employee;

public class EmployeeSorting implements DataProcessor<List<Employee>, List<Employee>> {

    public List<Employee> sortBySalaryDesc(List<Employee> employees){
        return process(employees);
    }

    @Override
    public List<Employee> process(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return Collections.emptyList();
        }
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .toList();
    }

}