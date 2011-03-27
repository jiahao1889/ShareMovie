package com.sysu.sharemovie.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Link;

@PersistenceCapable
public class Movie {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String moviename;
	
	@Persistent
	private String movieDescription;
	
	@Persistent
	private Link movielink;
	
	@Persistent
	private Blob image;

	public Movie(String moviename, String movieDescription) {
		super();
		this.moviename = moviename;
		this.movieDescription = movieDescription;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public Link getMovielink() {
		return movielink;
	}

	public void setMovielink(Link movielink) {
		this.movielink = movielink;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
	
}
