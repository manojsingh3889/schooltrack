package com.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.requestbean.CreateRouteBean;
import com.app.api.requestbean.CreateStopBean;
import com.app.api.requestbean.CreateStudentBean;
import com.app.data.beans.RouteInfo;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StopInfo;
import com.app.data.beans.StudentInfo;
import com.app.data.beans.StudentReference;
import com.app.data.dao.RouteDAO;
import com.app.data.dao.SchoolDAO;
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
	SchoolDAO schoolDAO;

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

	public RouteInfo createRoute(CreateRouteBean bean){
		SchoolInfo schoolInfo = schoolDAO.findById(bean.getSchoolId());
		if(schoolInfo!=null){
			RouteInfo instance = new RouteInfo();
			instance.setRoutenumber(bean.getRoutenumber());
			instance.setSchool(schoolInfo);
			RouteInfo routeInfo = routeDAO.findUniqueByExample(instance);
			if(routeInfo==null){
				RouteInfo info = new RouteInfo();
				info.setRoutenumber(bean.getRoutenumber());
				info.setSeatcapacity(bean.getSeatcapacity());
				info.setRoutearea(bean.getRoutearea());
				info.setBusplatenumber(bean.getBusplatenumber());
				info.setSeatsleft(bean.getSeatsleft());
				info.setSchool(schoolInfo);
				//check how to send default
				info.setTripstatus("STOPPED");
				routeDAO.save(info);
				return info;
			}else
				return null;
		}else
			return null;
	}

	//ask how to save two things else revert
	public StudentInfo createStudent(CreateStudentBean bean){
		RouteInfo routeInfo = routeDAO.findById(bean.getRouteId());
		SchoolInfo schoolInfo = schoolDAO.findById(bean.getSchoolId());
		if(routeInfo!=null && schoolInfo!=null){
			StudentReference reference = studentReferenceDAO.findUniqueByProperty("referencenumber", bean.getReferencenumber());
			StudentInfo instance = new StudentInfo();
			instance.setRegistrationnumber(bean.getRegistrationnumber());
			instance.setSchool(schoolInfo);
			StudentInfo info = studentDAO.findUniqueByExample(instance);
			if(reference==null && info==null){
				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setFirstname(bean.getFirstname());
				studentInfo.setLastname(bean.getLastname());
				studentInfo.setRegistrationnumber(bean.getRegistrationnumber());
				studentInfo.setStudentclass(bean.getStudentclass());
				studentInfo.setStudentsection(bean.getStudentsection());
				studentInfo.setPhoto(bean.getPhoto());
				studentInfo.setRoute(routeInfo);
				studentInfo.setSchool(schoolInfo);
				studentInfo.setReferencenumber(bean.getReferencenumber());
				studentDAO.save(studentInfo);
				StudentReference studentReference = new StudentReference();
				studentReference.setReferencenumber(bean.getReferencenumber());
				studentReference.setStudent(studentInfo);
				studentReferenceDAO.save(studentReference);
				return info;
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
