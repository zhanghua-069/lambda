package com.xyzq.zh.lambda.chapter3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.xyzq.zh.lambda.chapter1.Album;
import com.xyzq.zh.lambda.chapter1.Track;

/**
 * 重构遗留代码，转换成使用流风格的代码
 * 
 * @author zhanghua
 *
 */
public class ExerciseTest {
	
	/**
	 * 遗留代码：找出长度大于1分钟的曲目
	 * 
	 * @param albums
	 * @return
	 */
	public Set<String> findLongTracks(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		for(Album album : albums) {
			for(Track track : album.getTrackList()) {
				if(track.getLength() > 60) {
					String name = track.getName();
					trackNames.add(name);
				}
			}
		}
		return trackNames;
	}
	
	/**
	 * 重构第一步：使用Stream的forEach替换掉for循环
	 * 
	 * @param albums
	 * @return
	 */
	public Set<String> restructure1(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream().forEach(album -> {
			album.getTrackList().stream()
			.forEach(track -> {
				if(track.getLength() > 60) {
					String name = track.getName();
					trackNames.add(name);
				}
			});
		});
		return trackNames;
	}
	
	/**
	 * 重构第二步：内层forEach优化，用更符合流风格的操作替换内层循环
	 * 
	 * @param albums
	 * @return
	 */
	public Set<String> restructure2(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream().forEach(album -> {
			album.getTrackList().stream()
			.filter(track -> track.getLength() > 60)
			.map(track -> track.getName())
			.forEach(name -> trackNames.add(name));
		});
		return trackNames;
	}
	
	
	/**
	 * 重构第三步：将专辑转化为曲目的stream，使用flatMap操作替换外层forEach方法
	 * 
	 * @param albums
	 * @return
	 */
	public Set<String> restructure3(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream()
				.flatMap(album -> album.getTracks())
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.forEach(name -> trackNames.add(name));
		return trackNames;
	}
	
	/**
	 * 重构第四步：通过一连串的stream操作直接获得Set对象，
	 * 使用collect(Collectors.toSet())代替手动创建Set对象
	 * 
	 * @param albums
	 * @return
	 */
	public Set<String> restructure4(List<Album> albums) {
		Set<String> trackNames = albums.stream()
				.flatMap(album -> album.getTracks())
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.collect(Collectors.toSet());
		return trackNames;
	}
	
}
