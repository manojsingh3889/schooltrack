package com.app.um;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.requestbean.LoginBean;
import com.app.api.requestbean.RegisterBean;
import com.app.data.beans.Role;
import com.app.data.beans.StudentInfo;
import com.app.data.beans.UserInfo;
import com.app.data.beans.UserLogin;
import com.app.data.beans.UserStudentMapping;
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
				Role role = userInfo.getRole();
				if("parent".equalsIgnoreCase(role.getCodeName())){
					List<UserStudentMapping> userStudentMappingList = loginService.getStudentMappingList(userInfo);
					if(userStudentMappingList!=null){
						List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
						for(UserStudentMapping studentMapping : userStudentMappingList){
							studentInfoList.add(studentMapping.getStudent());
						}
						//ask how to return with studentList
						return userInfo;
					}else
						return userInfo;
				}else if("handler".equalsIgnoreCase(role.getCodeName())){
					
				}else if("admin".equalsIgnoreCase(role.getCodeName())){
					
				}else if("system".equalsIgnoreCase(role.getCodeName())){
					
				}
				
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
