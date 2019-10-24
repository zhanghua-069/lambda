package com.xyzq.zh.lambda.chapter5;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import com.xyzq.zh.lambda.chapter1.Artist;

/**
 * 重构和定制收集器
 * 
 * @author zhanghua
 *
 */
public class Exercise5 {
	
	/**
	 * 使用for循环和StringBuilder格式化艺术家姓名
	 * 
	 * @param artists
	 * @return
	 */
	public String formatArtistNamesDumb(List<Artist> artists) {
		StringBuilder builder = new StringBuilder("[");
		for(Artist artist : artists) {
			if(builder.length() > 1) {
				builder.append(", ");
			}
			
			builder.append(artist.getName()); 
		}
		
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * 使用reduce和StringJoiner格式化艺术家姓名
	 * StringJoiner累加器
	 * StringJoiner.add返回连接新元素后的结果
	 * StringJoiner.merge连接两个StringJoiner对象
	 * 
	 * @param artists
	 * @return
	 */
	public String formatArtistNamesImprove(List<Artist> artists) {
		return artists.stream()
				.map(Artist::getName)
				.reduce(new StringJoiner(", ", "[", "]"), 
						StringJoiner::add, 
						StringJoiner::merge)
				.toString();
	}
	
	/**
	 * 使用自定义收集器StringCollector格式化艺术家姓名
	 * 
	 * @param artists
	 * @return
	 */
	public String formatArtistNamesByStringCollector(List<Artist> artists) {
		return artists.stream()
				.map(Artist::getName)
				.collect(new StringCollector(", ", "[", "]"));
	}
	
	/**
	 * 使用reducing收集器编写字符串处理程序
	 * reducing功能类似定制化的StringCollector收集器，但非常低效，不推荐使用
	 * 
	 * @param artists
	 * @return
	 */
	public String formatArtistNamesByReducing(List<Artist> artists) {
		return artists.stream()
				.map(Artist::getName)
				.collect(Collectors.reducing(new StringJoiner(", " , "[", "]"),
						// 此处会为流中每个元素创建唯一的StringJoiner，这种方式非常低效
						name -> new StringJoiner(", " , "[", "]").add(name), 
						StringJoiner::merge))
				.toString();
	}
}
