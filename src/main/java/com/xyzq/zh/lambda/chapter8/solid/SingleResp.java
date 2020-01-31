package com.xyzq.zh.lambda.chapter8.solid;

import java.util.stream.IntStream;

/**
 * Lambda实现SOLID原则-单一功能原则
 * 
 * @author zhanghua
 *
 */
public class SingleResp {
	
	/**
	 * 计算质数个数，一个方法中塞进了多重职责
	 * 
	 * @param upTo
	 * @return
	 */
	public long countPrimes(int upTo) {
		long tally = 0;
		for(int i = 1; i < upTo; i++) {
			boolean isPrime = true;
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					isPrime = false;
				}
			}
			
			if(isPrime) {
				tally++;
			}
		}
		return tally;
	}
	
	/**
	 * 单一功能原则-功能1：质数个数计数
	 * 
	 * @param upTo
	 * @return
	 */
	public long lambdaCountPrimes(int upTo) {
		// 使用parallel()：线程模型也是代码职责之一
		return IntStream.range(1, upTo)
				.parallel().filter(this::isPrime).count();
	}
	
	/**
	 * 单一功能原则-功能2：判断一个数是否是质数
	 * 
	 * @param number
	 * @return
	 */
	private boolean isPrime(int number) {
		// anyMatch：只要有一个条件满足即返回true
		// allMatch：必须全部都满足才会返回true
		// noneMatch：全都不满足才会返回true
		return IntStream.range(2, number).allMatch(x -> (number % x) != 0);
	}
	
}
