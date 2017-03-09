package com.app.parent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.data.beans.BusstopInfo;
import com.app.data.beans.BusstopRouteMapping;
import com.app.data.beans.RouteInfo;
import com.app.data.beans.RouteTracking;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StudentInfo;
import com.app.data.beans.StudentReferenceMapping;
import com.app.data.dao.BaseHibernateDAO;

@Component
public class ParentService {

	@Autowired
	BaseHibernateDAO<StudentReferenceMapping> studentReferenceBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<StudentInfo> studentBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<RouteInfo> routeBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<SchoolInfo> schoolBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<BusstopRouteMapping> busstopRouteBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<BusstopInfo> busstopBaseHibernateDAO;
	
	@Autowired
	BaseHibernateDAO<RouteTracking> routeTrackingBaseHibernateDAO;
	
	public StudentInfo getStudentFromReference(String referenceNumber){
		StudentReferenceMapping referenceMapping = studentReferenceBaseHibernateDAO.findUniqueByProperty("referencenumber", referenceNumber);
		if(referenceMapping!=null){
			return referenceMapping.getStudent();
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
	
	public BusstopInfo getStop(Integer stopId){
		BusstopInfo busstopInfo = busstopBaseHibernateDAO.findUniqueByProperty("stopid", stopId);
		if(busstopInfo!=null){
			return busstopInfo;
		}else
			return null;
	}
	
	public List<BusstopInfo> getStops(Integer routeId){
		List<BusstopRouteMapping> BusstopRouteMappingList = busstopRouteBaseHibernateDAO.findByProperty("routeId", routeId);
		if(BusstopRouteMappingList!=null){
			List<BusstopInfo> busstopInfoList = new ArrayList<BusstopInfo>();
			for(BusstopRouteMapping routeMapping : BusstopRouteMappingList){
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
		BusstopInfo busstopInfo = busstopBaseHibernateDAO.findUniqueByProperty("stopid", stopId);
		if(studentInfo!=null && busstopInfo!=null){
			studentInfo.setStop(busstopInfo);
			return studentInfo;
		}else
			return null;
	}
	
}