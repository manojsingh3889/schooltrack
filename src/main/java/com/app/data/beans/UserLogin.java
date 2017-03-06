package com.app.data.beans;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * UserLogin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="User_login")

public class UserLogin  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private Integer userid;

	@Column(name="email")
	private String email;

	@Column(name="passwordhash")
	private String passwordhash;

	@Column(name="passwordsalt")
	private String passwordsalt;

	@OneToOne(mappedBy="userLogin")
	@Cascade(value=CascadeType.ALL)
	private UserInfo userInfo;
	
	public UserLogin(String email, String passwordhash, String passwordsalt) {
		this.email = email;
		this.passwordhash = passwordhash;
		this.passwordsalt = passwordsalt;
	}

	public UserLogin() {
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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
		return "UserLogin [userid=" + userid + ", email=" + email + ", passwordhash=" + passwordhash + ", passwordsalt="
				+ passwordsalt + ", userInfo=" + userInfo + "]";
	}
}