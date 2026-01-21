package com.pip.processor;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;

public class HighestSalaryEdgeTest {

    @Test
    void testNullAndEmptyInputs() {
        HighestSalary hs = new HighestSalary();
        assertFalse(hs.process(null).isPresent());
        assertFalse(hs.process(List.of()).isPresent());
    }

}
