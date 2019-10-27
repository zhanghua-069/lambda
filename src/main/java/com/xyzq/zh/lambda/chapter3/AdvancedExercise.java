package com.xyzq.zh.lambda.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 进阶练习
 * java8的重要变化：允许接口中的方法包含方法体
 * 
 * @author zhanghua
 *
 */
public interface AdvancedExercise {
	
	/**
	 * 只用reduce和Lambda表达式实现Stream上的map操作
	 * 
	 * @param stream
	 * @param mapper
	 * @return
	 */
	public static <I, O>List<O> map(Stream<I> stream, Function<I, O> mapper) {
		return stream.reduce(new ArrayList<O>(), (acc, x) -> {
			// 复制List acc到newAcc
			List<O> newAcc = new ArrayList<>(acc);
			// 将迭代元素经过预定义Lambda表达式处理后加入到newAcc
			newAcc.add(mapper.apply(x));
			return newAcc;
		}, (List<O> left, List<O> right) -> combineLists(left, right));
	}
	
	/**
	 * 只用reduce和Lambda表达式实现Stream上的filter操作
	 * 
	 * @param stream
	 * @param predicate
	 * @return
	 */
	public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
		return stream.reduce(new ArrayList<I>(), (List<I> acc, I x) -> {
			// 满足Lambda表达式的预设条件
			if (predicate.test(x)) {
				// 复制acc到newAcc，以避免对acc造成修改
				List<I> newAcc = new ArrayList<>(acc);
				newAcc.add(x);
				return newAcc;
			} else {
				// 不满足Lambda表达式的预设条件
				return acc;
			}
		}, (List<I> left, List<I> right) -> combineLists(left, right));
	}

	static <I> List<I> combineLists(List<I> left, List<I> right) {
		// 复制left，避免对left造成更改
		List<I> newLeft = new ArrayList<>(left);
		newLeft.addAll(right);
		return newLeft;
	}
	
}
