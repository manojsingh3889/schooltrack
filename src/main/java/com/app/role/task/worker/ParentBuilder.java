package com.app.role.task.worker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.data.beans.ParentInfo;
import com.app.data.beans.StudentInfo;
import com.app.data.beans.UserInfo;
import com.app.data.beans.UserStudentMapping;
import com.app.role.task.RoleBeanBuilder;
import com.app.utility.GenericLogger;
import  com.app.data.service.ParentService;


public class ParentBuilder extends RoleBeanBuilder {

	@Autowired
	ParentService parentService;

	@Override
	public UserInfo build(UserInfo userInfo) {
		GenericLogger.log.info("inside parent builder");
		ParentInfo info = null;
		
		List<UserStudentMapping> userStudentMappingList = parentService.getStudentMappingList(userInfo);
		if(userStudentMappingList!=null){
			List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
			for(UserStudentMapping studentMapping : userStudentMappingList){
				studentInfoList.add(studentMapping.getStudent());
			}
			info = new ParentInfo(userInfo.getUserid(),userInfo.getFirstname(), userInfo.getLastname(),userInfo.getRole(), studentInfoList);
		}
		
		return info;
	}
}
