package com.app.um;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.requestbean.LoginBean;
import com.app.api.requestbean.RegisterBean;
import com.app.data.beans.UserInfo;
import com.app.data.beans.UserLogin;

@Component
public class LoginManager {
	
	@Autowired
	LoginService loginService;
	
	public String authenticateUser(LoginBean loginBean){
		if(loginBean!=null){
			UserLogin userLogin = loginService.getUserLoginObject(loginBean);
			if(userLogin!=null){
				UserInfo userInfo = userLogin.getUserInfo();
				return userInfo.toString();
			}else{
				return "error";
			}
		}else{
			return "error";
		} 
	}
	
	public String registerUser(RegisterBean registerBean){
		if(registerBean!=null){
			UserLogin userLogin = loginService.registerUser(registerBean);
			if(userLogin!=null)
				return userLogin.getUserInfo().toString();
			else
				return "error";
		}else{
			return "error";
		}
	}
	
}
