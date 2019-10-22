package com.xyzq.zh.lambda.chapter5;

import java.util.List;
import java.util.function.BiFunction;

import com.xyzq.zh.lambda.chapter1.Artist;

public class Exercise1 {
	
	public void example(List<Artist> artists) {
		artists.stream().map(artist -> artist.getName());
		artists.stream().map(Artist::getName);
	}
	
	public void example() {
		BiFunction<String, String, Artist> fun =  (name, nationality) -> new Artist(name, nationality);
		fun = Artist::new;
	}
	
}
