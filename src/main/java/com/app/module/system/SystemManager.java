package com.app.module.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.requestbean.CreatePriviledgeBean;
import com.app.api.requestbean.CreateRoleBean;
import com.app.data.beans.Priviledge;
import com.app.data.beans.Role;
import com.app.data.service.SystemService;
import com.app.utility.Utility;


@Component
public class SystemManager {

	@Autowired
	SystemService systemService;

	public String createRole(CreateRoleBean bean) {
		if(bean != null && !Utility.isEmpty(bean.getRoleCode())){
			systemService.createRole(bean.getRoleCode(),bean.getRoleDisplayName(),bean.getDescription());
			return "success";
		}else{
			return "empty request";
		}
	}

	public String createPriviledge(CreatePriviledgeBean bean) {
		if(bean != null && !Utility.isEmpty(bean.getPriviledgeCode())){
			systemService.createPriviledge(bean.getPriviledgeCode(),bean.getPriviledgeDisplayName(),bean.getDescription());
			return "success";
		}else{
			return "empty request";
		}
	}

	public List<Role> getRoles() {
		return systemService.getAllRoles();
	}

	public Role getRole(Integer roleId) {
		return systemService.getRole(roleId);
	}
	public List<Priviledge> getPriviledges() {
		return systemService.getAllPriviledges();
	}

	public Priviledge getPriviledge(Integer priviledgeId) {
		return systemService.getPriviledge(priviledgeId);
	}	
}
