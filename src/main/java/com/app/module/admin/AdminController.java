package com.app.module.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.requestbean.CreateRouteBean;
import com.app.api.requestbean.CreateStopBean;
import com.app.api.requestbean.CreateStudentBean;
import com.app.data.beans.RouteInfo;
import com.app.data.beans.StudentInfo;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminManager adminManager;
	
	@RequestMapping(method=RequestMethod.GET, value = "/getStudents/{routeId}/{schoolId}")
	public ResponseEntity getStudents(@PathVariable Integer routeId, @PathVariable Integer schoolId){
		return new ResponseEntity(adminManager.getStudents(routeId,schoolId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getStudentInfo/{studentId}")
	public ResponseEntity getStudent(@PathVariable("studentId") Integer studentId){
		return new ResponseEntity(adminManager.getStudent(studentId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getRouteInfo/{routeId}")
	public ResponseEntity getRoute(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(adminManager.getRoute(routeId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getSchoolInfo/{schoolId}")
	public ResponseEntity getSchool(@PathVariable("schoolId") Integer schoolId){
		return new ResponseEntity(adminManager.getSchool(schoolId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getStopInfo/{stopId}")
	public ResponseEntity getStop(@PathVariable("stopId") Integer stopId){
		return new ResponseEntity(adminManager.getStop(stopId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllStops/{routeId}")
	public ResponseEntity getStops(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(adminManager.getStops(routeId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getCurrentLocation/{routeId}")
	public ResponseEntity getCurrentLocation(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(adminManager.getCurrentLocation(routeId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/updateStop")
	public ResponseEntity setStop(@RequestBody Integer studentId,@RequestBody Integer stopId){
		return new ResponseEntity(adminManager.setStop(studentId,stopId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllInfo/{studentId}")
	public ResponseEntity getAllInfo(@PathVariable("studentId") Integer studentId){
		return new ResponseEntity(adminManager.getAllInfo(studentId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllRoutes/{schoolId}")
	public ResponseEntity getRoutes(@PathVariable("schoolId") Integer schoolId){
		return new ResponseEntity(adminManager.getRoutes(schoolId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/createStop")
	public ResponseEntity createStop(@RequestBody CreateStopBean bean){
		return new ResponseEntity(adminManager.createStop(bean),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/createRoute")
	public ResponseEntity createRoute(@RequestBody CreateRouteBean bean){
		return new ResponseEntity(adminManager.createRoute(bean),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/createStudent")
	public ResponseEntity createStudent(@RequestBody CreateStudentBean bean){
		return new ResponseEntity(adminManager.createStudent(bean),HttpStatus.OK);
	}
	
	/*@RequestMapping(method=RequestMethod.POST,value="/deleteStudent")
	public ResponseEntity deleteStudent(@RequestBody StudentInfo studentInfo){
		return new ResponseEntity(adminManager.deleteStudent(studentInfo),HttpStatus.OK);
	}*/
}
