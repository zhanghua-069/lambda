package com.xyzq.zh.lambda.chapter8.solid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Lambda实现SOLID原则-依赖反转原则
 * 
 * @author zhanghua
 *
 */
public class DependencyInversionPrinciple {
	
	public static interface HeadingFinder {
		List<String> findHeadings(Reader input);
	}
	
	public static class NoDIP implements HeadingFinder {

		@Override
		public List<String> findHeadings(Reader input) {
			try (BufferedReader reader = new BufferedReader(input)) {
				return reader.lines()
							.filter(line -> line.endsWith(":"))
							.map(line -> line.substring(0, line.length() - 1))
							.collect(Collectors.toList());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	public static class ExtractedDIP implements HeadingFinder {

		@Override
		public List<String> findHeadings(Reader input) {
			return withLinesOf(input, 
								lines -> lines.filter(line -> line.endsWith(":"))
											.map(line -> line.substring(0, line.length() - 1))
											.collect(Collectors.toList()),
								RuntimeException::new);
		}
		
		private <T> T withLinesOf(Reader input, Function<Stream<String>, T> handler,
				Function<IOException, RuntimeException> error) {
			try (BufferedReader reader = new BufferedReader(input)) {
				return handler.apply(reader.lines());
			} catch (IOException e) {
				throw error.apply(e);
			}
		}
		
	}

}
