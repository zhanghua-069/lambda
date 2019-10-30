package com.xyzq.zh.lambda.chapter6;

import java.util.Arrays;

import org.junit.Test;

/**
 * 并行化数组操作测试案例
 * 
 * @author zhanghua
 *
 */
public class Exercise2Test {
	
	@Test
	public void testParallelInitialize() {
		Exercise2 test = new Exercise2();
		double[] array = test.parallelInitialize(10);
		System.out.println(Arrays.toString(array));
	}
	
	@Test
	public void testSimpleMovingAverage() {
		Exercise2 test = new Exercise2();
		double[] values = new double[]{0, 1, 2, 3, 4, 3.5};
		double[] averages = test.simpleMovingAverage(values, 3);
		System.out.println(Arrays.toString(averages));
	}
	
}
