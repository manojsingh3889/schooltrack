package com.app.data.dao;

import org.springframework.stereotype.Repository;

import com.app.data.beans.RouteTracking;

@Repository
public class RouteTrackingDAO extends BaseHibernateDAO<RouteTracking>{

	protected RouteTrackingDAO() {
		super(RouteTracking.class);
	}

	
}
