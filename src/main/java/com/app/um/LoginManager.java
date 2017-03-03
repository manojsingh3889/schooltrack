package com.app.um;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.app.data.beans.Role;
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
			return "success";
		}else{
			return "error";
		} 
	}
	
	public String registerUser(String email, String password, UserInfo userInfo){
		if(userInfo != null && email!=null && password!=null){
			
			return "success";
		}else{
			return "error";
		}
	
	}
	
}
