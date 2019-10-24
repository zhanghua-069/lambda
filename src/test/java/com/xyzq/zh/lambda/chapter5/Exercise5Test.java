package com.xyzq.zh.lambda.chapter5;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xyzq.zh.lambda.chapter1.Artist;

public class Exercise5Test {
	
	@Test
	public void test1() {
		List<Artist> artists = artistList();
		Exercise5 domain = new Exercise5();
		String names = domain.formatArtistNamesDumb(artists);
		System.out.println(names);
	}
	
	@Test
	public void test2() {
		List<Artist> artists = artistList();
		Exercise5 domain = new Exercise5();
		String names = domain.formatArtistNamesImprove(artists);
		System.out.println(names);
	}
	
	@Test
	public void test3() {
		List<Artist> artists = artistList();
		Exercise5 domain = new Exercise5();
		String names = domain.formatArtistNamesByStringCollector(artists);
		System.out.println(names);
	}
	
	@Test
	public void test4() {
		List<Artist> artists = artistList();
		Exercise5 domain = new Exercise5();
		String names = domain.formatArtistNamesByReducing(artists);
		System.out.println(names);
	}
	
	private List<Artist> artistList() {
		List<Artist> artists = new ArrayList<>();
		Artist artist = new Artist("Tom", "American");
		Artist artist1 = new Artist("Xilu", "China");
		Artist artist2 = new Artist("Souga", "English");
		Artist artist3 = new Artist("Asika", "Japan");
		Artist artist4 = new Artist("John", "France");
		
		artists.add(artist);
		artists.add(artist1);
		artists.add(artist2);
		artists.add(artist3);
		artists.add(artist4);
		return artists;
	}
	
}
