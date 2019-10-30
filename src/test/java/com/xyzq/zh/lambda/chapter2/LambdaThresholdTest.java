package com.xyzq.zh.lambda.chapter2;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import org.junit.Test;

public class LambdaThresholdTest {
	
	@Test
	public void test1() {
		// 空括号()表示没有参数
		Runnable noArguments = () -> System.out.println("Hello World");
		// 只有一个参数，可以省略参数的括号
		ActionListener oneArgument = event -> System.out.println("button clicked");
		// Lambda表达式主体可以是一个表达式，也可以是一段代码块，使用大括号{}将代码块括起来
		// 代码块可以用返回或抛出异常来退出
		Runnable multiStatement = () -> {
			System.out.print("hello");
			System.out.println(" World");
		};
		
		// lambda表达式的参数类型可以由编译器推断得出（依赖于上下文环境），也可以显示的声明
		BinaryOperator<Long> add = (x, y) -> x + y;
		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
	}
	
	/**
	 * 类型推断：javac根据Lambda表达式上下文信息就能推断出参数的正确类型。
	 * 程序依然要经过类型检查来保证运行的安全性，但不用再显示声明类型
	 */
	@Test
	public void test2() {
		Predicate<Integer> atLeast5 = x -> x > 5;
	}
	
}
