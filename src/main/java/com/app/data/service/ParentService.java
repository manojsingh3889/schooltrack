package com.app.data.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.data.beans.StudentInfo;
import com.app.data.beans.UserInfo;
import com.app.data.beans.UserStudentMapping;
import com.app.data.dao.UserStudentDAO;

@Component
public class ParentService {
	
	@Autowired
	UserStudentDAO userStudentDAO;

	public List<UserStudentMapping> getStudentMappingList(UserInfo userInfo) {
		List<UserStudentMapping> userStudentMappingList = userStudentDAO.findByProperty("user", userInfo);
		if(userStudentMappingList!=null){
			return userStudentMappingList;
		}else{
			return null;
		}
	}
	
	
	public UserStudentMapping addUserStudentMap(StudentInfo studentInfo, UserInfo userInfo){
		UserStudentMapping userStudentMapping = new UserStudentMapping();
		userStudentMapping.setStudent(studentInfo);
		userStudentMapping.setUser(userInfo);
		userStudentDAO.save(userStudentMapping);
		return userStudentMapping;
	}
}

