package com.pip.file;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadedFile implements FileProcessor {
	
	ExecutorService executorService = Executors.newFixedThreadPool(2);

	@Override
	public List<String> read(File file) {

		try {
			Future<List<String>> future = executorService.submit(() -> Files.readAllLines(file.toPath()));
			return future.get();
		} catch (Exception e) {
			throw new RuntimeException("File processing failed", e);
		} finally {
			executorService.shutdown();
		}
	}
}
