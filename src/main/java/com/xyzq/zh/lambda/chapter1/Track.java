package com.xyzq.zh.lambda.chapter1;

/**
 * 
 * @author zhanghua
 *
 */
public class Track {
	
	private String name;
    private int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the length of the track in milliseconds.
     */
    public int getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }

	
}
