package com.xyzq.zh.lambda.chapter4;

import java.util.stream.Stream;

import com.xyzq.zh.lambda.chapter1.Artist;

public interface Performance {
	
	public String getName();
	
	/**
	 * 获取乐队信息
	 * 
	 * @return
	 */
	public Stream<Artist> getMusicians();
	
	/**
	 * 获取乐队名和乐队成员
	 * 
	 * @return
	 */
	public default Stream<Artist> getAllMusicians() {
		return getMusicians()
				.flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
	}
	
}
