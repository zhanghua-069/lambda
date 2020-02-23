package com.xyzq.zh.lambda.chapter9;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * RxJava2.0 异步和链式编程
 * RxJava2.0是非常好用的一个异步链式库，遵循观察者模式
 * 
 * @author zhanghua
 *
 */
public class RxJavaFuture {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * RxJava 异步+链式编程
	 */
	public void postDelayed() {
		File[] files = new File[]{};
		// 创建被观察者
		Observable.create(emitter -> {
			for(int i = 0; i < files.length; i++) {
				File file = files[i];
				// 第6个文件延时3秒后上架
				if(i == 5) {
					TimeUnit.SECONDS.sleep(3);
				}
				if(i == 6) {
					// TODO 复制第7个文件到sd卡
					
				}
				if(i == 7) {
					// TODO 上传第8个文件到网络
					
				}
				emitter.onNext(file);
			}
		})
		// newThread:创建一个新的空闲线程，io:在子线程中执行，可以重用空闲线程
		// 事件回调线程
		.observeOn(Schedulers.newThread())
		// 事件执行线程
		.subscribeOn(Schedulers.io())
		// 观察者订阅被观察者：Observable.subscribe(Observer)
		.subscribe(file -> {
			// TODO 文件订阅之后观察者的处理
			File file1 = (File) file;
			log.info("fileName=" + file1.getName());
		});
	}
	
}
