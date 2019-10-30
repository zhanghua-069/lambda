package com.xyzq.zh.lambda.chapter6;

import java.util.stream.IntStream;

import org.junit.Test;

public class SerialToParallelTest {
	
	@Test
	public void testParallelSumOfSquares() {
		IntStream range = IntStream.of(1, 2, 3, 4);
		SerialToParallel test = new SerialToParallel();
		System.out.println(test.parallelSumOfSquares(range));	
	}
	
}
