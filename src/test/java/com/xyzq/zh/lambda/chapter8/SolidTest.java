package com.xyzq.zh.lambda.chapter8;

import org.junit.Test;

import com.xyzq.zh.lambda.chapter8.solid.SingleResp;

public class SolidTest {
	
	@Test
	public void testCountPrimes() {
		int upTo = 100;
		SingleResp singleResp = new SingleResp();
		long count1 = singleResp.countPrimes(upTo);
		System.out.println("count1=" + count1);
		
		long count2 = singleResp.lambdaCountPrimes(upTo);
		System.out.println("count2=" + count2);
	}
	
}
