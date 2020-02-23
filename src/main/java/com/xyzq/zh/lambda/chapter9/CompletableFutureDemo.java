package com.xyzq.zh.lambda.chapter9;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture使用案例及说明
 * 参考链接：https://www.jianshu.com/p/6bac52527ca4
 * 
 * @author zhanghua
 *
 */
public class CompletableFutureDemo {

	private ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
	
	private Integer a;
	
	/**
	 * 使用一个工厂方法创建一个CompletableFuture对象
	 * 
	 * @return
	 */
	public CompletableFuture<Integer> createCF() {
		// 参数1：执行的目标方法
		// 参数2：CompletableFuture对象执行任务的线程池
		return CompletableFuture.supplyAsync(() -> {
			return new Random().nextInt(10);
		}, service);
	}
	
	/**
	 * 使用future执行一些代码而不返回任何值
	 * 如Consumer对应thenAccept， Runnable对应thenRun
	 * 如果future执行成功，则会执行thenRun的内容
	 */
	public void doRun() {
		CompletableFuture.supplyAsync(() -> {
			return "hello";
		}).thenRun(() -> {
			System.out.println("hello world!");
		});
	}
	
	/**
	 * thenAccept：使用future的执行结果进行赋值操作
	 *  
	 * @param num
	 * @throws Exception
	 */
	public void doAccept(int num) throws Exception {
		CompletableFuture.supplyAsync(() -> {
			return num;
		}).thenAccept(param -> a += param).thenRun(() -> {
			System.out.println("a=" + a);
		});
	}
	
	/**
	 * 获取future经程序处理后的值，类似于Stream中的map
	 * future、置信那个成功后获取future的执行结果进行thenApply操作，与thenAccept不同，thenApply有返回值
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer doApply() throws Exception {
		CompletableFuture<Integer> future = this.createCF();
		return future.thenApply(num -> {
			int result = num * 5;
			System.out.println("result=" + result);
			return result;
		}).get();
	}
	
	/**
	 * thenCombine用法实例，将future1与future2结果合并处理后返回
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String doCombine() throws Exception {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			return "hello";
		});
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			return "world";
		});
		// 将future1与future2的执行结果进行合并处理
		CompletableFuture<String> result = future1.thenCombine(future2, (s1, s2) -> {
			return s1 + " " + s2 + "!";
		});
		return result.get(10, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * thenCompose：对两个 CompletableFuture进行流水线操作，第一个操作完成时，将其结果作为参数传递给第二个操作
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String doCompose(String name) throws Exception {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			return "hello";
		});
		return future.thenCompose(str -> {
			return CompletableFuture.supplyAsync(() -> {
				return str + " " + name;
			});
		}).get();
	}
	
	/**
	 * handle: 与thenApply 方法类似，不同的是thenApply只可以执行正常的任务，handle还可以处理异常的任务
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer doHandle() throws Exception {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			return new Random().nextInt(100);
		});
		
		return future.handle((param, throwable) -> {
			int result = -1;
			if(throwable == null) {
				// 程序处理正常逻辑
				result = param * 2;
			} else {
				// 异常情况处理
				System.out.println(throwable.getMessage());
			}
			
			return result;
		}).get();
	}
	
	/**
	 * exceptionally: future运行中出现异常时，返回一个替代值
	 * whenCompleteAsync：future运行完成时进行的操作，Async表示可能使用其他线程去执行
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doExceptionally() throws Exception {
		return CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
				System.out.println("返回张");
				return "zhang";
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}).exceptionally(throwable -> {
			System.out.println("exceptionally - apply: " + throwable.toString());
			return "发生异常！";
		}).whenCompleteAsync((str, throwable) -> {
			System.out.println("accpet:" + str);
		}).get();
	}
	
	/**
	 * isDone：程序以任意形式运行完成
	 * 
	 * @return
	 */
	public boolean doIsDone() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("线程运行中...");
			} catch (Exception e) {
				throw new RuntimeException("运行异常！");
			}
		});
		return future.isDone();
	}

}
