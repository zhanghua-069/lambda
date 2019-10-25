package com.xyzq.zh.lambda.chapter5;

import java.util.stream.Stream;

import org.junit.Test;

public class LongestNameTest {
	
	@Test
	public void testByReduce() {
		LongestName test = new LongestName();
		String byReduce = test.byReduce(getNames());
		System.out.println(byReduce);
	}
	
	@Test
	public void testByCollector() {
		LongestName test = new LongestName();
		String byCollector = test.byCollector(getNames());
		System.out.println(byCollector);
	}
	
	private Stream<String> getNames() {
		return Stream.of("John Lennon", "Paul McCartney", "George Harrison", 
				"Ringo Starr", "Pete Best", "Stuart Sutcliffe");
	}
	
}
