package com.xyzq.zh.lambda.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用Map的computeIfAbsent方法高效的计算斐波那契数列。
 * 这里的“高效”是指避免将那些较小的序列重复计算多次
 * 
 * 斐波那契数列定义：
 * f(0)=0
 * f(1)=1
 * f(n)=f(n-1)+f(n-2)
 * 
 * @author zhanghua
 *
 */
public class Fibonacci {
	
	/**
	 * 定义一个Map类型的斐氏数列，key为斐氏的下标，value为对应的斐氏数
	 */
	private Map<Integer, Long> series;
	
	/**
	 * 初始化斐氏数列：f(0)=0,f(1)=1
	 */
	public Fibonacci() {
		series = new HashMap<Integer, Long>();
		series.put(0, 0L);
		series.put(1, 1L);
	}
	
	/**
	 * 根据传入的x计算其对应的斐氏数（下标从0开始）
	 * 计算公式：f(n)=f(n-1)+f(n-2)
	 * 
	 * @param x
	 * @return
	 */
	public long computeFibonacci(int x) {
		return series.computeIfAbsent(x, n -> computeFibonacci(n - 1) + computeFibonacci(n - 2));
	}
	
}
