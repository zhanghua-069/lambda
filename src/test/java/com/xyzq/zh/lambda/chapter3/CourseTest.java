package com.xyzq.zh.lambda.chapter3;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.xyzq.zh.lambda.chapter1.Track;

/**
 * Lambda-Stream的使用
 * 
 * @author zhanghua
 *
 */
public class CourseTest {
	
	@Test
	public void testCollect() {
		List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
		assertEquals(Arrays.asList("a", "b", "c"), collected);
	}
	
	/**
	 * map方法中的Lambda表达式必须是Function接口的一个实例
	 */
	@Test
	public void testMap() {
		List<String> collected = Stream.of("a", "b", "hello")
				.map(string -> string.toUpperCase())
				.collect(Collectors.toList());
		assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
	}
	
	/**
	 * filter模式：该模式的核心思想是保留stream中的一些元素，而过滤掉其他的
	 * filter方法中的Lambda表达式是Predicate接口的一个实例
	 */
	@Test
	public void testFilter() {
		List<String> collected = Stream.of("a", "1abc", "abc1")
				.filter(value -> Character.isDigit(value.charAt(0)))
				.collect(Collectors.toList());
		assertEquals(Arrays.asList("1abc"), collected);
	}
	
	/**
	 * flatMap方法替换多个stream的值，再将多个stream连接成一个stream
	 * flatMap方法中的Lambda表达式是Function接口的一个实例
	 */
	@Test
	public void testFlatmap() {
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
				.flatMap(numbers -> numbers.stream())
				.collect(Collectors.toList());
		assertEquals(Arrays.asList(1, 2, 3, 4), together);
	}
	
	/**
	 * 获取stream中的最小值，返回一个Optional对象，通过get方法可取出Optional对象中的值
	 */
	@Test
	public void testMin() {
		List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
										new Track("Violets for Your Furs", 378),
										new Track("Time was", 451));
		
		Track shortestTrack = tracks.stream()
									.min(Comparator.comparing(track -> track.getLength()))
									.get();
		assertEquals(tracks.get(1), shortestTrack);
	}
	
	/**
	 * 使用reduce操作实现累加
	 * sum是累加器，保存当前的累加结果；Lambda表达式的返回值是最新的sum，是上一轮sum和当前element相加的结果
	 */
	@Test
	public void testReduceSum() {
		int result = Stream.of(1, 2, 3, 4)
				.reduce(0, (sum, element) -> sum + element);
		assertEquals(10, result);
	}
	
}
