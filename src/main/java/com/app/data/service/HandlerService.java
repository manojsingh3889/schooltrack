package com.app.data.service;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.data.beans.HandlerInfo;
import com.app.data.beans.RouteInfo;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StudentInfo;
import com.app.data.dao.HandlerInfoDAO;
import com.app.data.dao.RouteDAO;
import com.app.data.dao.StudentDAO;

@Service
public class HandlerService {

	@Autowired
	StudentDAO studentDAO;

	@Autowired
	RouteDAO routeDAO;
	
	@Autowired
	HandlerInfoDAO handlerInfoDAO;

	public List<StudentInfo> getStudents(Integer routeId,Integer schoolId){
		RouteInfo routeInfo = new RouteInfo();
		routeInfo.setRouteid(routeId);
		SchoolInfo schoolInfo = new SchoolInfo();
		schoolInfo.setSchoolid(schoolId);
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setRoute(routeInfo);
		studentInfo.setSchool(schoolInfo);
		List<StudentInfo> studentInfoList = studentDAO.findByExample(studentInfo);
		if(studentInfoList!=null){
			return studentInfoList;
		}else
			return null;
	}

	public HandlerInfo getHandler(Integer handlerId){
		HandlerInfo handlerInfo = handlerInfoDAO.findById(handlerId);
		if(handlerInfo!=null)
			return handlerInfo;
		else
			return null;
	}
	/*public List<RouteInfo> getRoutes(Integer schoolId){
		SchoolInfo schoolInfo = new SchoolInfo();
		schoolInfo.setSchoolid(schoolId);
		RouteInfo routeInfo = new RouteInfo();
		routeInfo.setSchool(schoolInfo);
		List<RouteInfo> routeInfoList = routeDAO.findByExample(routeInfo);
		if(routeInfoList!=null){
			return routeInfoList;
		}else
			return null;
	}


	public HandlerInfo setRoute(Integer handlerId, Integer routeId){
		HandlerInfo handlerInfo = handlerInfoDAO.findById(handlerId);
		RouteInfo routeInfo = routeDAO.findById(routeId);
		handlerInfo.setRoute(routeInfo);
		handlerInfoDAO.save(handlerInfo);
		return handlerInfo;
	}*/

}
