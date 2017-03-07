package com.app.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.requestbean.CreatePriviledgeBean;
import com.app.api.requestbean.CreateRoleBean;

@RestController
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	SystemManager systemManager;
	
	@RequestMapping(method=RequestMethod.POST, value = "/create/role")
	public ResponseEntity createRole(@RequestBody CreateRoleBean bean){
		return new ResponseEntity(systemManager.createRole(bean), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/create/priviledge")
	public ResponseEntity createPriviledge(@RequestBody CreatePriviledgeBean bean){
		return new ResponseEntity(systemManager.createPriviledge(bean), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/get/role")
	public ResponseEntity getRoles(){
		return new ResponseEntity(systemManager.getRoles(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/get/role/{id}")
	public ResponseEntity getRole(@PathVariable("id") Integer roleId){
		return new ResponseEntity(systemManager.getRole(roleId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/get/priviledge")
	public ResponseEntity getPriviledges(){
		return new ResponseEntity(systemManager.getPriviledges(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/get/priviledge/{id}")
	public ResponseEntity getPriviledge(@PathVariable("id") Integer priviledgeId){
		return new ResponseEntity(systemManager.getPriviledge(priviledgeId),HttpStatus.OK);
	}
	
}
