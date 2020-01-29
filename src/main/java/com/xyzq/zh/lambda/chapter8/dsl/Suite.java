package com.xyzq.zh.lambda.chapter8.dsl;

/**
 * DSL-套件接口（套件由规则组成）
 * 定义套件的函数接口：外层方法调用lambda表达式
 * 
 * @author zhanghua
 *
 */
public interface Suite {
	
	/**
	 * 套件描述规则，接收一个Description作为参数
	 * 
	 * @param description
	 */
	public void specifySuite(Description description);
	
}
