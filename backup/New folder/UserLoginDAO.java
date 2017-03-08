package com.app.data.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.app.data.beans.UserLogin;
@Repository
public class UserLoginDAO extends BaseHibernateDAO<UserLogin>  {

	protected UserLoginDAO() {
		super(UserLogin.class);
	}
}