package com.app.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.requestbean.CreateRoleBean;
import com.app.system.SystemManager;

@RestController
@RequestMapping("/handler")
public class HandlerController {

	@Autowired
	HandlerManager handlerManager;
	
	/*@RequestMapping(method=RequestMethod.POST, value = "/getStudents")
	public ResponseEntity getStudents(@RequestBody CreateRoleBean bean){
		return new ResponseEntity(handlerManager.getStudents(bean), HttpStatus.OK);
	}*/
	
}
