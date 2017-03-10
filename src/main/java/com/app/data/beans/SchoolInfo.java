package com.app.data.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="school_info")
public class SchoolInfo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="school_id")
	private Integer schoolid;
	
	@Column(name="area")
	private String area;
	
	@Column(name="contactnumber1")
	private String contactnumber1;
	
	@Column(name="contactnumber2")
	private String contactnumber2;
	
	public SchoolInfo() {
		super();
	}

	public SchoolInfo(Integer schoolid, String area, String contactnumber1,
			String contactnumber2) {
		super();
		this.schoolid = schoolid;
		this.area = area;
		this.contactnumber1 = contactnumber1;
		this.contactnumber2 = contactnumber2;
	}

	public Integer getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(Integer schoolid) {
		this.schoolid = schoolid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getContactnumber1() {
		return contactnumber1;
	}

	public void setContactnumber1(String contactnumber1) {
		this.contactnumber1 = contactnumber1;
	}

	public String getContactnumber2() {
		return contactnumber2;
	}

	public void setContactnumber2(String contactnumber2) {
		this.contactnumber2 = contactnumber2;
	}
	
	@Override
	public String toString() {
		return "SchoolInfo [schoolid=" + schoolid + ", area=" + area + ", contactnumber1=" + contactnumber1 + ", contactnumber2=" + contactnumber2
				+ "]";
	}
	
}
