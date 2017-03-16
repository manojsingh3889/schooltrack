package com.app.module.admin;

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.requestbean.CreateStopBean;
import com.app.data.beans.RouteInfo;
import com.app.data.beans.RouteTracking;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StopInfo;
import com.app.data.beans.StudentInfo;
import com.app.data.beans.UserInfo;
import com.app.data.service.AdminService;
import com.app.data.service.HandlerService;
import com.app.data.service.LocationService;
import com.app.data.service.ParentService;
import com.app.data.service.StudentService;
import com.app.data.service.UserService;
import com.app.utility.Utility;

@Service
public class AdminManager {
	
	@Autowired
	HandlerService handlerService;

	@Autowired
	ParentService parentService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	AdminService adminService;
	
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
	
	public UserInfo getUserInfo(Integer userId){
		if(userId!=null){
			UserInfo userInfo = userService.getUserInfo(userId);
			if(userInfo!=null){
				return userInfo;
			}else 
				return null;
		}else
			return null;
	}
	
	public StudentInfo getStudent(Integer studentId){
		if(studentId!=null){
			StudentInfo studentInfo = studentService.getStudent(studentId);
			if(studentInfo!=null){
				return studentInfo;
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
	
	public RouteTracking getCurrentLocation(Integer routeId){
		if(routeId!=null){
			RouteTracking routeTracking = locationService.getCurrentLocation(routeId);
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
			StudentInfo studentInfo = studentService.setStop(studentId,stopId);
			if(studentInfo!=null){
				return studentInfo;
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
	
	public List<RouteInfo> getRoutes(Integer schoolId){
		if(schoolId!=null){
			List<RouteInfo> routeInfoList = adminService.getRoutes(schoolId);
			if(routeInfoList!=null){
				return routeInfoList;
			}else 
				return null;
		}else
			return null;
	}
	
	public StopInfo createStop(CreateStopBean bean){
		if(!Utility.isEmpty(bean.getLattitude()) && !Utility.isEmpty(bean.getLongitude()) && !Utility.isEmpty(bean.getAddress())){
			StopInfo stopInfo = adminService.createStop(bean);
			if(stopInfo!=null){
				return stopInfo;
			}else 
				return null;
		}else
			return null;
	}
	
	public RouteInfo createRoute(RouteInfo info){
		if(!Utility.isEmpty(info.getRoutenumber()) && info.getSchool()!=null && !Utility.isEmpty(info.getRoutearea())){
			RouteInfo routeInfo = adminService.createRoute(info);
			if(routeInfo!=null){
				return routeInfo;
			}else 
				return null;
		}else
			return null;
	}
	
	public StudentInfo createStudent(StudentInfo info){
		if(!Utility.isEmpty(info.getRegistrationnumber()) && info.getSchool()!=null && !Utility.isEmpty(info.getReferencenumber())
				&& !Utility.isEmpty(info.getFirstname()) && !Utility.isEmpty(info.getStudentclass()) &&
				!Utility.isEmpty(info.getStudentsection())){
			StudentInfo studentInfo = adminService.createStudent(info);
			if(studentInfo!=null){
				return studentInfo;
			}else 
				return null;
		}else
			return null;
	}
	
	/*public StudentInfo deleteStudent(StudentInfo info){
		if(!Utility.isEmpty(info.getStudentid())){
			StudentInfo studentInfo = adminService.deleteStudent(info);
			if(studentInfo!=null){
				return studentInfo;
			}else 
				return null;
		}else
			return null;
	}*/
}
