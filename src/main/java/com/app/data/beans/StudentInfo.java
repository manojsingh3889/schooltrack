package com.app.data.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="student_info", 
uniqueConstraints = {@UniqueConstraint(columnNames = {"referencenumber"})})
public class StudentInfo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private Integer studentid;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="registrationnumber")
	private String registrationnumber;
	
	@Column(name="studentclass")
	private String studentclass;
	
	@Column(name="studentsection")
	private String studentsection;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="referencenumber")
	private String referencenumber;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="route_id")
	private RouteInfo route;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="stop_id")
	private StopInfo stop;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	private SchoolInfo school;
	
	public StudentInfo() {
	}

	public StudentInfo(Integer studentid, String firstname, String lastname,
			String registrationnumber, String studentclass,
			String studentsection, String photo, String referencenumber,
			RouteInfo route, StopInfo stop, SchoolInfo school) {
		super();
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.registrationnumber = registrationnumber;
		this.studentclass = studentclass;
		this.studentsection = studentsection;
		this.photo = photo;
		this.referencenumber = referencenumber;
		this.route = route;
		this.stop = stop;
		this.school = school;
	}

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
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

	public String getRegistrationnumber() {
		return registrationnumber;
	}

	public void setRegistrationnumber(String registrationnumber) {
		this.registrationnumber = registrationnumber;
	}

	public String getStudentclass() {
		return studentclass;
	}

	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}

	public String getStudentsection() {
		return studentsection;
	}

	public void setStudentsection(String studentsection) {
		this.studentsection = studentsection;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getReferencenumber() {
		return referencenumber;
	}

	public void setReferencenumber(String referencenumber) {
		this.referencenumber = referencenumber;
	}

	public RouteInfo getRoute() {
		return route;
	}

	public void setRoute(RouteInfo route) {
		this.route = route;
	}

	public StopInfo getStop() {
		return stop;
	}

	public void setStop(StopInfo stop) {
		this.stop = stop;
	}

	public SchoolInfo getSchool() {
		return school;
	}

	public void setSchool(SchoolInfo school) {
		this.school = school;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StudentInfo [studentid=" + studentid + ", firstname="
				+ firstname + ", lastname=" + lastname
				+ ", registrationnumber=" + registrationnumber
				+ ", studentclass=" + studentclass + ", studentsection="
				+ studentsection + ", photo=" + photo + ", referencenumber="
				+ referencenumber + ", route=" + route + ", stop=" + stop
				+ ", school=" + school + "]";
	}

	
	
}
