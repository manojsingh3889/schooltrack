package com.app.data.dao;
// default package

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.data.beans.UserInfo;


@Repository
public class UserInfoDAO extends BaseHibernateDAO<UserInfo>{

	public static final String FIRSTNAME = "firstname";
	public static final String LASTNAME = "lastname";
	
	protected UserInfoDAO() {
		super(UserInfo.class);
	}
	
	public List<UserInfo> findByFirstname(Object firstname
	) {
		return findByProperty(FIRSTNAME, firstname
		);
	}
	
	public List<UserInfo> findByLastname(Object lastname
	) {
		return findByProperty(LASTNAME, lastname
		);
	}
}