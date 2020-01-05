package com.xyzq.zh.lambda.chapter8;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

import com.xyzq.zh.lambda.chapter8.strategy.CompressionStrategy;
import com.xyzq.zh.lambda.chapter8.strategy.Compressor;
import com.xyzq.zh.lambda.chapter8.strategy.GzipCompressionStrategy;
import com.xyzq.zh.lambda.chapter8.strategy.ZipCompressionStrategy;

public class StrategyTest {
	
	private Path inFile;
	private File outFile;
	
	/**
	 * 使用具体的策略类初始化Compressor
	 * 
	 * @throws IOException
	 */
	@Test
	public void test1() throws IOException {
		Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
		gzipCompressor.compress(inFile, outFile);
		
		Compressor zipCompressor = new Compressor(new ZipCompressionStrategy());
		zipCompressor.compress(inFile, outFile);
	}
	
	/**
	 * 利用Lambda表达式的特点，直接传入接口实现方法的lambda表达式
	 * 
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		Compressor gzipCompressor = new Compressor(GZIPOutputStream::new);
		gzipCompressor.compress(inFile, outFile);

		Compressor zipCompressor = new Compressor(ZipOutputStream::new);
		zipCompressor.compress(inFile, outFile);
	}
	
	/**
	 * lambda表达式的类型转换
	 */
	public void test3() {
		CompressionStrategy strategy1 = (OutputStream data) -> {
			return new GZIPOutputStream(data);
		};
		
		CompressionStrategy strategy2 = data -> {
			return new GZIPOutputStream(data);
		};
		// lambda表达式会根据代码上下文自动获取接口入参
		CompressionStrategy strategy3 = GZIPOutputStream::new;
	}
}
