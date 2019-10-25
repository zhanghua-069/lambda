package com.xyzq.zh.lambda.chapter5;

import org.junit.Test;

public class FibonacciTest {
	
	@Test
	public void test() {
		Fibonacci fibonacci = new Fibonacci();
		// 计算下标为10（即第11个）的斐氏数
		long num = fibonacci.computeFibonacci(10);
		System.out.println(num);
	}
	
}
