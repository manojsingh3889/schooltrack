package com.app.um;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.requestbean.LoginBean;
import com.app.api.requestbean.RegisterBean;


@RestController
@RequestMapping("/um")
public class LoginController{

	@Autowired
	private LoginManager loginmanager;
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity login(@RequestBody LoginBean bean) {
		return new ResponseEntity(loginmanager.authenticateUser(bean), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public ResponseEntity register(@RequestBody RegisterBean bean){
		return new ResponseEntity(loginmanager.registerUser(bean), HttpStatus.OK);
	}
}
