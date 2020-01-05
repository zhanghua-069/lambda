package com.xyzq.zh.lambda.chapter8.observer;

/**
 * 外星人观察到人类登陆月球
 * 
 * @author zhanghua
 *
 */
public class Aliens implements LandingObserver {

	@Override
	public void observeLanding(String name) {
		if(name.contains("Apollo")) {
			System.out.println("They're distracted, lets invade earth!");
		}
	}

}
