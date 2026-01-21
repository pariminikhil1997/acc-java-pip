package com.pip.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class EmployeeSortingEdgeTest {

    @Test
    void testNullAndEmptyInputs() {
        EmployeeSorting sorter = new EmployeeSorting();
        assertEquals(0, sorter.process(null).size());
        assertEquals(0, sorter.process(List.of()).size());
    }

}
