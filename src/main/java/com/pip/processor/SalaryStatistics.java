package com.pip.processor;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import com.pip.model.Employee;

public class SalaryStatistics implements DataProcessor<List<Employee>, DoubleSummaryStatistics> {

    public DoubleSummaryStatistics stats(List<Employee> employees) {
        return process(employees);
    }

    @Override
    public DoubleSummaryStatistics process(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return new DoubleSummaryStatistics();
        }
        return employees.stream()
                .filter(e -> e.salary() > 0)
                .mapToDouble(Employee::salary)
                .summaryStatistics();
    }

}