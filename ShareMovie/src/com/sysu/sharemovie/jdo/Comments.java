package com.sysu.sharemovie.jdo;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Comments {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private Key author;
	
	@Persistent
	private String content;
	
	@Persistent
	private Date date;
	
	@Persistent
	private Key movielistname;

	public Comments(Key author, String content, Date date, Key movielistname) {
		super();
		this.author = author;
		this.content = content;
		this.date = date;
		this.movielistname = movielistname;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Key getAuthor() {
		return author;
	}

	public void setAuthor(Key author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Key getMovielistname() {
		return movielistname;
	}

	public void setMovielistname(Key movielistname) {
		this.movielistname = movielistname;
	}
	
	
}
