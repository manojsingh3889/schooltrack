package com.app.api.requestbean;

import java.util.Date;

import com.app.data.beans.Role;

public class RegisterBean {
	private Long id;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private Date dateOfBirth;
	private Role role;
	
	public RegisterBean() {
		super();
	}

	public RegisterBean(Long id, String password,
			String firstname, String lastname, String email, String mobile,
			Date dateOfBirth, Role role) {
		super();
		this.id = id;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
	}
	
	
	public RegisterBean(Long id, String password,
			String firstname, String lastname, String email, String mobile,
			Date dateOfBirth) {
		super();
		this.id = id;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.dateOfBirth = dateOfBirth;
	}
	
	public RegisterBean(String password,
			String firstname, String lastname, String email, String mobile,
			Date dateOfBirth) {
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.dateOfBirth = dateOfBirth;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
