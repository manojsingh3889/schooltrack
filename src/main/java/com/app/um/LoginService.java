package com.app.um;

import com.app.data.beans.UserLogin;
import com.app.data.dao.UserLoginDAO;
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

}
