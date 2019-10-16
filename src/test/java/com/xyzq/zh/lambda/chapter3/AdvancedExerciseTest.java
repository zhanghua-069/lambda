package com.xyzq.zh.lambda.chapter3;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class AdvancedExerciseTest {
	
	/**
	 * 测试AdvancedExercise的map方法是否有效
	 */
	@Test
	public void testMap() {
		/*List<String> collected = Stream.of("a", "b", "hello")
				.map(string -> string.toUpperCase())
				.collect(Collectors.toList());
		assertEquals(Arrays.asList("A", "B", "HELLO"), collected);*/
		
		List<String> collected = AdvancedExercise.map(Stream.of("a", "b", "hello"), 
				string -> string.toUpperCase());
		assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
	}
	
	/**
	 * 测试AdvancedExercise的filter方法是否有效
	 */
	@Test
	public void testFilter() {
		/*List<String> collected = Stream.of("a", "1abc", "abc1")
				.filter(value -> Character.isDigit(value.charAt(0)))
				.collect(Collectors.toList());*/
		List<String> collected = AdvancedExercise.filter(Stream.of("a", "1abc", "abc1"), 
				value -> Character.isDigit(value.charAt(0)));
		assertEquals(Arrays.asList("1abc"), collected);
	}
	
}
