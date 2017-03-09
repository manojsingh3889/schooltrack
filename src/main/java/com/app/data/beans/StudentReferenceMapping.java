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
	private StudentInfo student;

	public StudentReferenceMapping(Integer referenceid, String referencenumber,
			StudentInfo student) {
		this.referencenumber = referencenumber;
		this.student = student;
	}

	public StudentReferenceMapping() {
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

	public StudentInfo getStudent() {
		return student;
	}

	public void setStudent(StudentInfo student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentReferenceMapping [referenceid=" + referenceid
				+ ", referencenumber=" + referencenumber + ", student="
				+ student + "]";
	}
}
