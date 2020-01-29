package com.xyzq.zh.lambda.chapter8;

import org.junit.Test;

import com.xyzq.zh.lambda.chapter8.dsl.Runner;
import com.xyzq.zh.lambda.chapter8.dsl.example.StackSpec;

/**
 * Lambda实现DSL测试类
 * 
 * @author zhanghua
 *
 */
public class LambdabehaveTest {
	
	@Test
	public void testDsl() {
		Runner.current.run(StackSpec.class);
		Runner.current.printReport();
	}
	
}
