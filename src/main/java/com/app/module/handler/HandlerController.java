package com.app.module.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
