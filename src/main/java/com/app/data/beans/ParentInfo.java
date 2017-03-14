package com.app.data.beans;

import java.util.List;

public class ParentInfo extends UserInfo {
	private List<StudentInfo> studentInfoList;
	
	public void setStudents(List<StudentInfo> list){
		studentInfoList = list;
	}
	
	public List<StudentInfo> getStudents(){
		return studentInfoList;
	}
}
