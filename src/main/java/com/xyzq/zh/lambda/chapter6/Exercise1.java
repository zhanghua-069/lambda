package com.xyzq.zh.lambda.chapter6;

import java.util.List;

import com.xyzq.zh.lambda.chapter1.Album;
import com.xyzq.zh.lambda.chapter1.Track;

/**
 * 并行化流操作
 * 
 * @author zhanghua
 *
 */
public class Exercise1 {
	
	/**
	 * 串行化计算专辑曲目长度
	 * 
	 * @param albums
	 * @return
	 */
	public int serialArraySum(List<Album> albums) {
		return albums.stream()
				.flatMap(Album::getTracks)
				.mapToInt(Track::getLength)
				.sum();
	}
	
	/**
	 * 并行化计算专辑曲目长度
	 * 调用parallelStream能立即获得一个拥有并行能力的流
	 * 
	 * @param albums
	 * @return
	 */
	public int parallelArraySum(List<Album> albums) {
		return albums.parallelStream()
				.flatMap(Album::getTracks)
				.mapToInt(Track::getLength)
				.sum();
	}
	
}
