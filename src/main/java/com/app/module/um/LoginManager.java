package com.app.module.um;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.requestbean.ChangePasswordBean;
import com.app.api.requestbean.LoginBean;
import com.app.api.requestbean.RegisterBean;
import com.app.data.beans.Role;
import com.app.data.beans.UserInfo;
import com.app.data.beans.UserLogin;
import com.app.data.service.ParentService;
import com.app.data.service.UserService;
import com.app.role.task.RoleBeanBuilder;
import com.app.role.task.WorkerRepo;
import com.app.utility.Utility;

@Component
public class LoginManager {
	
	@Autowired
	UserService loginService;
	
	@Autowired
	ParentService parentService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	WorkerRepo workerRepo;
	
	public UserInfo authenticateUser(LoginBean loginBean){
		if(!Utility.isEmpty(loginBean.getEmail()) || !Utility.isEmpty(loginBean.getPassword())){
			UserLogin userLogin = loginService.getUserLoginObject(loginBean);
			if(userLogin!=null){
				UserInfo userInfo = userLogin.getUserInfo();
				
				if(userInfo.getRole() !=null){
					Role role = userInfo.getRole();
					
					try {
						String workerName = role.getTaskWorkerMaps().get(RoleBeanBuilder.class.getSimpleName());
						RoleBeanBuilder beanBuilder = workerRepo.getWorker(workerName);
						userInfo = beanBuilder.build(userInfo);
//						System.err.println(beanBuilder);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
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
	
	public UserLogin updatePassword(ChangePasswordBean bean){
		if(!Utility.isEmpty(bean.getUserid()) || !Utility.isEmpty(bean.getNewPassword()) || !Utility.isEmpty(bean.getOldPassword())){
			UserLogin userLogin= userService.updatePassword(bean);
			if(userLogin!=null){
				return userLogin;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
}
