package com.app.api.requestbean;

public class CreateStudentBean {
	
	private String firstname;
	private String lastname;
	private String registrationnumber;
	private String studentclass;
	private String studentsection;
	private String referencenumber;
	private String photo;
	private Integer routeId;
	private Integer schoolId;
	
	public CreateStudentBean() {
	}

	public CreateStudentBean(String firstname, String lastname,
			String registrationnumber, String studentclass,
			String studentsection, String referencenumber, String photo,
			Integer routeId, Integer schoolId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.registrationnumber = registrationnumber;
		this.studentclass = studentclass;
		this.studentsection = studentsection;
		this.referencenumber = referencenumber;
		this.photo = photo;
		this.routeId = routeId;
		this.schoolId = schoolId;
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

	public String getReferencenumber() {
		return referencenumber;
	}

	public void setReferencenumber(String referencenumber) {
		this.referencenumber = referencenumber;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public String toString() {
		return "CreateStudentBean [firstname=" + firstname + ", lastname="
				+ lastname + ", registrationnumber=" + registrationnumber
				+ ", studentclass=" + studentclass + ", studentsection="
				+ studentsection + ", referencenumber=" + referencenumber
				+ ", photo=" + photo + ", routeId=" + routeId + ", schoolId="
				+ schoolId + "]";
	}
	
	
}
