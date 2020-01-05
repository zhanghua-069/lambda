package com.xyzq.zh.lambda.chapter8.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 策略调用者：在构造类时提供压缩策略
 * 
 * @author zhanghua
 *
 */
public class Compressor {
	
	private final CompressionStrategy strategy;

	public Compressor(CompressionStrategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * 在代码运行期使用不同的策略达到各自的效果
	 * 
	 * @param inFile
	 * @param outFile
	 * @throws IOException
	 */
	public void compress(Path inFile, File outFile) throws IOException {
		try(OutputStream outStream = new FileOutputStream(outFile)) {
			Files.copy(inFile, strategy.compress(outStream));
		}
	}
	
}
