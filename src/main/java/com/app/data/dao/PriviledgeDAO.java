package com.app.data.dao;
// default package

import org.springframework.stereotype.Repository;

import com.app.data.beans.Priviledge;

@Repository
public class PriviledgeDAO extends BaseHibernateDAO<Priviledge>  {

	protected PriviledgeDAO() {
		super(Priviledge.class);
	}
}