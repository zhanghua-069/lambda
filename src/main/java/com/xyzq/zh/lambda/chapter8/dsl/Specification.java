package com.xyzq.zh.lambda.chapter8.dsl;

import com.xyzq.zh.lambda.chapter8.dsl.expectations.Expect;

/**
 * 定义规则的函数接口：外层方法调用lambda表达式
 * 
 * @author zhanghua
 *
 */
public interface Specification {
	
	/**
	 * 规则描述行为的期望：接收一个Expect对象作为参数
	 * 
	 * @param expect
	 */
	public void specifyBehaviour(Expect expect);
	
}
