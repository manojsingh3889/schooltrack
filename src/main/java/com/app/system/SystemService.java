package com.app.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.requestbean.RegisterBean;
import com.app.data.beans.Priviledge;
import com.app.data.beans.Role;
import com.app.data.beans.UserInfo;
import com.app.data.beans.UserLogin;
import com.app.data.dao.PriviledgeDAO;
import com.app.data.dao.RoleDAO;
import com.app.data.dao.UserInfoDAO;
import com.app.data.dao.UserLoginDAO;
import com.app.utility.passwordUtility;
import com.sun.org.apache.regexp.internal.recompile;

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
