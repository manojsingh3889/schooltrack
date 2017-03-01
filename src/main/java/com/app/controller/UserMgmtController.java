package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.LoginBean;
import com.app.model.RegisterBean;
import com.app.um.LoginService;


@RestController
@RequestMapping("/um")
public class UserMgmtController {

	@Autowired
	private LoginService loginservice;
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity login(@RequestBody LoginBean bean) {
		return new ResponseEntity(loginservice.authenticateUser(bean.getUsername(), bean.getPassword()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public ResponseEntity login(@RequestBody RegisterBean bean){
		return new ResponseEntity(loginservice.registerUser(bean), HttpStatus.OK);
	}
}
