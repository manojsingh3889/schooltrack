package com.app.um;

import org.springframework.stereotype.Component;

import com.app.data.beans.UserInfo;
import com.app.data.beans.UserLogin;
import com.app.model.RegisterBean;

@Component
public class LoginManager {

	public String authenticateUser(String username,String password){
		if(username!=null && password!=null){
			LoginService loginService = new LoginService();
			UserLogin userLogin = loginService.getUserLoginObject(username,password);
			if(userLogin!=null){
				UserInfo userInfo = userLogin.getUserInfo();
				
			}else{
				return "error";
			}
			return "success";
		}else{
			return "error";
		} 
	}
	
	public String registerUser(RegisterBean registerBean){
		if(registerBean != null){
			return "success";
		}else{
			return "fail";
		}
	
	}
	
}
