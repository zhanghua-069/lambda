package com.xyzq.zh.lambda;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LogTest {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Test
	public void testLogout() {
		log.info("log4j init...");
	}
	
}
