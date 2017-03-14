package com.app.module.parent;

import java.util.HashMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.data.beans.StopInfoPriorityBean;
import com.app.data.dao.StopRouteDAO;

@Component
@RequestMapping("/parent")
public class ParentController {
	
	@Autowired
	ParentManager parentManager;
	
	@Autowired
	StopInfoPriorityBean stopInfoPriorityBean;
	
	@RequestMapping(method=RequestMethod.POST,value="/addstudent/{referenceNumber}/{userId}")
	public ResponseEntity addStudent(@PathVariable("referenceNumber") String referenceNumber
			,@PathVariable("userId") Integer userId){
		return new ResponseEntity(parentManager.addStudent(referenceNumber,userId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getStudentInfo/{studentId}")
	public ResponseEntity getStudent(@PathVariable("studentId") Integer studentId){
		return new ResponseEntity(parentManager.getStudent(studentId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getRouteInfo/{routeId}")
	public ResponseEntity getRoute(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(parentManager.getRoute(routeId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getSchoolInfo/{schoolId}")
	public ResponseEntity getSchool(@PathVariable("schoolId") Integer schoolId){
		return new ResponseEntity(parentManager.getSchool(schoolId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getStopInfo/{stopId}")
	public ResponseEntity getStop(@PathVariable("stopId") Integer stopId){
		return new ResponseEntity(parentManager.getStop(stopId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getAllStops/{routeId}")
	public ResponseEntity getStops(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(parentManager.getStops(routeId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getCurrentLocation/{routeId}")
	public ResponseEntity getCurrentLocation(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(parentManager.getCurrentLocation(routeId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/updateStop/{studentId}/{stopId}")
	public ResponseEntity setStop(@PathVariable("studentId") Integer studentId,
			@PathVariable("stopId") Integer stopId){
		return new ResponseEntity(parentManager.setStop(studentId,stopId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/selectStop/{studentId}")
	public ResponseEntity getAllInfo(@PathVariable("studentId") Integer studentId){
		return new ResponseEntity(parentManager.getAllInfo(studentId),HttpStatus.OK);
	}
	
	/*@RequestMapping(method=RequestMethod.POST,value="/getDistance/{bus}/{currentStop}/{nextcallTime}/{stopPriorityMap}")
	public ResponseEntity getAllInfo(@PathVariable("bus") String bus,
			@PathVariable("currentStop") String currentStop, @PathVariable("nextcallTime") Integer nextcallTime,
			@PathVariable("stopPriorityMap") TreeMap<Integer, StopInfoPriorityBean> stopPriorityMap){
		return new ResponseEntity(parentManager.getDistance(bus,currentStop,nextcallTime,stopPriorityMap),HttpStatus.OK);
	}*/
}
