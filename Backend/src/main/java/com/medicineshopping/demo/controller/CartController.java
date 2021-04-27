package com.medicineshopping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicineshopping.demo.dao.CartRepo;
import com.medicineshopping.demo.dao.PaymentRepo;
import com.medicineshopping.demo.entity.Cart;
import com.medicineshopping.demo.entity.Payment;
import com.medicineshopping.demo.exceptions.CartException;
import com.medicineshopping.demo.exceptions.UserNotFoundException;
import com.medicineshopping.demo.service.CartSer;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class CartController {
	
	@Autowired
	private CartRepo cartRepo;

	@Autowired
	CartSer cartser;
	
	@GetMapping("/confirmcart")
	public List<Cart> getAllCart() {		
		return cartRepo.findAll();
	}

	// confirm cart
	@GetMapping("confirmcart/{uid}") // It used to handle GET type of request method 
	public String confirmCart(@PathVariable("uid") int userId) throws UserNotFoundException, CartException {
		return cartser.confirmOrder(userId);
		/* @PathVariable - It is used to handle template variables in the 
		request URI mapping, and use them as method parameters. */ 
	}

	// view order by userid
	
	@SuppressWarnings("rawtypes") // It suppresses all raw-types warnings inside the method
	@GetMapping("vieworder/{uid}") // It used to handle GET type of request method 
	public List viewOrders(@PathVariable("uid") int userId) throws UserNotFoundException, CartException {
		return cartser.getOrders(userId); 
		
		/* @PathVariable - It is used to handle template variables in the 
		request URI mapping, and use them as method parameters. */ 
	}
	// view cart items by cartid
}