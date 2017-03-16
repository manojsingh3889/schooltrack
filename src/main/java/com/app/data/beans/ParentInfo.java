package com.app.data.beans;

import java.util.List;

public class ParentInfo extends UserInfo {
	
	
	
	public ParentInfo() {
	}

	
	public ParentInfo(Integer userid, String firstname, String lastname, Role role, List<StudentInfo> studentInfoList) {
		super(userid, firstname, lastname, role);
		this.studentInfoList = studentInfoList;
	}

	private List<StudentInfo> studentInfoList;
	
	public void setStudents(List<StudentInfo> list){
		studentInfoList = list;
	}
	
	public List<StudentInfo> getStudents(){
		return studentInfoList;
	}
}
