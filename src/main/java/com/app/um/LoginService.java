package com.app.um;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	public String authenticateUser(String username,String password){
		if("testuser".equals(username) && "testpassword".equals(password)){
			return "ha bhai tu he apna bhai";
		}else{
			return "bhai tu farzi h , a kabhi haweli pe";
		}
	}
}
