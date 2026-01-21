package com.pip.processor;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;

public class OptionalSalaryEdgeTest {

    @Test
    void testNullAndEmptyInputs() {
        OptionalSalary opt = new OptionalSalary();
        assertFalse(opt.getSalaryByName(null, "Alice").isPresent());
        assertFalse(opt.getSalaryByName(List.of(), "Alice").isPresent());
        assertFalse(opt.getSalaryByName(List.of(new com.pip.model.Employee("Alice","HR",50000)), null).isPresent());
        assertFalse(opt.getSalaryByName(List.of(new com.pip.model.Employee("Alice","HR",50000)), "").isPresent());
    }

}