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
public class PriviledgeDAO extends BaseHibernateDAO<Priviledge>  {

	protected PriviledgeDAO() {
		super(Priviledge.class);
	}
}