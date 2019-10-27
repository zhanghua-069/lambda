package com.xyzq.zh.lambda.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 手动实现并行化蒙特卡洛模拟法的代码
 * 通过手动使用线程模拟掷骰子事件
 * 
 * @author zhanghua
 *
 */
public class ManualDiceRolls {
	
	private static final int N = 100000000;
	
	/**
	 * 分数
	 */
	private final double fraction;
	private final Map<Integer, Double> results;
	/**
	 * 线程池的线程数
	 */
	private final int numberOfThreads;
	private final ExecutorService executor;
	/**
	 * 每个线程模拟计算的次数
	 */
	private final int workPerThread;
	
	public ManualDiceRolls() {
		this.fraction = 1.0 / N;
		this.results = new ConcurrentHashMap<>();
		this.numberOfThreads = Runtime.getRuntime().availableProcessors();
		this.executor = Executors.newFixedThreadPool(numberOfThreads);
		this.workPerThread = N / numberOfThreads;
	}
	
	public void simulateDiceRoles() {
		List<Future<?>> futures = submitJobs();
		awaitCompletion(futures);
		results.entrySet().forEach(System.out::println);
	}
	
	/**
	 * 将任务提交给线程池并异步获取任务结果
	 * 
	 * @return
	 */
	private List<Future<?>> submitJobs() {
		List<Future<?>> futures = new ArrayList<>();
		for(int i = 0; i < numberOfThreads; i++) {
			futures.add(executor.submit(makeJob()));
		}
		return futures;
	}
	
	/**
	 * 等待多线程任务完成并关闭线程池
	 * 
	 * @param futures
	 */
	private void awaitCompletion(List<Future<?>> futures) {
		futures.forEach((future) -> {
			try {
				future.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		executor.shutdown();
	}
	
	/**
	 * 线程池内执行的方法
	 * 
	 * @return
	 */
	private Runnable makeJob() {
		return () -> {
			ThreadLocalRandom random = ThreadLocalRandom.current();
			for(int i = 0; i < workPerThread; i++) {
				int entry = twoDiceThrows(random);
				accumulateResult(entry);
			}
		};
	}
	
	/**
	 * 将结果存入results
	 * key-投掷的点数，value-出现的概率
	 * 
	 * @param entry
	 */
	private void accumulateResult(int entry) {
		results.compute(entry, (key, previous) -> 
					previous == null ? fraction 
							: fraction + previous);
	}
	
	/**
	 * 计算多线程环境下第一次投掷和第二次投掷骰子的点数和
	 * 
	 * @param random
	 * @return
	 */
	private int twoDiceThrows(ThreadLocalRandom random) {
		int firstThrow = random.nextInt(1, 7);
		int secondThrow = random.nextInt(1, 7);
		return firstThrow + secondThrow;
	}
	
	
}
