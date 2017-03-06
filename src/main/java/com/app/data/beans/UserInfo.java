package com.app.data.beans;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="User_info")

public class UserInfo  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="userid", unique=true, nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters={@Parameter(name="property", value="userid")})
	private Integer userid;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
//	@JoinColumn(name="roleid")
//	private Role role;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private UserLogin userLogin;
	
	public UserInfo(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	
	


}