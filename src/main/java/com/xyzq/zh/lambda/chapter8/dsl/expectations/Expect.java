package com.xyzq.zh.lambda.chapter8.dsl.expectations;

import java.util.Collection;

/**
 * DSL- 期望定义
 * 
 * @author zhanghua
 *
 */
public final class Expect {
	
	/**
	 * 一般对象期望值校验
	 * 
	 * @param value
	 * @return
	 */
	public BoundExpectation that(Object value) {
		return new BoundExpectation(value);
	}
	
	/**
	 * 集合类对象期望值校验
	 * 
	 * @param collection
	 * @return
	 */
	public CollectionExpectation that(Collection<?> collection) {
		return new CollectionExpectation(collection);
	}
	
}
