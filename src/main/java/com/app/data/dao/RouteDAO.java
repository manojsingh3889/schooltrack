package com.app.data.dao;

import org.springframework.stereotype.Repository;

import com.app.data.beans.RouteInfo;

@Repository
public class RouteDAO extends BaseHibernateDAO<RouteInfo>{

	protected RouteDAO() {
		super(RouteInfo.class);
	}

}
