package com.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.requestbean.CreateStopBean;
import com.app.data.beans.RouteInfo;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StopInfo;
import com.app.data.beans.StudentInfo;
import com.app.data.beans.StudentReference;
import com.app.data.dao.RouteDAO;
import com.app.data.dao.StopDAO;
import com.app.data.dao.StudentDAO;
import com.app.data.dao.StudentReferenceDAO;

@Service
public class AdminService {

	@Autowired
	RouteDAO routeDAO;

	@Autowired
	StopDAO stopDAO;

	@Autowired
	StudentDAO studentDAO;

	@Autowired
	StudentReferenceDAO studentReferenceDAO;

	public List<RouteInfo> getRoutes(Integer schoolId){
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

	public StopInfo createStop(CreateStopBean bean){
		StopInfo stopInfo = new StopInfo();
		stopInfo.setAddress(bean.getAddress());
		stopInfo.setStoplattitude(bean.getLattitude());
		stopInfo.setStoplongitude(bean.getLongitude());
		stopDAO.saveOrUpdate(stopInfo);
		if(stopInfo!=null){
			return stopInfo;
		}else
			return null;
	}

	public RouteInfo createRoute(RouteInfo newRouteInfo){
		RouteInfo info = new RouteInfo();
		info.setRoutenumber(newRouteInfo.getRoutenumber());
		info.setRoutearea(newRouteInfo.getRoutearea());
		info.setSchool(newRouteInfo.getSchool());
		List<RouteInfo> routeInfoList = routeDAO.findByExample(info);
		if(routeInfoList==null){
			routeDAO.save(newRouteInfo);
			return newRouteInfo;
		}else
			return null;
	}

	//ask how to save two things else revert
	public StudentInfo createStudent(StudentInfo newStudentInfo){
		StudentReference newstudentReference = new StudentReference();
		newstudentReference.setReferencenumber(newStudentInfo.getReferencenumber());
		newstudentReference.setStudent(newStudentInfo);
		StudentReference reference = studentReferenceDAO.findUniqueByExample(newstudentReference);
		if(reference==null){
			StudentInfo info = new StudentInfo();
			info.setReferencenumber(newStudentInfo.getReferencenumber());
			info.setRegistrationnumber(newStudentInfo.getRegistrationnumber());
			info.setSchool(newStudentInfo.getSchool());
			StudentInfo studentInfo = studentDAO.findUniqueByExample(info);
			if(studentInfo==null){
				studentDAO.save(newStudentInfo);
				studentReferenceDAO.save(newstudentReference);
				return newStudentInfo;
			}else
				return null;
		}else
			return null;
	}
	
	//ask wht to return on deletes
	/*public void deleteStudent(StudentInfo info){
		StudentInfo studentInfo = studentDAO.findUniqueByExample(info);
		if(studentInfo!=null){
			StudentReference newstudentReference = new StudentReference();
			newstudentReference.setReferencenumber(studentInfo.getReferencenumber());
			newstudentReference.setStudent(studentInfo);
			StudentReference reference = studentReferenceDAO.findUniqueByExample(newstudentReference);
			if(reference!=null){
				studentDAO.delete(studentInfo);
				studentReferenceDAO.delete(newstudentReference);
			}//else
				//return null;
		}//else
			//return null;
	}*/

}
