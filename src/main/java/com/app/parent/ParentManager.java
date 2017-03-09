package com.app.parent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.data.beans.BusstopInfo;
import com.app.data.beans.RouteInfo;
import com.app.data.beans.RouteTracking;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StudentInfo;
import com.app.utility.Utility;

@Component
public class ParentManager {

	@Autowired
	ParentService parentService;
	
	public StudentInfo addStudent(String referenceNumber){
		if(!Utility.isEmpty(referenceNumber)){
			StudentInfo studentInfo = parentService.getStudentFromReference(referenceNumber);
			if(studentInfo!=null){
				return studentInfo;
			}else{
				return null;
			}
		}else
			return null;
	}
	
	public StudentInfo getStudent(Integer studentId){
		if(studentId!=null){
			StudentInfo studentInfo = parentService.getStudent(studentId);
			if(studentInfo!=null){
				return studentInfo;
			}else 
				return null;
		}else
			return null;
	}
	
	public RouteInfo getRoute(Integer routeId){
		if(routeId!=null){
			RouteInfo routeInfo = parentService.getRoute(routeId);
			if(routeInfo!=null){
				return routeInfo;
			}else 
				return null;
		}else
			return null;	
	}
	
	public SchoolInfo getSchool(Integer schoolId){
		if(schoolId!=null){
			SchoolInfo schoolInfo = parentService.getSchool(schoolId);
			if(schoolInfo!=null){
				return schoolInfo;
			}else 
				return null;
		}else
			return null;	
	}
	
	public BusstopInfo getStop(Integer stopId){
		if(stopId!=null){
			BusstopInfo busstopInfo = parentService.getStop(stopId);
			if(busstopInfo!=null){
				return busstopInfo;
			}else 
				return null;
		}else
			return null;	
	}
	
	public List<BusstopInfo> getStops(Integer routeId){
		if(routeId!=null){
			List<BusstopInfo> busStopInfoList = parentService.getStops(routeId);
			if(busStopInfoList!=null){
				return busStopInfoList;
			}else 
				return null;
		}else
			return null;
	}
	
	public RouteTracking getCurrentLocation(Integer routeId){
		if(routeId!=null){
			RouteTracking routeTracking = parentService.getCurrentLocation(routeId);
			if(routeTracking!=null){
				return routeTracking;
			}else 
				return null;
		}else
			return null;
	}
	
	public StudentInfo setStop(Integer studentId,Integer stopId){
		if(studentId!=null && stopId!=null){
			StudentInfo studentInfo = parentService.setStop(studentId,stopId);
			if(studentInfo!=null){
				return studentInfo;
			}else 
				return null;
		}else
			return null;	
	}
	
	public StudentInfo getAllInfo(Integer studentId){
		if(studentId!=null){
			StudentInfo studentInfo = parentService.getStudent(studentId);
			if(studentInfo!=null){
				RouteInfo routeInfo = studentInfo.getRoute();
				SchoolInfo schoolInfo = studentInfo.getSchool();
				BusstopInfo busstopInfo = studentInfo.getStop();
				return studentInfo;
			}else 
				return null;
		}else
			return null;	
	}
}
