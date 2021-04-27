package com.medicineshopping.demo.service;

import java.util.List;

import com.medicineshopping.demo.entity.Cart;
import com.medicineshopping.demo.exceptions.CartException;
import com.medicineshopping.demo.exceptions.UserNotFoundException;


public interface CartSer {

	// Cart addCart(Cart cart);

	// Cart getCartById(int cartId);

	// Cart validateUser(int cartId) throws IOException;

	// Cart updateCart(Cart cart);

	String confirmOrder(int userId) throws UserNotFoundException, CartException;

	List<Cart> getOrders(int userId) throws UserNotFoundException, CartException;

	// List<Cart> viewCartItems(int cartId);

}