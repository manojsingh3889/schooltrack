package com.app.data.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="user_login")
public class UserLogin  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="login_id")
	private Integer loginId;

	@Column(name="email", nullable=false, unique = true)
	private String email;

	@Column(name="passwordhash", nullable=false)
	private String passwordhash;

	@Column(name="passwordsalt", nullable=false)
	private String passwordsalt;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private UserInfo userInfo;

	public UserLogin(String email, String passwordhash, String passwordsalt) {
		this.email = email;
		this.passwordhash = passwordhash;
		this.passwordsalt = passwordsalt;
	}

	public UserLogin() {
	}


	public Integer getLoginId() {
		return loginId;
	}

	public void setId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordhash() {
		return passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}

	public String getPasswordsalt() {
		return passwordsalt;
	}

	public void setPasswordsalt(String passwordsalt) {
		this.passwordsalt = passwordsalt;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "UserLogin [loginId=" + loginId + ", email=" + email + ", passwordhash=" + passwordhash + ", passwordsalt="
				+ passwordsalt + ", userInfo=" + userInfo + "]";
	}
}