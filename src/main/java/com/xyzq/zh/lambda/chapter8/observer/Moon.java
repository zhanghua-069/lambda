package com.xyzq.zh.lambda.chapter8.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者类
 * 
 * @author zhanghua
 *
 */
public class Moon {

	private final List<LandingObserver> observers = new ArrayList<>();
	
	/**
	 * 通知观察者
	 * 
	 * @param name
	 */
	public void land(String name) {
		for(LandingObserver observer : observers) {
			observer.observeLanding(name);
		}
	}
	
	/**
	 * 添加观察者
	 * 
	 * @param observer
	 */
	public void startSpying(LandingObserver observer) {
		observers.add(observer);
	}
	
}
