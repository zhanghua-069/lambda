package com.xyzq.zh.lambda.chapter8.dsl.example;

import static com.xyzq.zh.lambda.chapter8.dsl.Lets.describe;

import java.util.Stack;

/**
 * 描述栈行为模式的DSL示例
 * 引入“Lets.describe”进行套件（测试类）的描述
 * 
 * @author zhanghua
 *
 */
public class StackSpec {
	
	// 匿名构造函数，可执行任意的java代码块
	// 相当于public StackSpec(){...}
	{
		/**
		 * it代表正在描述的对象
		 * except代表对规则描述的期望
		 */
		describe("a stack", it -> {
			
			it.should("be empty when created", except -> {
				except.that(new Stack<>()).isEmpty();
			});
			
			it.should("push new elements onto the top of the stack", except -> {
				Stack<Integer> stack = new Stack<>();
				stack.push(1);
				
				except.that(stack.get(0)).isEqualTo(1);
			});
			
			it.should("pop the last element pushed onto the stack", except -> {
				Stack<Integer> stack = new Stack<>();
				stack.push(2);
				stack.push(1);
				
				// 此处会报错stack[expected:<2> but was:<1>]
				except.that(stack.pop()).isEqualTo(2);
			});
			
		});
	}
	
}
