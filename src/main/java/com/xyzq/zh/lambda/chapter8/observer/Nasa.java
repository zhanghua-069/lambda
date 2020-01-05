package com.xyzq.zh.lambda.chapter8.observer;

/**
 * NASA也能观察到有人登陆月球
 * 
 * @author zhanghua
 *
 */
public class Nasa implements LandingObserver {

	@Override
	public void observeLanding(String name) {
		if(name.contains("Apollo")) {
			System.out.println("We made it!");
		}
	}

}
