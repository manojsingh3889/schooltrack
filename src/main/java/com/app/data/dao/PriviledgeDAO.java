package com.app.data.dao;
// default package

import static org.hibernate.criterion.Example.create;


import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.app.data.beans.Priviledge;

@Repository
public class PriviledgeDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(PriviledgeDAO.class);
		//property constants



    
    public void save(Priviledge transientInstance) {
        log.debug("saving Priviledge instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Priviledge persistentInstance) {
        log.debug("deleting Priviledge instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Priviledge findById( java.lang.Integer id) {
        log.debug("getting Priviledge instance with id: " + id);
        try {
            Priviledge instance = (Priviledge) getSession()
                    .get(Priviledge.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Priviledge> findByExample(Priviledge instance) {
        log.debug("finding Priviledge instance by example");
        try {
            List<Priviledge> results = (List<Priviledge>) getSession()
                    .createCriteria(Priviledge.class)
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
      log.debug("finding Priviledge instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Priviledge as model where model." 
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
		log.debug("finding all Priviledge instances");
		try {
			String queryString = "from Priviledge";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Priviledge merge(Priviledge detachedInstance) {
        log.debug("merging Priviledge instance");
        try {
            Priviledge result = (Priviledge) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Priviledge instance) {
        log.debug("attaching dirty Priviledge instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Priviledge instance) {
        log.debug("attaching clean Priviledge instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}