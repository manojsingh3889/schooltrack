package com.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.data.beans.StopInfo;
import com.app.data.beans.StudentInfo;
import com.app.data.dao.StopDAO;
import com.app.data.dao.StudentDAO;

@Component
public class StudentService {

	@Autowired
	StudentDAO studentDAO;
	@Autowired
	StopDAO stopDAO;
	
	public StudentInfo getStudentFromReference(String referenceNumber){
		StudentInfo studentInfo = studentDAO.findUniqueByProperty("referencenumber", referenceNumber);
		if(studentInfo!=null){
			return studentInfo;
		}else
			return null;
	}
	

	
	public StudentInfo getStudent(Integer studentId){
		StudentInfo studentInfo = studentDAO.findUniqueByProperty("studentid", studentId);
		if(studentInfo!=null){
			return studentInfo;
		}else
			return null;
	}
	
	public StudentInfo setStop(Integer studentId,Integer stopId){
		StudentInfo studentInfo = studentDAO.findUniqueByProperty("studentid", studentId);
		StopInfo busstopInfo = stopDAO.findUniqueByProperty("stopid", stopId);
		if(studentInfo!=null && busstopInfo!=null){
			studentInfo.setStop(busstopInfo);
			studentDAO.save(studentInfo);
			return studentInfo;
		}else
			return null;
	}
}
