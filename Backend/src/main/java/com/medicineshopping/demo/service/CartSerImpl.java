package com.medicineshopping.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicineshopping.demo.constant.CartConstant;
import com.medicineshopping.demo.constant.UserConstant;
import com.medicineshopping.demo.dao.CartRepo;
import com.medicineshopping.demo.dao.UserRepo;
import com.medicineshopping.demo.entity.Cart;
import com.medicineshopping.demo.entity.User;
import com.medicineshopping.demo.exceptions.CartException;
import com.medicineshopping.demo.exceptions.UserNotFoundException;


@Service("cartservice") /* The class is marked as service provider. 
It can be applied only to classes */

@Transactional /* It defines the scope of a single database. 
It is used for service layer as it contains the business logic */

public class CartSerImpl implements CartSer {

	@Autowired /*  marks a constructor, field, or setter method to
	 be autowired by Spring dependency injection */

	private CartRepo cartrepo;
	@Autowired
	private UserRepo userrepo;

	@Override /*
				 * It informs the compiler that the element is meant to override an element
				 * declared in a superclass. It also prevents errors
				 */

	public String confirmOrder(int userId) throws UserNotFoundException, CartException {
		// TODO Auto-generated method stub

		Optional<User> optuser = userrepo.findById(userId);
		/*
		 * findById() method is used to retrieve an entity by its id and is available in
		 * crud repository interface
		 */

		if (optuser.isEmpty()) // It checks whether the given object is empty
		{
			throw new UserNotFoundException(UserConstant.USER_NOT_FOUND);
		}
		Cart cart = cartrepo.getCart(userId, CartConstant.CART);

		if (cart == null) // It will check whether the cart is empty
		{
			throw new CartException(CartConstant.CART_EMPTY);
		}
		cart.setCartStatus(CartConstant.CART_ORDER_STATUS); // It will check the cart status
		cartrepo.save(cart);
		return cart.getCartId();
	}

	@Override /*
				 * It informs the compiler that the element is meant to override an element
				 * declared in a superclass. It also prevents errors
				 */

	public List<Cart> getOrders(int userId) throws UserNotFoundException, CartException {
		// TODO Auto-generated method stub
		Optional<User> optuser = userrepo.findById(userId);
		/*
		 * findById() method is used to retrieve an entity by its id and is available in
		 * crud repository interface
		 */

		if (optuser.isEmpty()) // It checks if the user is available or not
		{
			throw new UserNotFoundException(UserConstant.USER_NOT_FOUND);
		}
		List<Cart> carts = cartrepo.getOrder(userId, CartConstant.CART_ORDER_STATUS);
		if (carts.isEmpty()) // It checks whether the cart is empty with no orders
		{
			throw new CartException(CartConstant.ORDER_EMPTY);
		}
		return carts;
	}

}