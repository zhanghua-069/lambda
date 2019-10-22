package com.xyzq.zh.lambda.chapter4;

import java.util.List;
import java.util.Optional;

import com.xyzq.zh.lambda.chapter1.Artist;

public class ArtistsFixed {
	
	private List<Artist> artists;
	
	public ArtistsFixed(List<Artist> artists) {
		this.artists = artists;
	}
	
	/*public Artist getArtist(int index) {
		if(index < 0 || index >= artists.size()) {
			indexException(index);
		}
		return artists.get(index);
	}*/
	
	/**
	 * 重构getArtist，返回一个Optional<Artist>对象，
	 * 如果索引在有效范围内，返回对应元素，否则返回一个空Optional对象
	 * 
	 * @param index
	 * @return
	 */
	public Optional<Artist> getArtist(int index) {
		if(index < 0 || index >= artists.size()) {
			return Optional.empty();
		}
		return Optional.of(artists.get(index));
	}
	
	/*public String getArtistName(int index) {
		try {
			Artist artist = getArtist(index);
			return artist.getName();
		} catch (IllegalArgumentException e) {
			return "unknow";
		}
	}*/
	
	/**
	 * 重构getArtistName，如果索引在有效范围内，返回对应名称，否则返回"unknow"
	 * 
	 * @param index
	 * @return
	 */
	public String getArtistName(int index) {
		return getArtist(index)
				.map(artist -> artist.getName())
				.orElse("unknow");
	}
	
	private void indexException(int index) {
		throw new IllegalArgumentException(index + "doesn't correspond to an Artist");
	}
	
}
