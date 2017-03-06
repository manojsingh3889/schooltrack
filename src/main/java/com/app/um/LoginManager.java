package com.app.um;

import org.springframework.stereotype.Component;

import com.app.data.beans.UserInfo;
import com.app.data.beans.UserLogin;
import com.app.model.RegisterBean;

@Component
public class LoginManager {

	public String authenticateUser(String email,String password){
		if(email!=null && password!=null){
			LoginService loginService = new LoginService();
			UserLogin userLogin = loginService.getUserLoginObject(email,password);
			if(userLogin!=null){
				UserInfo userInfo = userLogin.getUserInfo();
			}else{
				return "error";
			}
			return userLogin.toString();
		}else{
			return "error";
		} 
	}
	
	public String registerUser(RegisterBean registerBean){
		if(registerBean!=null){
			LoginService loginService = new LoginService();
			UserLogin userLogin = loginService.registerUser(registerBean);
			if(userLogin!=null)
				return userLogin.toString();
			else
				return "error";
		}else{
			return "error";
		}
	
	}
	
}
