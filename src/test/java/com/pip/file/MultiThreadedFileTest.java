package com.pip.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MultiThreadedFileTest {

	@Test
	void testRead() {
		MultiThreadedFile processor = Mockito.mock(MultiThreadedFile.class);
		File file = new File("test.txt");
		when(processor.read(file)).thenReturn(List.of("A", "B"));
		
		List<String> list = processor.read(file);
		
		assertEquals(2, list.size());
		verify(processor,times(1)).read(file);
	}
	
}
