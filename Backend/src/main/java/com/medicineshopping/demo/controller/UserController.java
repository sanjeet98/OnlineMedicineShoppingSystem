package com.medicineshopping.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicineshopping.demo.constant.UserConstant;
import com.medicineshopping.demo.dto.SuccessMessageDTO;
import com.medicineshopping.demo.entity.User;
import com.medicineshopping.demo.exceptions.UserNotFoundException;
import com.medicineshopping.demo.exceptions.ValidateException;
import com.medicineshopping.demo.service.UserSer;

 
@CrossOrigin(origins = "http://localhost:3000")
@RestController //Maps the web requests
@RequestMapping("/api/v2/")
public class UserController {
	
	@Autowired //Injects the object dependencies
	UserSer userser;
	@PostMapping("/users") // Maps the HTTP POST requests on the specific handler method
	public SuccessMessageDTO addUser(@Valid @RequestBody User user,BindingResult br) throws ValidateException
	{
		if(br.hasErrors()) 
			throw new ValidateException(br.getFieldErrors());
		User id=userser.addUser(user);
		return new SuccessMessageDTO(UserConstant.USER_ADDED + id);
	}
	
	@PutMapping("/users") // Maps the HTTP PUT requests on the specific handler method
	public User updateUser(@RequestBody User user) throws UserNotFoundException
	{
    	return userser.updateUser(user);
	}
	
	@DeleteMapping("/users/{userId}") // Maps the HTTP DELETE requests on the specific handler method
	public SuccessMessageDTO deleteUserById(@PathVariable("userId")int userId) throws UserNotFoundException 
	{
		userser.deleteUser(userId);
		return new SuccessMessageDTO(UserConstant.USER_DELETE + userId);
	}
	
	@GetMapping("/users/{userId}") //Maps the HTTP GET requests on the specific handler method
	public User getUserById(@PathVariable(name="userId") int userId) throws UserNotFoundException
	{
		return userser.getUserById(userId);
	}
    
	@GetMapping("/users") //Maps the HTTP GET requests on the specific handler method
	public List<User> fetchAllUsers() throws UserNotFoundException
	{
		return userser.getAllUsers();
	}
}