package com.xyzq.zh.lambda.chapter8.dsl;

import com.xyzq.zh.lambda.chapter8.dsl.expectations.Expect;

/**
 * DSL-规则对象
 * 描述规则的对象：在此类中处理各种各样的规则（单元测试方法）
 * 
 * @author zhanghua
 *
 */
public final class Description {
	
	/**
	 * 套件名称
	 */
	private final String suite;

	public Description(String suite) {
		this.suite = suite;
	}
	
	/**
	 * 描述规则的方法
	 * 
	 * @param description	规则（单测方法）名称
	 * @param specification	规则的Lambda表达式
	 */
	public void should(String description, Specification specification) {
		try {
			Expect expect = new Expect();
			specification.specifyBehaviour(expect);
			Runner.current.recordSuccess(suite, description);
		} catch(AssertionError cause) {
			Runner.current.recordFailure(suite, description, cause);
		} catch (Throwable cause) {
			Runner.current.recordError(suite, description, cause);
		}
	}
	
}
