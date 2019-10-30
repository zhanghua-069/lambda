package com.xyzq.zh.lambda.chapter6;

import java.util.stream.IntStream;

public class SerialToParallel {
	
	public int parallelSumOfSquares(IntStream range) {
		return range.parallel()
				.map(x -> x * x)
				.sum();
	}
	
}
