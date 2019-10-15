package com.xyzq.zh.lambda.chapter1;

import java.util.stream.Stream;

/**
 * 表演接口
 * 
 * @author zhanghua
 *
 */
public interface Performance {
	
	public String getName();

    public Stream<Artist> getMusicians();

    public default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> {
            return Stream.concat(Stream.of(artist), artist.getMembers());
        });
    }
	
}
