package com.app.data.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.app.data.beans.UserLogin;

@Repository
public class UserLoginDAO extends BaseHibernateDAO<UserLogin>  {

	public static final String PASSWORDHASH = "passwordhash";
	public static final String PASSWORDSALT = "passwordsalt";
	
	protected UserLoginDAO() {
		super(UserLogin.class);
	}
	
	public UserLogin findByEmail(String email) {
		log.debug("finding UserInfo instance by example");
		try {
			UserLogin instance = new UserLogin();
			instance.setEmail(email);
			Criteria criteria = getSession().createCriteria(UserLogin.class).add( create(instance) );
			UserLogin result = (UserLogin) criteria.uniqueResult();
			log.debug("find by example successful, result size: " + result);
			return result;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<UserLogin> findByPasswordhash(Object passwordhash) {
		return findByProperty(PASSWORDHASH, passwordhash);
	}

	public List<UserLogin> findByPasswordsalt(Object passwordsalt) {
		return findByProperty(PASSWORDSALT, passwordsalt);
	}
}