package com.app.parent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.data.beans.StopInfo;
import com.app.data.beans.StopRouteMapping;
import com.app.data.beans.RouteInfo;
import com.app.data.beans.RouteTracking;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StudentInfo;
import com.app.data.beans.UserInfo;
import com.app.data.beans.UserStudentMapping;
import com.app.data.dao.BaseHibernateDAO;

@Component
public class ParentService {
	
	@Autowired
	BaseHibernateDAO<StudentInfo> studentBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<RouteInfo> routeBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<SchoolInfo> schoolBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<StopRouteMapping> stopRouteBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<StopInfo> stopBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<RouteTracking> routeTrackingBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<UserStudentMapping> userStudentBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<UserInfo> userBaseHibernateDAO;
	
	public StudentInfo getStudentFromReference(String referenceNumber){
		StudentInfo studentInfo = studentBaseHibernateDAO.findUniqueByProperty("referencenumber", referenceNumber);
		if(studentInfo!=null){
			return studentInfo;
		}else
			return null;
	}
	
	public UserInfo getUserInfo(Integer userId){
		UserInfo userInfo = userBaseHibernateDAO.findUniqueByProperty("userid", userId);
		if(userInfo!=null){
			return userInfo;
		}else
			return null;
	}
	
	public StudentInfo getStudent(Integer studentId){
		StudentInfo studentInfo = studentBaseHibernateDAO.findUniqueByProperty("studentid", studentId);
		if(studentInfo!=null){
			return studentInfo;
		}else
			return null;
	}
	
	public RouteInfo getRoute(Integer routeId){
		RouteInfo routeInfo = routeBaseHibernateDAO.findUniqueByProperty("routeid", routeId);
		if(routeInfo!=null){
			return routeInfo;
		}else
			return null;
	}
	
	public SchoolInfo getSchool(Integer schoolId){
		SchoolInfo schoolInfo = schoolBaseHibernateDAO.findUniqueByProperty("schoolId", schoolId);
		if(schoolInfo!=null){
			return schoolInfo;
		}else
			return null;
	}
	
	public StopInfo getStop(Integer stopId){
		StopInfo busstopInfo = stopBaseHibernateDAO.findUniqueByProperty("stopid", stopId);
		if(busstopInfo!=null){
			return busstopInfo;
		}else
			return null;
	}
	
	public List<StopInfo> getStops(Integer routeId){
		List<StopRouteMapping> BusstopRouteMappingList = stopRouteBaseHibernateDAO.findByProperty("routeId", routeId);
		if(BusstopRouteMappingList!=null){
			List<StopInfo> busstopInfoList = new ArrayList<StopInfo>();
			for(StopRouteMapping routeMapping : BusstopRouteMappingList){
				busstopInfoList.add(routeMapping.getStop());
			}
			return busstopInfoList;
		}else
			return null;
	}
	
	public RouteTracking getCurrentLocation(Integer routeId){
		RouteTracking routeTracking = routeTrackingBaseHibernateDAO.findUniqueByProperty("routeid", routeId);
		if(routeTracking!=null){
			return routeTracking;
		}else
			return null;
	}
	
	public StudentInfo setStop(Integer studentId,Integer stopId){
		StudentInfo studentInfo = studentBaseHibernateDAO.findUniqueByProperty("studentid", studentId);
		StopInfo busstopInfo = stopBaseHibernateDAO.findUniqueByProperty("stopid", stopId);
		if(studentInfo!=null && busstopInfo!=null){
			studentInfo.setStop(busstopInfo);
			return studentInfo;
		}else
			return null;
	}
	
	public UserStudentMapping addUserStudentMap(StudentInfo studentInfo, UserInfo userInfo){
		UserStudentMapping userStudentMapping = new UserStudentMapping();
		userStudentMapping.setStudent(studentInfo);
		userStudentMapping.setUser(userInfo);
		userStudentBaseHibernateDAO.save(userStudentMapping);
		return userStudentMapping;
	}
}
