package com.app.data.dao;

import org.springframework.stereotype.Repository;

import com.app.data.beans.UserStudentMapping;

@Repository
public class UserStudentDAO extends BaseHibernateDAO<UserStudentMapping>{

	protected UserStudentDAO() {
		super(UserStudentMapping.class);
	}
	
}
