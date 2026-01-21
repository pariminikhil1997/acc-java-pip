package com.pip.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class HighSalaryFilterEdgeTest {

    @Test
    void testNullAndEmptyInputs() {
        HighSalaryFilter filter = new HighSalaryFilter(50000);
        assertEquals(0, filter.process(null).size());
        assertEquals(0, filter.process(List.of()).size());
    }

}
