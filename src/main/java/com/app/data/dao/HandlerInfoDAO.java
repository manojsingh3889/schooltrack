package com.app.data.dao;

import org.springframework.stereotype.Repository;

import com.app.data.beans.HandlerInfo;

@Repository
public class HandlerInfoDAO extends BaseHibernateDAO<HandlerInfo>{
	
	protected HandlerInfoDAO() {
		super(HandlerInfo.class);
	}

}
