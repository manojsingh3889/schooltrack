package com.app.data.beans;
// default package

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;


@Entity
@Table(name="User_info")

public class UserInfo  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userid;
	private String firstname;
	private String lastname;
	private Role role;
	private UserLogin userLogin;


	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/** full constructor */
	/*public UserInfo(String firstname, String lastname, Set<Role> roles, UserLogin userLogin) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.roles = roles;
        this.userLogin = userLogin;
    }*/

	public UserInfo(String firstname, String lastname, UserLogin userLogin) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.userLogin = userLogin;
	}


	@Id @GeneratedValue(strategy=IDENTITY)
	@Column(name="userid", unique=true, nullable=false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name="firstname", nullable=false)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name="lastname", nullable=false)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="role", nullable=true)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userInfo")
	public UserLogin getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", role=" + role + ", userLogin="
				+ userLogin + "]";
	}
	
	
}