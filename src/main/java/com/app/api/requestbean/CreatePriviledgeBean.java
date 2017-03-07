package com.app.api.requestbean;

public class CreatePriviledgeBean {
	
	private String priviledgeCode;
	private String priviledgeDisplayName;
	private String description;
	public CreatePriviledgeBean(String priviledgeCode, String priviledgeDisplayName, String description) {
		super();
		this.priviledgeCode = priviledgeCode;
		this.priviledgeDisplayName = priviledgeDisplayName;
		this.description = description;
	}
	public CreatePriviledgeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPriviledgeCode() {
		return priviledgeCode;
	}
	public void setPriviledgeCode(String priviledgeCode) {
		this.priviledgeCode = priviledgeCode;
	}
	public String getPriviledgeDisplayName() {
		return priviledgeDisplayName;
	}
	public void setPriviledgeDisplayName(String priviledgeDisplayName) {
		this.priviledgeDisplayName = priviledgeDisplayName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
