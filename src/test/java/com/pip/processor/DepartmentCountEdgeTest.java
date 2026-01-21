package com.pip.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.pip.model.Employee;

public class DepartmentCountEdgeTest {

    @Test
    void testNullAndEmptyInputs() {
        DepartmentCount deptCount = new DepartmentCount();
        assertEquals(0, deptCount.process(null).size());
        assertEquals(0, deptCount.process(List.of()).size());
    }

}
