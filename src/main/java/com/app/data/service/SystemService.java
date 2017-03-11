package com.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.data.beans.Priviledge;
import com.app.data.beans.Role;
import com.app.data.dao.PriviledgeDAO;
import com.app.data.dao.RoleDAO;

@Component
public class SystemService {
	
	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	PriviledgeDAO priviledgeDAO;

	public Role createRole(String roleCode, String roleDisplayName, String description) {
		Role role = new Role(roleCode, roleDisplayName, description);
		roleDAO.save(role);
		return role;
	}

	public Priviledge createPriviledge(String priviledgeCode, String priviledgeDisplayName, String description) {
		Priviledge priviledge = new Priviledge(priviledgeCode, priviledgeDisplayName, description);
		priviledgeDAO.save(priviledge);
		return priviledge;
	}

	public List<Role> getAllRoles() {
		return roleDAO.findAll();
	}
	
	public Role getRole(Integer id) {
		return roleDAO.findById(id);
	}
	
	public List<Priviledge> getAllPriviledges() {
		return priviledgeDAO.findAll();
	}
	
	public Priviledge getPriviledge(Integer id) {
		return priviledgeDAO.findById(id);
	}

}
