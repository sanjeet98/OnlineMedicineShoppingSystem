package com.cg.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ILoginDao;
import com.cg.entity.User;
import com.cg.exceptions.LoginException;

@Service
public class LoginServiceImp implements LoginService{

	@Autowired
	private ILoginDao dao;
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImp.class);
	
	@Override
	public User doLogin(String userId, String password)throws LoginException {
		User user = null;
		logger.debug("doing login process");
		Optional<User> optUser = dao.findById(userId);
		if (optUser.isPresent()) {
			user = optUser.get();
			System.out.println(user.getPassword());
			if(!user.getPassword().equals(password))
				throw new LoginException("Password is Wrong, Check your Password");
			logger.info("User Authenticated for " + userId);
			return user;
		}
		
		throw new LoginException("Check your Credentials");
	}

	@Override
	public String encryptUser(User user) {
		return encryptString(user.getUserID())+"-" +encryptString(user.getUserName())+"-"
		      +encryptString(user.getRole());
	}
	
	public String encryptString(String str) {
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch ;
		for (int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]+3;
			sb.append((char)ch);
		}
		return sb.toString();
	}

	public String decryptString(String str) {
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch ;
		for (int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]-3;
			sb.append((char)ch);
		}
		return sb.toString();
	}

	
}
