package com.xyzq.zh.lambda.chapter8.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Lambda优化设计模式-策略模式
 * 
 * 定义压缩数据的策略接口
 * 
 * @author zhanghua
 *
 */
public interface CompressionStrategy {
	
	public OutputStream compress(OutputStream data) throws IOException;
	
}
