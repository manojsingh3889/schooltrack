package com.app.data.dao;
// default package

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.data.beans.UserInfo;
import com.app.data.beans.UserLogin;

/**
 * A data access object (DAO) providing persistence and search support for UserLogin entities.
 * Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
 * @see .UserLogin
 * @author MyEclipse Persistence Tools 
 */
public class UserLoginDAO extends BaseHibernateDAO  {
	private static final Logger log = LoggerFactory.getLogger(UserLoginDAO.class);
	//property constants
	public static final String EMAIL = "email";
	public static final String PASSWORDHASH = "passwordhash";
	public static final String PASSWORDSALT = "passwordsalt";




	public void save(UserLogin transientInstance) {
		log.debug("saving UserLogin instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserLogin persistentInstance) {
		log.debug("deleting UserLogin instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserLogin findById( java.lang.Integer id) {
		log.debug("getting UserLogin instance with id: " + id);
		try {
			UserLogin instance = (UserLogin) getSession()
					.get("UserLogin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	public List<UserLogin> findByExample(UserLogin instance) {
		log.debug("finding UserInfo instance by example");
		try {
			List<UserLogin> results = (List<UserLogin>) getSession()
					.createCriteria(UserLogin.class)
					.add( create(instance) )
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}    

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UserLogin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserLogin as model where model." 
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
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


	public List findAll() {
		log.debug("finding all UserLogin instances");
		try {
			String queryString = "from UserLogin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserLogin merge(UserLogin detachedInstance) {
		log.debug("merging UserLogin instance");
		try {
			UserLogin result = (UserLogin) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserLogin instance) {
		log.debug("attaching dirty UserLogin instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserLogin instance) {
		log.debug("attaching clean UserLogin instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}