package com.app.data.dao;

import org.springframework.stereotype.Repository;

import com.app.data.beans.SchoolInfo;

@Repository
public class SchoolDAO extends BaseHibernateDAO<SchoolInfo>{

	protected SchoolDAO() {
		super(SchoolInfo.class);
	}

}
