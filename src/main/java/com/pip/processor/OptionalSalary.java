package com.pip.processor;

import java.util.List;
import java.util.Optional;

import com.pip.model.Employee;

public class OptionalSalary implements DataProcessor<List<Employee>, Optional<Double>> {

    public Optional<Double> getSalaryByName(List<Employee> employees, String name){
        if (employees == null || name == null || name.isBlank()) {
            return Optional.empty();
        }
        return employees.stream()
                .filter(e -> e.name().equalsIgnoreCase(name))
                .map(Employee::salary)
                .filter(salary -> salary > 0)
                .findFirst();
    }

    @Override
    public Optional<Double> process(List<Employee> employees) {
        // Generic process doesn't have a name; return empty instead of throwing
        return Optional.empty();
    }

}