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
import com.app.um.LoginManager;


@RestController
@RequestMapping("/um")
public class UserMgmtController {

	@Autowired
	private LoginManager loginmanager;
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity login(@RequestBody LoginBean bean) {
		return new ResponseEntity(loginmanager.authenticateUser(bean.getEmail(), bean.getPassword()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public ResponseEntity register(@RequestBody RegisterBean bean){
		return new ResponseEntity(loginmanager.registerUser(bean), HttpStatus.OK);
	}
}
