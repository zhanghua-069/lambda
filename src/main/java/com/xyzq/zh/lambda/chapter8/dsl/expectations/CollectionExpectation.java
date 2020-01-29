package com.xyzq.zh.lambda.chapter8.dsl.expectations;

import java.util.Collection;
import static junit.framework.Assert.assertTrue;

/**
 * 集合期望对象
 * 
 * @author zhanghua
 *
 */
public class CollectionExpectation extends BoundExpectation {
	
	private final Collection<?> collection;

	public CollectionExpectation(Collection<?> collection) {
		super(collection);
		this.collection = collection;
	}
	
	public void isEmpty() {
		assertTrue(collection.isEmpty());
	}

}
