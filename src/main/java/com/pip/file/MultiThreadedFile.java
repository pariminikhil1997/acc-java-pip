package com.pip.file;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import com.pip.exception.DataProcessingException;

public class MultiThreadedFile implements FileProcessor {

    @Override
    public List<String> read(File file) {
        if (file == null) {
            throw new DataProcessingException("File must not be null", null);
        }
        if (!file.exists()) {
            throw new DataProcessingException("File not found: " + file.getAbsolutePath(), null);
        }

        try (var lines = Files.lines(file.toPath())) {
            return lines.toList();
        } catch (Exception e) {
            throw new DataProcessingException("File processing failed: " + e.getMessage(), e);
        }
    }
}