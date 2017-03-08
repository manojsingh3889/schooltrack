package com.app.data.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.app.data.beans.Role;

@Repository
public class RoleDAO extends BaseHibernateDAO<Role>  {

	protected RoleDAO() {
		super(Role.class);
	}
}