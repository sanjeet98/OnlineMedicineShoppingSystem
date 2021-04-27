package com.medicineshopping.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicineshopping.demo.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	
	
}