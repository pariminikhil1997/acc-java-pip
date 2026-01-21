package com.pip.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.pip.exception.DataProcessingException;

/**
 * Small helper to execute tasks concurrently and collect results safely.
 * Tasks should avoid mutating non-thread-safe shared state; prefer thread-safe
 * collections (ConcurrentLinkedQueue, ConcurrentHashMap) or atomic primitives.
 */
public final class ConcurrentTaskRunner {

    private ConcurrentTaskRunner() {}

    /**
     * Executes a collection of callables with a fixed thread pool and returns the list of results.
     * If any task throws, a DataProcessingException is thrown containing the root cause.
     */
    public static <T> List<T> invokeAll(Collection<? extends Callable<T>> tasks, int threadCount) {
        Objects.requireNonNull(tasks, "tasks must not be null");
        if (tasks.isEmpty()) {
            return List.of();
        }
        if (threadCount <= 0) {
            threadCount = Math.min(tasks.size(), Runtime.getRuntime().availableProcessors());
        }

        ExecutorService ex = Executors.newFixedThreadPool(threadCount);
        try {
            List<Future<T>> futures = ex.invokeAll(tasks);
            List<T> results = new ArrayList<>(futures.size());
            ExecutionException firstEx = null;
            for (Future<T> f : futures) {
                try {
                    results.add(f.get());
                } catch (ExecutionException ee) {
                    // capture first execution exception and continue collecting
                    if (firstEx == null) {
                        firstEx = ee;
                    }
                }
            }
            if (firstEx != null) {
                throw new DataProcessingException("One or more tasks failed: " + firstEx.getCause(), firstEx.getCause());
            }
            return results;
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new DataProcessingException("Task execution interrupted", ie);
        } finally {
            ex.shutdown();
            try {
                if (!ex.awaitTermination(5, TimeUnit.SECONDS)) {
                    ex.shutdownNow();
                }
            } catch (InterruptedException ie) {
                ex.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
