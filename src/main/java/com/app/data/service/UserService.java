package com.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.requestbean.LoginBean;
import com.app.api.requestbean.RegisterBean;
import com.app.data.beans.StudentInfo;
import com.app.data.beans.UserInfo;
import com.app.data.beans.UserLogin;
import com.app.data.beans.UserStudentMapping;
import com.app.data.dao.BaseHibernateDAO;
import com.app.data.dao.UserInfoDAO;
import com.app.data.dao.UserLoginDAO;
import com.app.utility.PasswordUtility;

@Component
public class UserService {

	@Autowired
	UserLoginDAO userLoginDAO;
	
	@Autowired
	UserInfoDAO userInfoDAO;

	//check username and password correct and then return userLogin Object
	public UserLogin getUserLoginObject(LoginBean loginBean) {
		UserLogin userLogin = userLoginDAO.findByEmail(loginBean.getEmail());
		if(userLogin!=null){
			String passwordSalt = userLogin.getPasswordsalt();
			String passwordHash = userLogin.getPasswordhash();
			String password = PasswordUtility.generateMD5(loginBean.getPassword()+passwordSalt);
			if(password.equals(passwordHash)){
				return userLogin;
			}else return null;
		}else{
			return null;
		}
	}


	public UserLogin registerUser(RegisterBean registerBean){
		String email = registerBean.getEmail();
		UserLogin userLogin = userLoginDAO.findByEmail(registerBean.getEmail());
		if(userLogin==null){
			String password = registerBean.getPassword();
			String firstname = registerBean.getFirstname();
			String lastname = registerBean.getLastname();
			//Role role = registerBean.getRole();
			String passwordSalt = PasswordUtility.generatePasswordSalt();
			String passwordHash = PasswordUtility.generateMD5(password+passwordSalt);
			userLogin = new UserLogin(email, passwordHash, passwordSalt);
			UserInfo userInfo = new UserInfo(firstname,lastname);
			userInfoDAO.save(userInfo);
			userLogin.setUserInfo(userInfo);
			userLoginDAO.save(userLogin);
			return userLogin;
		}else{
			return null;
		}
	}

	public UserInfo getUserInfo(Integer userId){
		UserInfo userInfo = userInfoDAO.findById(userId);
		if(userInfo!=null){
			return userInfo;
		}else
			return null;
	}

	/*public static void main(String[] args) {
		LoginService loginService = new LoginService();
		String password = "arpitporwal";
		password = passwordUtility.generateMD5(password);
		loginService.registerUser(password);
	}*/

}
