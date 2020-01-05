package com.xyzq.zh.lambda.chapter8.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

/**
 * 策略模式：使用zip算法压缩数据
 * 
 * @author zhanghua
 *
 */
public class ZipCompressionStrategy implements CompressionStrategy {

	@Override
	public OutputStream compress(OutputStream data) throws IOException {
		return new ZipOutputStream(data);
	}

}
