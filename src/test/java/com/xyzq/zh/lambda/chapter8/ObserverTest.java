package com.xyzq.zh.lambda.chapter8;

import org.junit.Test;

import com.xyzq.zh.lambda.chapter8.observer.Aliens;
import com.xyzq.zh.lambda.chapter8.observer.Moon;
import com.xyzq.zh.lambda.chapter8.observer.Nasa;

public class ObserverTest {
	
	/**
	 * 观察者模式的一般调用方式
	 */
	@Test
	public void test1() {
		Moon moon = new Moon();
		moon.startSpying(new Nasa());
		moon.startSpying(new Aliens());
		
		moon.land("An asteroid");
		moon.land("Apollo 11");
	}
	
	/**
	 * 使用lambda表达式改进观察者模式调用
	 */
	@Test
	public void test2() {
		Moon moon = new Moon();
		
		moon.startSpying(name -> {
			if(name.contains("Apollo")) {
				System.out.println("We made it!");
			}
		});
		
		moon.startSpying(name -> {
			if(name.contains("Apollo")) {
				System.out.println("They're distracted, lets invade earth!");
			}
		});
		
		moon.land("An asteroid");
		moon.land("Apollo 11");
	}
	
}
