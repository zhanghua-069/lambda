package com.xyzq.zh.lambda.chapter8.dsl;

/**
 * 描述套件：定义说明套件（测试类）的方法
 * 
 * @author zhanghua
 *
 */
public final class Lets {
	
	/**
	 * 描述套件（测试类）的内容
	 * 
	 * @param name		套件（测试类）名称
	 * @param behavior	描述套件的Lambda表达式
	 */
	public static void describe(String name, Suite behavior) {
		Description description = new Description(name);
		// 通过调用specifySuite执行Lambda表达式
		behavior.specifySuite(description);
	}
	
}
