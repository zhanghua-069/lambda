package com.xyzq.zh.lambda.chapter3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.xyzq.zh.lambda.chapter1.Album;
import com.xyzq.zh.lambda.chapter1.Track;

/**
 * 重构遗留代码
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
	
}
