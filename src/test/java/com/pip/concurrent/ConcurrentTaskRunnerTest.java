package com.pip.concurrent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

import com.pip.exception.DataProcessingException;

public class ConcurrentTaskRunnerTest {

    @Test
    void testConcurrentIncrementsAndCollection() {
        int tasks = 1000;
        AtomicInteger counter = new AtomicInteger();
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        List<Callable<Void>> callables = new ArrayList<>();
        for (int i = 0; i < tasks; i++) {
            final int value = i;
            callables.add(() -> {
                // increment atomic and add to thread-safe queue
                counter.incrementAndGet();
                queue.add(value);
                return null;
            });
        }

        List<Void> results = ConcurrentTaskRunner.invokeAll(callables, 8);
        // all tasks return null but should be completed
        assertEquals(tasks, results.size());
        assertEquals(tasks, counter.get());
        assertEquals(tasks, queue.size());
    }

    @Test
    void testInvokeAllPropagatesFailure() {
        List<Callable<Void>> tasks = List.of(
                () -> null,
                () -> { throw new RuntimeException("boom"); }
        );
        assertThrows(DataProcessingException.class, () -> ConcurrentTaskRunner.invokeAll(tasks, 2));
    }
}
