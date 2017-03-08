package com.app.data.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class StudentReferenceMapping {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reference_id")
	private Integer referenceid;
	
	@Column(name="referencenumber")
	private String referencenumber;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	private Integer studentid;
	
	public StudentReferenceMapping() {
		super();
	}
	
	public StudentReferenceMapping(Integer referenceid, String referencenumber,
			Integer studentid) {
		super();
		this.referenceid = referenceid;
		this.referencenumber = referencenumber;
		this.studentid = studentid;
	}

	public Integer getReferenceid() {
		return referenceid;
	}
	public void setReferenceid(Integer referenceid) {
		this.referenceid = referenceid;
	}
	public String getReferencenumber() {
		return referencenumber;
	}
	public void setReferencenumber(String referencenumber) {
		this.referencenumber = referencenumber;
	}
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudent_id(Integer studentid) {
		this.studentid = studentid;
	}
	
	
	@Override
	public String toString() {
		return "StudentReferenceMapping [referenceid=" + referenceid + ", referencenumber=" + referencenumber + ", studentid=" + studentid + "]";
	}
	
}
