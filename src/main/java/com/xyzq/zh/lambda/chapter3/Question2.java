package com.xyzq.zh.lambda.chapter3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.xyzq.zh.lambda.chapter1.Artist;

public class Question2 {
	
	public int getTotalMembersCount(List<Artist> artists) {
		return artists.stream()
				.map(artist -> artist.getMembers().count())
				.reduce(0L, (totalMembers, count) -> totalMembers + count)
				.intValue();
	}
	
	/**
	 * 计算一个字符串中小写字母的个数
	 * 
	 * @param value
	 * @return
	 */
	public int calLowercaseCount(String value) {
		return (int) value.chars()
				.filter(ch -> Character.isLowerCase(ch))
				.count();
	}
	
	/**
	 * 在一个字符串列表中，找出包含最多小写字母的字符串。
	 * 对于空列表，返回Optional<String>对象
	 * 
	 * @param list
	 * @return
	 */
	public Optional<String> findMostLowercaseStr(List<String> list) {
		// 调用calLowercaseCount方法获取字符串中的小写字母的个数
		return list.stream()
				.max(Comparator.comparing(str -> calLowercaseCount(str)));
	}
	
}
