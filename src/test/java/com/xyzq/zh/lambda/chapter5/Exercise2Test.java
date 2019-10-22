package com.xyzq.zh.lambda.chapter5;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 流中的元素都是按顺序处理的，这种顺序称为“出现顺序”
 * 
 * @author zhanghua
 *
 */
public class Exercise2Test {
	
	/**
	 * 有序集合创建一个流时，流中的元素就按出现顺序排列
	 */
	@Test
	public void test1() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
		assertEquals(numbers, sameOrder);
	}
	
	/**
	 * 集合本身无序，由此生成的流也是无序的
	 */
	@Test
	public void test2() {
		List<Integer> collect = new HashSet<>(Arrays.asList(4, 3, 2, 1))
				.stream().collect(Collectors.toList());
		assertNotSame(Arrays.asList(4, 3, 2, 1), collect);
	}
	
	/**
	 * 使用sorted方法可对流中无序元素进行排序
	 */
	@Test
	public void test3() {
		List<Integer> sameOrder = new HashSet<>(Arrays.asList(3, 4, 2, 1))
				.stream().sorted().collect(Collectors.toList());
		assertEquals(Arrays.asList(1, 2, 3, 4), sameOrder);
	}
	
	/**
	 * 一些中间操作会产生顺序，有序集合经过该操作后，这种顺序会保留
	 * 如果进来的流是无序的，出去的流也是无序的，只能断言结果中包含某些元素，而其顺序不能作出任何假设
	 */
	@Test
	public void test4() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> stillOrdered = numbers.stream()
				.map(x -> x + 1)
				.collect(Collectors.toList());
		assertEquals(Arrays.asList(2, 3, 4, 5), stillOrdered);
		
		Set<Integer> unordered = new HashSet<>(numbers);
		List<Integer> stillUnordered = unordered.stream()
				.map(x -> x + 1)
				.collect(Collectors.toList());
		
		// 顺序得不到保障
		assertThat(stillUnordered, hasItem(2));
		assertThat(stillUnordered, hasItem(3));
		assertThat(stillUnordered, hasItem(4));
		assertThat(stillUnordered, hasItem(5));
	}
	
}
