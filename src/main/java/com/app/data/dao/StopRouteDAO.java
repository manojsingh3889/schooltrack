package com.app.data.dao;

import org.springframework.stereotype.Repository;

import com.app.data.beans.StopRouteMapping;

@Repository
public class StopRouteDAO extends BaseHibernateDAO<StopRouteMapping>{

	protected StopRouteDAO() {
		super(StopRouteMapping.class);
	}

	
}
