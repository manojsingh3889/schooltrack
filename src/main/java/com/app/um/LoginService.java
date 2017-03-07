package com.app.um;

import com.app.data.beans.Role;
import com.app.data.beans.UserInfo;
import com.app.data.beans.UserLogin;
import com.app.data.dao.UserInfoDAO;
import com.app.data.dao.UserLoginDAO;
import com.app.model.RegisterBean;
import com.app.utility.passwordUtility;


public class LoginService {

	//check username and password correct and then return userLogin Object
	public UserLogin getUserLoginObject(String email,String password) {
		UserLoginDAO userLoginDAO = new UserLoginDAO();
		UserLogin userLogin = (UserLogin) userLoginDAO.findByEmail(email);
		if(userLogin!=null){
			String passwordSalt = userLogin.getPasswordsalt();
			String passwordHash = userLogin.getPasswordhash();
			password = passwordUtility.generateMD5(password+passwordSalt);
			if(password.equals(passwordHash)){
				return userLogin;
			}else return null;
		}else{
			return null;
		}
	}

	public UserLogin registerUser(RegisterBean registerBean){
		String email = registerBean.getEmail();
		UserLoginDAO userLoginDAO = new UserLoginDAO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserLogin userLogin = (UserLogin) userLoginDAO.findByEmail(email);
		if(userLogin==null){
		
			String password = registerBean.getPassword();
			String firstname = registerBean.getFirstname();
			String lastname = registerBean.getLastname();
			//Role role = registerBean.getRole();
			String passwordSalt = passwordUtility.generatePasswordSalt();
			String passwordHash = passwordUtility.generateMD5(password+passwordSalt);
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

	
	/*public static void main(String[] args) {
		LoginService loginService = new LoginService();
		String password = "arpitporwal";
		password = passwordUtility.generateMD5(password);
		loginService.registerUser(password);
	}*/
	
}
