package com.xyzq.zh.lambda.chapter9;

import org.apache.log4j.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * RxJava2.0 简单应用案例-观察者模式
 * 创建RxJava的步骤
 * 1、创建被观察者（Observable）
 * 2、创建观察者（Observer）
 * 3、创建订阅关系（subscribe）
 * 
 * @author zhanghua
 *
 */
public class ObserverDemo {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	private Disposable disposable;
	
	/**
	 * 创建被观察者（连载小说）
	 * 
	 * @return
	 */
	public Observable<String> createNovel() {
		return Observable.create(emitter -> {
			emitter.onNext("连载1");
			emitter.onNext("连载2");
			emitter.onNext("连载3");
			emitter.onComplete();
			emitter.onError(new RuntimeException("运行异常！"));
		});
	}
	
	/**
	 * 创建观察者（读者）
	 * 
	 * @return
	 */
	public Observer<String> createObserver() {
		return new Observer<String>() {
			
			@Override
			public void onSubscribe(Disposable d) {
				disposable = d;
				log.info("onSubscribe");
			}
			
			@Override
			public void onNext(String value) {
				if("2".equals(value)) {
					// 取消订阅
					disposable.dispose();
					return;
				}
				log.info("onNext:" + value);
			}

			@Override
			public void onComplete() {
				log.info("onComplete()");
			}

			@Override
			public void onError(Throwable e) {
				log.info("onError:" + e.getMessage());
			}

		};
	}
	
}
