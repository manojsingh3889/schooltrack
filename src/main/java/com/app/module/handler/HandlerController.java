package com.app.module.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.requestbean.LocationTrackingBean;

@RestController
@RequestMapping("/handler")
public class HandlerController {

	@Autowired
	HandlerManager handlerManager;
	
	@RequestMapping(method=RequestMethod.GET, value = "/getStudents/{routeId}/{schoolId}")
	public ResponseEntity getStudents(@PathVariable Integer routeId, @PathVariable Integer studentId){
		return new ResponseEntity(handlerManager.getStudents(routeId,studentId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllStops/{routeId}")
	public ResponseEntity getStops(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(handlerManager.getStops(routeId),HttpStatus.OK);
	}
	
	/*@RequestMapping(method=RequestMethod.GET,value="/getAllRoutes/{schoolId}")
	public ResponseEntity getRoutes(@PathVariable("schoolId") Integer schoolId){
		return new ResponseEntity(handlerManager.getRoutes(schoolId),HttpStatus.OK);
	}*/
	
	@RequestMapping(method=RequestMethod.GET,value="/getHandlerInfo/{handlerId}")
	public ResponseEntity getHandlerInfo(@PathVariable("handlerId") Integer handlerId){
		return new ResponseEntity(handlerManager.getHandler(handlerId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getRouteInfo/{routeId}")
	public ResponseEntity getRoute(@PathVariable("routeId") Integer routeId){
		return new ResponseEntity(handlerManager.getRoute(routeId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getSchoolInfo/{schoolId}")
	public ResponseEntity getSchool(@PathVariable("schoolId") Integer schoolId){
		return new ResponseEntity(handlerManager.getSchool(schoolId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getStopInfo/{stopId}")
	public ResponseEntity getStop(@PathVariable("stopId") Integer stopId){
		return new ResponseEntity(handlerManager.getStop(stopId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllInfo/{studentId}")
	public ResponseEntity getAllInfo(@PathVariable("studentId") Integer studentId){
		return new ResponseEntity(handlerManager.getAllInfo(studentId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/updateTripStatus/{routeId}/{tripStatus}")
	public ResponseEntity updateTripStatus(@PathVariable("routeId") Integer routeId, @PathVariable("tripStatus") String tripStatus){
		return new ResponseEntity(handlerManager.updateTripStatus(routeId,tripStatus),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getCurrentLocation/{routeId}")
	public ResponseEntity setCurrentLocation(@PathVariable("routeId") LocationTrackingBean bean){
		return new ResponseEntity(handlerManager.setCurrentLocation(bean),HttpStatus.OK);
	}
	/*@RequestMapping(method=RequestMethod.POST,value="/setRoute")
	public ResponseEntity setRoute(@RequestBody Integer handlerId,@RequestBody Integer routeId){
		return new ResponseEntity(handlerManager.setRoute(handlerId,routeId),HttpStatus.OK);
	}*/
	
}
