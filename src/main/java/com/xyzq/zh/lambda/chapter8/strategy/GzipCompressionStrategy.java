package com.xyzq.zh.lambda.chapter8.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 策略模式：使用gzip算法压缩数据
 * 
 * @author zhanghua
 *
 */
public class GzipCompressionStrategy implements CompressionStrategy {

	@Override
	public OutputStream compress(OutputStream data) throws IOException {
		return new GZIPOutputStream(data);
	}

}
