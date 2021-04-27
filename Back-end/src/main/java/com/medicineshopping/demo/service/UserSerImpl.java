package com.medicineshopping.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicineshopping.demo.constant.UserConstant;
import com.medicineshopping.demo.dao.UserRepo;
import com.medicineshopping.demo.entity.User;
import com.medicineshopping.demo.exceptions.UserNotFoundException;

/**
 * @author Kaul's
 *
 */
@Service("userservice") // Contains actual business logic
@Transactional // Defines Scope of a single database transcation
public class UserSerImpl implements UserSer {

	@Autowired // Injects object dependencies
	UserRepo userrepo;

	@Override
	public User addUser(User user) { // adds users
		// TODO Auto-generated method stub
		return userrepo.save(user);
	}

	@Override
	public User getUserById(int userId) throws UserNotFoundException { // Gets user by userid
		// TODO Auto-generated method stub
		// Optional is a container that contains non-null objects
		Optional<User> optuser = userrepo.findById(userId);
		if (optuser.isPresent()) {
			return optuser.get();
		}
		throw new UserNotFoundException();
	}

	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
		// TODO Auto-generated method stub
		if (userrepo.findAll().isEmpty()) {
			throw new UserNotFoundException(UserConstant.USER_NOT_FOUND);
		}
		return userrepo.findAll();
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		if (user.getUserName().isEmpty()) {
			throw new UserNotFoundException(UserConstant.USER_NOT_UPDATED);
		} else {
			return userrepo.save(user);
		}
	}

	@Override
	public void deleteUser(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optuser = userrepo.findById(userId);
		if (optuser.isEmpty())
			throw new UserNotFoundException(UserConstant.USER_NOT_FOUND);
		User user = optuser.get();
		userrepo.delete(user);

	}

}