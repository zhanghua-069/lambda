package com.xyzq.zh.lambda.chapter5;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class WordCountTest {
	
	/**
	 * 计算一个单词流中，每个单词出现的次数
	 */
	@Test
	public void test() {
		Stream<String> names = Stream.of("John" , "Paul", "George", "John", "Paul", "John");
		Map<String, Long> result = computeWordCount(names);
		System.out.println(result);
	}
	
	public Map<String, Long> computeWordCount(Stream<String> words) {
		return words.collect(Collectors.groupingBy(name -> name, 
				Collectors.counting()));
	}
	
}
