package com.app.api.requestbean;

public class ChangePasswordBean {
	
	private String userid;
	private String oldPassword;
	private String newPassword;
	
	public ChangePasswordBean() {
	}

	public ChangePasswordBean(String userid, String oldPassword,
			String newPassword) {
		super();
		this.userid = userid;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ChangePasswordBean [userid=" + userid + ", oldPassword="
				+ oldPassword + ", newPassword=" + newPassword + "]";
	}

	
	
	
}
