package com.app.data.dao;
// default package

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.config.HibernateSessionFactory;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public abstract class BaseHibernateDAO<T> implements IBaseHibernateDAO {

	private static final Logger log = LoggerFactory.getLogger(BaseHibernateDAO.class);
	
	private final Class<T> type;
//	protected abstract Class getBeanType(); 
	protected BaseHibernateDAO(Class<T> type){
		this.type = type;
	}

	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	public void save(T transientInstance) {
		log.debug("saving "+type+" instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(T persistentInstance) {
		log.debug("deleting "+type+" instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public T findById( Integer id) {
		log.debug("getting "+type+" instance with id: " + id);
		try {
			T instance = (T) getSession()
					.get(type, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	public List<T> findByExample(T instance) {
		log.debug("finding "+type+" instance by example");
		try {
			List<T> results = (List<T>) getSession()
					.createCriteria(type)
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
		log.debug("finding "+type+" instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from "+type+" as model where model." 
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public List findAll() {
		log.debug("finding all "+type+" instances");
		try {
			String queryString = "from "+type+"";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public T merge(T detachedInstance) {
		log.debug("merging "+type+" instance");
		try {
			T result = (T) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(T instance) {
		log.debug("attaching dirty "+type+" instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(T instance) {
		log.debug("attaching clean "+type+" instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


}