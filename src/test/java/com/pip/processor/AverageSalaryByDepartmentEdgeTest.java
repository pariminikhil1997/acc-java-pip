package com.pip.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class AverageSalaryByDepartmentEdgeTest {

    @Test
    void testNullAndEmptyInputs() {
        AverageSalaryByDepartment proc = new AverageSalaryByDepartment();
        assertEquals(0, proc.process(null).size());
        assertEquals(0, proc.process(List.of()).size());
    }

}
