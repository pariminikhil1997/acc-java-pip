package com.pip.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SalaryStatisticsEdgeTest {

    @Test
    void testNullAndEmptyInputs() {
        SalaryStatistics stats = new SalaryStatistics();
        var s1 = stats.process(null);
        var s2 = stats.process(List.of());
        assertEquals(0, s1.getCount());
        assertEquals(0, s2.getCount());
        assertEquals(0.0, s1.getSum());
        assertEquals(0.0, s2.getSum());
    }

}