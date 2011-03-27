package com.sysu.sharemovie.jdo;

import java.util.Date;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class MovieList {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String listname;
	
	@Persistent
	private Date createdate;
	
	@Persistent
	private float score;
	
	@Persistent
	private int numofscore;
	
	@Persistent
	private String listDescription;
	
	@Persistent
	private Set<Key> movieInList;
	
	@Persistent
	private Set<Key> movieComments;
	
	@Persistent
	private Set<Key> movieTag;

	
	public MovieList(String listname, Date createdate, String listDescription,
			Set<Key> movieInList, Set<Key> movieTag) {
		super();
		this.listname = listname;
		this.createdate = createdate;
		this.listDescription = listDescription;
		this.movieInList = movieInList;
		this.movieTag = movieTag;
		this.score = 0.0f;
		this.numofscore = 0;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getListname() {
		return listname;
	}

	public void setListname(String listname) {
		this.listname = listname;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getNumofscore() {
		return numofscore;
	}

	public void setNumofscore(int numofscore) {
		this.numofscore = numofscore;
	}

	public String getListDescription() {
		return listDescription;
	}

	public void setListDescription(String listDescription) {
		this.listDescription = listDescription;
	}

	public Set<Key> getMovieInList() {
		return movieInList;
	}

	public void setMovieInList(Set<Key> movieInList) {
		this.movieInList = movieInList;
	}

	public Set<Key> getMovieComments() {
		return movieComments;
	}

	public void setMovieComments(Set<Key> movieComments) {
		this.movieComments = movieComments;
	}

	public Set<Key> getMovieTag() {
		return movieTag;
	}

	public void setMovieTag(Set<Key> movieTag) {
		this.movieTag = movieTag;
	}
	
	
}
