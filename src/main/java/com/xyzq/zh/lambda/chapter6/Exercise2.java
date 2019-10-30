package com.xyzq.zh.lambda.chapter6;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 并行化数组操作
 * 
 * @author zhanghua
 *
 */
public class Exercise2 {
	
	/**
	 * 使用并行化数组操作初始化数组
	 * 
	 * @param size
	 * @return
	 */
	public double[] parallelInitialize(int size) {
		double[] values = new double[size];
		// 并行化数组操作方法改变了传入的数组，而没有创建一个新数组
		Arrays.parallelSetAll(values, i -> i);
		return values;
	}
	
	/**
	 * 使用并行化数组操作计算简单滑动平均数
	 * 
	 * @param values 目标数组
	 * @param n	滑动窗口大小
	 * @return
	 */
	public double[] simpleMovingAverage(double[] values, int n) {
		// 将原始数组备份
		double[] sums = Arrays.copyOf(values, values.length);
		// parallelPrefix：将数组元素替换为当前元素和前驱元素之“和”，此处的和是指任意一个BinaryOperator
		Arrays.parallelPrefix(sums, Double::sum);
		// 进行滑动平均数计算的数组遍历的起始地址（滑动窗口大小-1）
		int start = n - 1;
		return IntStream.range(start, sums.length)
				.mapToDouble(i -> {
					// 平均值：当前下标位置的和减去窗口起始值/n
					double prefix = i == start ? 0 : sums[i - n];
					return (sums[i] - prefix) / n;
				})
				// 将流转换为数组
				.toArray();
	}
	
}
