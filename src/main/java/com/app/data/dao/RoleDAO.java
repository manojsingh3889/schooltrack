package com.app.data.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.data.beans.Role;

@Repository
public class RoleDAO extends BaseHibernateDAO<Role>  {
	public static final String NAME = "name";

	protected RoleDAO() {
		super(Role.class);
	}

	public List<Role> findByName(Object name) {
		return findByProperty(NAME, name);
	}
}