package com.app.data.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="handler_info")
public class HandlerInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="class")
	private String handlerclass;
	
	@Column(name="subject")
	private String handlersubject;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="designation")
	private String designation;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	private SchoolInfo school;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserInfo user;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="route_id")
	private RouteInfo route;
	
	public HandlerInfo() {
	}

	public HandlerInfo(Integer id, String firstname, String lastname,
			String handlerclass, String handlersubject, String photo,
			String designation, SchoolInfo school, UserInfo user,
			RouteInfo route) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.handlerclass = handlerclass;
		this.handlersubject = handlersubject;
		this.photo = photo;
		this.designation = designation;
		this.school = school;
		this.user = user;
		this.route = route;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getHandlerclass() {
		return handlerclass;
	}

	public void setHandlerclass(String handlerclass) {
		this.handlerclass = handlerclass;
	}

	public String getHandlersubject() {
		return handlersubject;
	}

	public void setHandlersubject(String handlersubject) {
		this.handlersubject = handlersubject;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public SchoolInfo getSchool() {
		return school;
	}

	public void setSchool(SchoolInfo school) {
		this.school = school;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public RouteInfo getRoute() {
		return route;
	}

	public void setRoute(RouteInfo route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "HandlerInfo [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", handlerclass=" + handlerclass
				+ ", handlersubject=" + handlersubject + ", photo=" + photo
				+ ", designation=" + designation + ", school=" + school
				+ ", user=" + user + ", route=" + route + "]";
	}
	
	
	
}
