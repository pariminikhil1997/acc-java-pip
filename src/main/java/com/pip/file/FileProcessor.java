package com.pip.file;

import java.io.File;
import java.util.List;

public interface FileProcessor {

	List<String> read(File file);
}
