package com.xyzq.zh.lambda.chapter6;

import java.util.List;

public class BuggyReduce {
	
	public int multiplyThrough(List<Integer> linkedListOfNumbers) {
		return 5 * linkedListOfNumbers.stream()
				.reduce(1, (acc, x) -> x * acc);
	}
	
}
