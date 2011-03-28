package com.sysu.sharemovie.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.sysu.sharemovie.dao.interfaces.SMUserDAO;
import com.sysu.sharemovie.jdo.SMUser;

public class SMUserDAOImpl implements SMUserDAO{

	@Override
	public boolean addSMUser(SMUser user) throws Exception {
		//System.out.print(user.getUsername());
		if (isSMUserExit(user.getUsername()))
			return false;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(user);
			return true;
		}finally{
			pm.close();
		}
	}

	@Override
	public boolean validateSMUser(SMUser user) throws Exception {
		List<SMUser> result = querySMUser(user.getUsername());
		if (result.size()>0){
			if (user.getPassword().equals(result.get(0).getPassword())){
				return true;
			}
			else{
				return false;
			}
		}
		else{
		    return false;
		}
	}

	private boolean isSMUserExit(String username){
		if (querySMUser(username).size() > 0)
			return true;
		else
		    return false;
	}
	
	@SuppressWarnings("unchecked")
	private List<SMUser> querySMUser(String username){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(SMUser.class, "username == '"+username+"'");
		try{
			List<SMUser> result = (List<SMUser>)query.execute();
			result.size();
			return result;
		}finally{
			query.closeAll();
			pm.close();
		}
	}

}
