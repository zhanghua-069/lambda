package com.xyzq.zh.lambda.chapter8.dsl.expectations;

import static org.junit.Assert.assertEquals;

/**
 * 边际期望对象
 * 
 * @author zhanghua
 *
 */
public class BoundExpectation {
	
	private final Object value;

	public BoundExpectation(Object value) {
		this.value = value;
	}
	
	public void isEqualTo(Object expected) {
		assertEquals(expected, value);
	}
	
}
