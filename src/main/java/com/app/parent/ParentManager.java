package com.app.parent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.data.beans.StopInfo;
import com.app.data.beans.RouteInfo;
import com.app.data.beans.RouteTracking;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StudentInfo;
import com.app.data.beans.UserInfo;
import com.app.utility.Utility;

@Component
public class ParentManager {

	@Autowired
	ParentService parentService;
	
	public StudentInfo addStudent(String referenceNumber,Integer userId){
		if(!Utility.isEmpty(referenceNumber)){
			StudentInfo studentInfo = parentService.getStudentFromReference(referenceNumber);
			if(studentInfo!=null){
				UserInfo userInfo = getUserInfo(userId);
				parentService.addUserStudentMap(studentInfo,userInfo);
				return studentInfo;
			}else{
				return null;
			}
		}else
			return null;
	}
	
	public UserInfo getUserInfo(Integer userId){
		if(userId!=null){
			UserInfo userInfo = parentService.getUserInfo(userId);
			if(userInfo!=null){
				return userInfo;
			}else 
				return null;
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
	
	public StopInfo getStop(Integer stopId){
		if(stopId!=null){
			StopInfo busstopInfo = parentService.getStop(stopId);
			if(busstopInfo!=null){
				return busstopInfo;
			}else 
				return null;
		}else
			return null;	
	}
	
	public List<StopInfo> getStops(Integer routeId){
		if(routeId!=null){
			List<StopInfo> busStopInfoList = parentService.getStops(routeId);
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
	
	//for changing and setting stop of student 
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
				StopInfo busstopInfo = studentInfo.getStop();
				//ask how to return
				return studentInfo;
			}else 
				return null;
		}else
			return null;	
	}
}
