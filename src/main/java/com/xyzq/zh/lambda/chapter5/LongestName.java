package com.xyzq.zh.lambda.chapter5;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestName {
	
	private Comparator<String> byNameLength = Comparator.comparing(String::length);
	
	/**
	 * 使用reduce高阶函数找到最长的艺术家名称
	 * 
	 * @param names
	 * @return
	 */
	public String byReduce(Stream<String> names) {
		return names.reduce((acc, name) -> {
			return byNameLength.compare(acc, name) >= 0 ? acc : name;
		}).orElseThrow(RuntimeException::new);
	}
	
	/**
	 * 使用收集器找到最长的艺术家名称
	 * 
	 * @param names
	 * @return
	 */
	public String byCollector(Stream<String> names) {
		return names
				.collect(Collectors.maxBy(byNameLength))
				.orElseThrow(RuntimeException::new);
	}

}
