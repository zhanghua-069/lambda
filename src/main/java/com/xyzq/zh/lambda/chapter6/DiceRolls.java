package com.xyzq.zh.lambda.chapter6;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiceRolls {
	
	private static final int N = 100000000;
	
	/**
	 * 使用蒙特卡洛模拟法并行化模拟掷骰子事件
	 * 
	 * @return
	 */
	public Map<Integer, Double> paralleDiceRolls() {
		double fraction = 1.0 / N;
		return IntStream
				.range(0, N)// 创建一个大小为N的流
				.parallel()// 使用流的并行化操作
				.mapToObj(twoDiceThrows())// 模拟掷骰子事件，返回两次点数之和
				.collect(Collectors.groupingBy(side -> side, // 得到需要合并的所有结果的流
						// 对各点数分别出现次数的（1/N）求和，最终返回结果为点数之和到它们的概率的映射
						Collectors.summingDouble(n -> fraction)));
	}
	
	/**
	 * 计算多线程环境下第一次投掷和第二次投掷骰子的点数和
	 * 
	 * @return
	 */
	private IntFunction<Integer> twoDiceThrows() {
		return i -> {
			ThreadLocalRandom random = ThreadLocalRandom.current();
			int firstThrow = random.nextInt(1, 7);
			int secondThrow = random.nextInt(1, 7);
			return firstThrow + secondThrow;
		};
	}
	
}
