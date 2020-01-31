package com.xyzq.zh.lambda.chapter8;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.xyzq.zh.lambda.chapter8.solid.DependencyInversionPrinciple.ExtractedDIP;
import com.xyzq.zh.lambda.chapter8.solid.DependencyInversionPrinciple.HeadingFinder;
import com.xyzq.zh.lambda.chapter8.solid.DependencyInversionPrinciple.NoDIP;

/**
 * JUnit4 参数化测试（ Parameterized tests）
 * 使用@RunWith(Parameterized.class)的测试类需要添加提供数据方法，并在该方法上用@Parameters注解
 * 
 * @author zhanghua
 *
 */
@RunWith(Parameterized.class)
public class DependencyInversionPrincipleTest {
	
	private final HeadingFinder finder;

	public DependencyInversionPrincipleTest(HeadingFinder finder) {
		this.finder = finder;
	}
	
	/**
	 * 通过@Parameterized.Parameters对finder进行实例化
	 * 该方法必须是静态static的，并返回一个集合Collection
	 * 
	 * @return
	 */
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{new NoDIP()}, {new ExtractedDIP()}};
		return Arrays.asList(data);
	}
	
	@Test
	public void correctHeadings() {
		InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("test_file"));
		List<String> headings = finder.findHeadings(reader);
		System.out.println(headings);
		Assert.assertEquals(Arrays.asList("Improve Content", "Cleanup", "Add Content", "Add to Streams Chapter"),
				headings);
	}
	
}
