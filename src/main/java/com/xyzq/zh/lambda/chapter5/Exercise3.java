package com.xyzq.zh.lambda.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.xyzq.zh.lambda.chapter1.Album;
import com.xyzq.zh.lambda.chapter1.Artist;

/**
 * 使用收集器
 * 
 * @author zhanghua
 *
 */
public class Exercise3 {
	
	/**
	 * 定制集合 - toCollection
	 * 使用Collectors.toCollection定制集合收集元素
	 */
	public void examp1() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		TreeSet<Integer> treeSet = list.stream().collect(Collectors.toCollection(TreeSet::new));
	}
	
	/**
	 * 求最大值 - maxBy
	 * 找出成员最多的乐队
	 * 
	 * @param artists
	 * @return
	 */
	public Optional<Artist> biggestGroup(Stream<Artist> artists) {
		Function<Artist, Long> getCount = artist -> artist.getMembers().count();
		return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
	}
	
	/**
	 * 求平均值 - averagingInt
	 * 找出一组专辑上曲目的平均数
	 * 
	 * @param albums
	 * @return
	 */
	public double averageNumberOfTracks(List<Album> albums) {
		return albums.stream()
				.collect(Collectors.averagingInt(album -> album.getTrackList().size()));
	}
	
	/**
	 * 数据分块 - partitioningBy
	 * 使用方法引用将艺术家组成的Stream分成乐队和独唱歌手两部分
	 * 
	 * @param artists
	 * @return
	 */
	public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
		return artists.collect(Collectors.partitioningBy(Artist::isSolo));
	}
	
	/**
	 * 数据分组 - groupingBy
	 * 使用主唱对专辑分组
	 * 
	 * @param albums
	 * @return
	 */
	public Map<Artist, List<Album>> albumByArtist(Stream<Album> albums) {
		return albums.collect(Collectors.groupingBy(Album::getMainMusician));
	}
	
	public String formatArtistNames1(List<Artist> artists) {
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
	 * 收集流中数据组合成字符串 - joining
	 * 使用流和收集器格式化艺术家姓名
	 * 
	 * @param artists
	 * @return
	 */
	public String formatArtistNames(List<Artist> artists) {
		return artists.stream()
				.map(Artist::getName)
				.collect(Collectors.joining(", ", "[", "]"));
	}
	
}
