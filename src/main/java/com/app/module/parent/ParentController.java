package com.app.module.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping("/parent")
public class ParentController {
	
	@Autowired
	ParentManager parentManager;
	
	//ask how to send data in body
	@RequestMapping(method=RequestMethod.POST,value="/addstudent")
	public ResponseEntity addStudent(@RequestBody String referenceNumber,@RequestBody Integer userId){
		return new ResponseEntity(parentManager.addStudent(referenceNumber,userId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getStudentInfo/{studentId}")
	public ResponseEntity getStudent(@PathVariable("studentId") Integer studentId){
		return new ResponseEntity(parentManager.getStudent(studentId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getRouteInfo/{routeId}")
	public ResponseEntity getRoute(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(parentManager.getRoute(routeId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getSchoolInfo/{schoolId}")
	public ResponseEntity getSchool(@PathVariable("schoolId") Integer schoolId){
		return new ResponseEntity(parentManager.getSchool(schoolId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getStopInfo/{stopId}")
	public ResponseEntity getStop(@PathVariable("stopId") Integer stopId){
		return new ResponseEntity(parentManager.getStop(stopId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllStops/{routeId}")
	public ResponseEntity getStops(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(parentManager.getStops(routeId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getCurrentLocation/{routeId}")
	public ResponseEntity getCurrentLocation(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(parentManager.getCurrentLocation(routeId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/updateStop")
	public ResponseEntity setStop(@RequestBody Integer studentId,@RequestBody Integer stopId){
		return new ResponseEntity(parentManager.setStop(studentId,stopId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllInfo/{studentId}")
	public ResponseEntity getAllInfo(@PathVariable("studentId") Integer studentId){
		return new ResponseEntity(parentManager.getAllInfo(studentId),HttpStatus.OK);
	}
	
}
