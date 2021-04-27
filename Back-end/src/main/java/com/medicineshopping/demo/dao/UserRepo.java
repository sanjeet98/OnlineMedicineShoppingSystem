package com.medicineshopping.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicineshopping.demo.entity.User;

/**
 * @author Kaul's
 *
 */
@SuppressWarnings("unused")
public interface UserRepo extends JpaRepository<User, Integer> {

}