package com.app.data.dao;

import org.springframework.stereotype.Repository;

import com.app.data.beans.StopInfo;

@Repository
public class StopDAO extends BaseHibernateDAO<StopInfo>{

	protected StopDAO() {
		super(StopInfo.class);
	}
	
}
