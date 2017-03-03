package com.app.um;

import com.app.data.beans.UserLogin;
import com.app.data.dao.UserLoginDAO;


public class LoginService {

	public UserLogin getUserLoginObject(String email,String password) {
		UserLoginDAO userLoginDAO = new UserLoginDAO();
		UserLogin userLogin = (UserLogin) userLoginDAO.findByEmail(email);
		String passwordSalt = password;
		String passwordHash = password;
		if(username.equals(userLogin.getEmail()) && passwordSalt.equals(userLogin.getPasswordsalt())
				&& passwordHash.equals(userLogin.getPasswordhash())){
			return userLogin;
		}else return null;
	}

}
