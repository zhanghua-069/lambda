package com.xyzq.zh.lambda.chapter6;

import java.util.Map;

import org.junit.Test;

/**
 * 从下面两个单测结果中可以看出使用流的并行执行的效率明显优于手动使用线程池执行
 * 
 * @author zhanghua
 *
 */
public class DiceRollsTest {
	
	/**
	 * 测试手动使用线程池模拟掷骰子事件
	 */
	@Test
	public void testManualDiceRolls() {
		ManualDiceRolls roles = new ManualDiceRolls();
		roles.simulateDiceRoles();
	}
	
	/**
	 * 测试使用蒙特卡洛模拟法并行化模拟掷骰子事件
	 */
	@Test
	public void testParalleDiceRolls() {
		DiceRolls diceRolls = new DiceRolls();
		Map<Integer, Double> results = diceRolls.paralleDiceRolls();
		results.entrySet().forEach(System.out::println);
	}
	
}
