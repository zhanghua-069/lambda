package com.xyzq.zh.lambda.chapter5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.xyzq.zh.lambda.chapter1.Album;
import com.xyzq.zh.lambda.chapter1.Artist;

/**
 * 组合收集器-下游收集器的使用
 * 收集器是生成最终结果的一剂配方，下游收集器则是生成部分结果的配方，主收集器中会用到下游收集器
 * 
 * @author zhanghua
 *
 */
public class Exercise4 {
	
	/**
	 * 原始做法：将专辑按艺术家分组，再遍历对各艺术家的专辑计数
	 * 
	 * @param albums
	 * @return
	 */
	public Map<Artist, Integer> numberOfAlbumsDumb(Stream<Album> albums) {
		Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMainMusician));
		
		Map<Artist, Integer> numberOfAlbums = new HashMap<Artist, Integer>();
		for(Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
			numberOfAlbums.put(entry.getKey(), entry.getValue().size());
		}
		return numberOfAlbums;
	}
	
	/**
	 * 先使用groupingBy对数据进行分块，再使用下游收集器counting对每块中的元素进行计数，最后将结果映射为一个Map
	 * 
	 * @param albums
	 * @return
	 */
	public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
		return albums.collect(Collectors.groupingBy(Album::getMainMusician, 
				Collectors.counting()));
	}
	
	/**
	 * 使用简单方式求每个艺术家的专辑名
	 * 
	 * @param albums
	 * @return
	 */
	public Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums) {
		Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
		Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMainMusician));
		for(Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
			nameOfAlbums.put(entry.getKey(), entry.getValue()
													.stream()
													.map(Album::getName)
													.collect(Collectors.toList()));
			
		}
		return nameOfAlbums;
	}
	
	/**
	 * 使用收集器mapping求每个艺术家的专辑名
	 * 
	 * @param albums
	 * @return
	 */
	public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
		return albums.collect(Collectors.groupingBy(Album::getMainMusician, 
				Collectors.mapping(Album::getName, 
						Collectors.toList())));
	}
	
}
