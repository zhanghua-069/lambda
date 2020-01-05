package com.xyzq.zh.lambda.chapter8.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Lambda优化设计模式-命令模式
 * 
 * 定义一个包含操作序列的宏，可按顺序执行操作
 * 
 * @author zhanghua
 *
 */
public class Macro {
	
	private final List<Runnable> actions;
	
	public Macro() {
		actions = new ArrayList<>();
	}
	
	/**
	 * 添加操作到操作序列中
	 * 
	 * @param action
	 */
	public void record(Runnable action) {
		actions.add(action);
	}
	
	/**
	 * 顺序执行每一个action
	 */
	public void exec() {
		actions.forEach(Runnable::run);
	}
	
	/**
	 * 调用demo-Lambda宏的使用
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Macro macro = new Macro();
		macro.record(() -> new Runnable() {
			
			@Override
			public void run() {
				System.out.println("action.open()");
			}
		});
		
		macro.record(() -> {
			System.out.println("action.save()");
		});
		
		macro.record(() -> {
			System.out.println("action.close()");
		});
		macro.exec();
	}
	
}
