package com.pip.processor;

public interface DataProcessor<T,R> {
	
	R process(T input);
	
}
