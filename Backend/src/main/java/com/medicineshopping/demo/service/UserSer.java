package com.medicineshopping.demo.service;


import java.util.List;

import com.medicineshopping.demo.entity.User;
import com.medicineshopping.demo.exceptions.UserNotFoundException;


public interface UserSer {
	
	User addUser(User user); //Adds users to the databse
	
	User updateUser(User user) throws UserNotFoundException;

	void deleteUser(int userId) throws UserNotFoundException;
		
	User getUserById(int userId) throws UserNotFoundException; //Gets user infomration by userid
	
	List<User> getAllUsers() throws UserNotFoundException;
}