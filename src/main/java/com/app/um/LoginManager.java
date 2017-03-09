package com.app.um;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.requestbean.LoginBean;
import com.app.api.requestbean.RegisterBean;
import com.app.data.beans.UserInfo;
import com.app.data.beans.UserLogin;
import com.app.utility.Utility;

@Component
public class LoginManager {
	
	@Autowired
	LoginService loginService;
	
	public UserInfo authenticateUser(LoginBean loginBean){
		if(!Utility.isEmpty(loginBean.getEmail()) || !Utility.isEmpty(loginBean.getPassword())){
			UserLogin userLogin = loginService.getUserLoginObject(loginBean);
			if(userLogin!=null){
				UserInfo userInfo = userLogin.getUserInfo();
				return userInfo;
			}else{
				return null;
			}
		}else{
			return null;
		} 
	}
	
	public UserInfo registerUser(RegisterBean registerBean){
		if(!Utility.isEmpty(registerBean.getEmail()) || !Utility.isEmpty(registerBean.getPassword())
				|| !Utility.isEmpty(registerBean.getFirstname()) || !Utility.isEmpty(registerBean.getMobile())
				|| !Utility.isEmpty(registerBean.getRole())){
			UserLogin userLogin = loginService.registerUser(registerBean);
			if(userLogin!=null)
				return userLogin.getUserInfo();
			else
				return null;
		}else{
			return null;
		}
	}
	
}
