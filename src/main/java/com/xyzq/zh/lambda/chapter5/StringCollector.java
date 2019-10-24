package com.xyzq.zh.lambda.chapter5;

import java.util.Collections;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 定制化收集器StringCollector收集字符串
 * 待收集元素类型：String
 * 累加器类型：StringJoiner
 * 最终结果的类型：String
 * 
 * 收集器的工作主要由四部分组成：supplier、accumulator、combiner、finisher
 * 改造的收集器：Exercise5.formatArtistNamesImprove的reduce部分
 * 
 * @author zhanghua
 *
 */
public class StringCollector implements Collector<String, StringJoiner, String> {
	
	/**
	 * 字符串分隔符
	 */
	private CharSequence delimiter;
	
	/**
	 * 结果字符串前缀
	 */
	private CharSequence prefix;
	
	/**
	 * 结果字符串后缀
	 */
	private CharSequence suffix;
	
	public StringCollector() {
		
	}
	
	public StringCollector(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
		this.delimiter = delimiter;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	/**
	 * supplier：创建容器工厂
	 */
	@Override
	public Supplier<StringJoiner> supplier() {
		return () -> new StringJoiner(delimiter, prefix, suffix);
	}
	
	/**
	 * accumulator（累加器）是一个函数，它将当前元素叠加到收集器
	 */
	@Override
	public BiConsumer<StringJoiner, String> accumulator() {
		return StringJoiner::add;
	}
	
	/**
	 * combiner合并两个容器
	 * 收集器中多个累加器并行执行
	 */
	@Override
	public BinaryOperator<StringJoiner> combiner() {
		return StringJoiner::merge;
	}
	
	/**
	 * finisher方法返回收集操作的最终结果
	 */
	@Override
	public Function<StringJoiner, String> finisher() {
		return StringJoiner::toString;
	}
	
	/**
	 * characteristics-特征方法：
	 * 若finisher方法不需要对容器做任何操作。更正式的说，此时finisher是identity函数，它返回传入参数的值，
	 * 此时需要使用characteristics方法声明
	 */
	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		// 返回一个空的Set，返回null会报NullPointerException
		return Collections.emptySet();
	}

}
