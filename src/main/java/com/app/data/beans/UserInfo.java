package com.app.data.beans;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="User_info")
public class UserInfo  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userid;

	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String lastname;

	@ManyToOne
	@JoinColumn(name="role_id",nullable=true)
	private Role role;

	public UserInfo(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public UserInfo() {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", role=" + role
				+ "]";
	}
	
	
}