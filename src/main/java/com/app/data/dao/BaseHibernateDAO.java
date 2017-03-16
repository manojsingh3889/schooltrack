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

	protected static final Logger log = LoggerFactory.getLogger(BaseHibernateDAO.class);
	
	private final Class<T> type;

	protected BaseHibernateDAO(Class<T> type){
		this.type = type;
	}

	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	public void save(T transientInstance) {
		log.info("saving "+type.getSimpleName()+" instance");
		try {
			getSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveOrUpdate(T transientInstance) {
		log.info("saving or updating "+type.getSimpleName()+" instance");
		try {
			getSession().saveOrUpdate(transientInstance);
			log.info("save or update successful");
		} catch (RuntimeException re) {
			log.error("save or update failed", re);
			throw re;
		}
	}

	public void delete(T persistentInstance) {
		log.info("deleting "+type.getSimpleName()+" instance");
		try {
			getSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public T findById( Integer id) {
		log.info("getting "+type.getSimpleName()+" instance with id: " + id);
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
		log.info("finding "+type.getSimpleName()+" instance by example");
		try {
			List<T> results = (List<T>) getSession()
					.createCriteria(type)
					.add( create(instance) )
					.list();
			log.info("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}    
	
	public T findUniqueByExample(T instance) {
		log.info("finding unique"+type.getSimpleName()+" instance by example");
		try {
			T result = (T) getSession()
					.createCriteria(type)
					.add( create(instance) )
					.uniqueResult();
			log.info("find by example successful");
			return result;
		} catch (RuntimeException re) {
			log.error("find unique by example failed", re);
			throw re;
		}
	}    

	public List<T> findByProperty(String propertyName, Object value) {
		log.info("finding "+type.getSimpleName()+" instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from "+type.getSimpleName()+" as model where model." 
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<T>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	public T findUniqueByProperty(String propertyName, Object value) {
		log.info("finding "+type.getSimpleName()+" instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from "+type.getSimpleName()+" as model where model." 
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			T instance = (T)queryObject.uniqueResult();
			return instance;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public List<T> findAll() {
		log.info("finding all "+type.getSimpleName()+" instances");
		
		try {
			String queryString = "from "+type.getSimpleName()+"";
			Query queryObject = getSession().createQuery(queryString);
			return (List<T>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public T merge(T detachedInstance) {
		log.info("merging "+type.getSimpleName()+" instance");
		try {
			T result = (T) getSession()
					.merge(detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(T instance) {
		log.info("attaching dirty "+type.getSimpleName()+" instance");
		try {
			getSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(T instance) {
		log.info("attaching clean "+type.getSimpleName()+" instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


}