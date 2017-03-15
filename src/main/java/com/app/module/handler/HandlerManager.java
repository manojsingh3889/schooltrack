package com.app.module.handler;

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.requestbean.LocationTrackingBean;
import com.app.data.beans.HandlerInfo;
import com.app.data.beans.RouteInfo;
import com.app.data.beans.RouteTracking;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StopInfo;
import com.app.data.beans.StudentInfo;
import com.app.data.service.HandlerService;
import com.app.data.service.LocationService;
import com.app.data.service.StudentService;
import com.app.utility.Utility;

@Service
public class HandlerManager {
	
	@Autowired
	HandlerService handlerService;
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	StudentService studentService;
	
	public List<StudentInfo> getStudents(Integer routeId,Integer schoolId){
		if(routeId!=null){
			List<StudentInfo> studentInfoList = handlerService.getStudents(routeId,schoolId);
			if(studentInfoList!=null){
				return studentInfoList;
			}else 
				return null;
		}else
			return null;
	}
	
	public TreeMap<Integer, StopInfo> getStops(Integer routeId){
		if(routeId!=null){
			TreeMap<Integer, StopInfo> busStopInfoMap = locationService.getStops(routeId);
			if(busStopInfoMap!=null){
				return busStopInfoMap;
			}else 
				return null;
		}else
			return null;
	}
	
	public HandlerInfo getHandler(Integer handlerId){
		if(handlerId!=null){
			HandlerInfo handlerInfo = handlerService.getHandler(handlerId);
			if(handlerInfo!=null){
				return handlerInfo;
			}else 
				return null;
		}else
			return null;
	}
	
	public RouteInfo getRoute(Integer routeId){
		if(routeId!=null){
			RouteInfo routeInfo = locationService.getRoute(routeId);
			if(routeInfo!=null){
				return routeInfo;
			}else 
				return null;
		}else
			return null;	
	}
	
	public SchoolInfo getSchool(Integer schoolId){
		if(schoolId!=null){
			SchoolInfo schoolInfo = locationService.getSchool(schoolId);
			if(schoolInfo!=null){
				return schoolInfo;
			}else 
				return null;
		}else
			return null;	
	}
	
	public StopInfo getStop(Integer stopId){
		if(stopId!=null){
			StopInfo busstopInfo = locationService.getStop(stopId);
			if(busstopInfo!=null){
				return busstopInfo;
			}else 
				return null;
		}else
			return null;	
	}
	
	public StudentInfo getAllInfo(Integer studentId){
		if(studentId!=null){
			StudentInfo studentInfo = studentService.getStudent(studentId);
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
	
	public RouteTracking setCurrentLocation(LocationTrackingBean bean){
		if(bean.getRouteId()!=null || bean.getLattitude()!=null || bean.getLongitutde()!=null){
			RouteTracking routeTracking = locationService.setCurrentLocation(bean);
			if(routeTracking!=null){
				return routeTracking;
			}else 
				return null;
		}else
			return null;	
	}
	
	public RouteInfo updateTripStatus(Integer routeId,String tripStatus){
		if(!Utility.isEmpty(tripStatus) && routeId!=null){
			RouteInfo routeInfo = locationService.updateTripStatus(routeId,tripStatus);
			if(routeInfo!=null)
				return routeInfo;
			else
				return null;
		}else
			return null;
	}
	
	/*public List<RouteInfo> getRoutes(Integer schoolId){
		if(schoolId!=null){
			List<RouteInfo> routeInfoList = handlerService.getRoutes(schoolId);
			if(routeInfoList!=null){
				return routeInfoList;
			}else 
				return null;
		}else
			return null;
	}
	
	public HandlerInfo setRoute(Integer handlerId, Integer routeId){
		if(handlerId!=null && routeId!=null){
			HandlerInfo handlerInfo = handlerService.setRoute(handlerId,routeId);
			if(handlerInfo!=null){
				return handlerInfo;
			}else 
				return null;
		}else
			return null;
	}*/
	
}
