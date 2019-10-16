package com.xyzq.zh.lambda.chapter3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.xyzq.zh.lambda.chapter1.Album;
import com.xyzq.zh.lambda.chapter1.Artist;

public class Question1 {
	
	/**
	 * 求和函数，计算流中所有数之和
	 * 
	 * @param numbers
	 * @return
	 */
	public int addUp(Stream<Integer> numbers) {
		return numbers.reduce(0, (sum, number) -> sum + number);
	}
	
	/**
	 * 接收艺术家列表为参数，返回一个包含艺术家名称和国籍的字符串列表
	 * 
	 * @param members
	 * @return
	 */
	public List<String> getArtistNameAndNationality(List<Artist> members) {
		return members.stream()
				.flatMap(member -> Stream.of(member.getName(), member.getName()))
				.collect(Collectors.toList());
	}
	
	/**
	 * 接收专辑列表为参数，返回一个由最多包含3首歌的专辑组成的列表
	 * 
	 * @param albums
	 * @return
	 */
	public List<Album> getAlbumsOfMorenthan3Tracks(List<Album> albums) {
		return albums.stream()
				.filter(album -> album.getTrackList().size() <= 3)
				.collect(Collectors.toList());
	}
	
}
