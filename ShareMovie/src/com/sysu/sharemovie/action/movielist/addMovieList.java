package com.sysu.sharemovie.action.movielist;

import java.util.Set;

import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.ModelDriven;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.SMUser;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.SMUserDAO;

@SuppressWarnings("serial")
public class addMovieList extends BaseAction implements ModelDriven<MovieList>{
	private MovieList list= new MovieList();
	
	@Override
	public MovieList getModel() {
		return list;
	}


	public String execute(){
		MovieListDAO listDAO = new MovieListDAO();
		SMUserDAO userDAO = new SMUserDAO();
		listDAO.makeconnect();
		userDAO.makeconnect();
		SMUser user;
		Key userKey = (Key) getSession("userkey");
		//System.out.println(userKey.toString());
		listDAO.addMovieList(list);
		try {
			//System.out.println(list.getKey().toString());
			user = userDAO.querySMUserByID(userKey);
			Set<Key> userMovieList = user.getUserMovielist();
			userMovieList.add(list.getKey());
			//user.setUserMovielist(userMovieList);
			list.setOwner(userKey);
		} catch (Exception e) {
			return INPUT;
		} finally {
			userDAO.closeconnect();
			listDAO.closeconnect();		
		}
		this.addActionMessage("success");
		return SUCCESS;
	}
	
}
