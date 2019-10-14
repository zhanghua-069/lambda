package com.xyzq.zh.lambda.introduction;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.swing.JButton;

import org.junit.Test;

public class Question2Test {
	
	/**
	 * 使用ThreadLocal.withInitial创建线程安全的DateFormatter对象，并输出日期
	 */
	@Test
	public void test2b() {
		Supplier<DateFormat> supplier = () -> DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK);
		ThreadLocal<DateFormat> threadSafeFormatter = ThreadLocal.withInitial(supplier);
		DateFormat formatter = threadSafeFormatter.get();
        assertEquals("01-Jan-1970", formatter.format(new Date(0)));
	}
	
	@Test
	public void test3b() {
		JButton button = new JButton();
		button.addActionListener(event -> System.out.println(event.getActionCommand()));
	}
	
	/**
	 * check(x -> x > 5)编译失败的原因：javac无法根据上下文推断出函数接口类型属于Predicate or IntPred?
	 * 需要显示的指定函数接口类型后，才能调用check方法进行重载
	 */
	@Test
	public void test3c() {
		
		/**
		 * check(Predicate<Integer> predicate) : no
		 */
//		check(x -> x > 5);
		
		/**
		 * check(IntPred predicate) : no
		 */
//		check(x -> x > 5);
		
		Predicate<Integer> atLeast5 = x -> x > 5;
		check(atLeast5);
		
		IntPred predicate = x -> x > 5;
		check(predicate);
	}
	
	interface IntPred {
		boolean test(Integer value);
	}
	
	private boolean check(Predicate<Integer> predicate) {
		System.out.println("what?");
		return true;
	}
	
	private boolean check(IntPred predicate) {
		return true;
	}
	
}
