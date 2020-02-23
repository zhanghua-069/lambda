package com.xyzq.zh.lambda;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.xyzq.zh.lambda.chapter9.ObserverDemo;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class RxJavaTest {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Test
	public void testObservable() {
		ObserverDemo demo = new ObserverDemo();
		Observable<String> novel = demo.createNovel();
		Observer<String> reader = demo.createObserver();
		
		log.info("开始执行订阅...");
		// 建立订阅关系
		novel.subscribe(reader);
	}
	
}
