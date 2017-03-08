package com.app.data.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class HandlerInfo {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="handler_id")
	private Integer handlerid;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="handlerclass")
	private String handlerclass;
	
	@Column(name="handlersubject")
	private String handlersubject;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="designation")
	private String designation;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	private String schoolid;
		
	public HandlerInfo() {
		super();
	}
		
	public HandlerInfo(Integer handlerid, String firstname,
			String lastname, String handlerclass, String handlersubject,
			String photo, String designation) {
		super();
		this.handlerid = handlerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.handlerclass = handlerclass;
		this.handlersubject = handlersubject;
		this.photo = photo;
		this.designation = designation;
	}

	public Integer getHandlerid() {
		return handlerid;
	}

	public void setHandlerid(Integer handlerid) {
		this.handlerid = handlerid;
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
	
	public String getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(String schoolid) {
		this.schoolid = schoolid;
	}

	@Override
	public String toString() {
		return "HandlerInfo [handlerid=" + handlerid + ", firstname=" + firstname + ", lastname=" + lastname + ", handlerclass=" + handlerclass
				+ ", handlersubject=" + handlersubject + ", photo=" + photo + ", designation=" + designation + ", schoolid=" + schoolid + "]";
	}
	
}
