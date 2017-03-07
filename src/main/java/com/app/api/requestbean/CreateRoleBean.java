package com.app.api.requestbean;

public class CreateRoleBean {
	
	private String roleCode;
	private String roleDisplayName;
	private String description;
	
	public CreateRoleBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateRoleBean(String roleCode, String roleDisplayName, String description) {
		super();
		this.roleCode = roleCode;
		this.roleDisplayName = roleDisplayName;
		this.description = description;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleDisplayName() {
		return roleDisplayName;
	}
	public void setRoleDisplayName(String roleDisplayName) {
		this.roleDisplayName = roleDisplayName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
