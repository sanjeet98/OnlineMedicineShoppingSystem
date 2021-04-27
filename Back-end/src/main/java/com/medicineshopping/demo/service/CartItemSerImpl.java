package com.medicineshopping.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicineshopping.demo.constant.CartConstant;
import com.medicineshopping.demo.constant.MedicineConstant;
import com.medicineshopping.demo.constant.UserConstant;
import com.medicineshopping.demo.dao.CartItemRepo;
import com.medicineshopping.demo.dao.CartRepo;
import com.medicineshopping.demo.dao.MedicineRepo;
import com.medicineshopping.demo.dao.UserRepo;
import com.medicineshopping.demo.dto.CartItemDTO;
import com.medicineshopping.demo.entity.Cart;
import com.medicineshopping.demo.entity.CartItem;
import com.medicineshopping.demo.entity.Medicine;
import com.medicineshopping.demo.entity.User;
import com.medicineshopping.demo.exceptions.CartException;
import com.medicineshopping.demo.exceptions.CartItemException;
import com.medicineshopping.demo.exceptions.MedicineNotFoundException;
import com.medicineshopping.demo.exceptions.UserNotFoundException;

/**
 * @author Kaul's
 *
 */
@Service("cartitemservice")
@Transactional
public class CartItemSerImpl implements CartItemSer {

	@Autowired
	private CartItemRepo cartitemrepo;
	@Autowired
	private CartRepo cartrepo;
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private MedicineRepo medicinerepo;

	@Override
	public CartItem addCartItem(CartItemDTO cartitemdto)
			throws CartException, MedicineNotFoundException, UserNotFoundException {
		// TODO Auto-generated method stub
		// Optional<Cart> optcart=cartrepo.findById(cartitemdto.getCart_id());
		// if(optcart.isEmpty()) throw new CartException(CartConstant.CART_NOT_FOUND);
		// Cart cart=optcart.get();
		Optional<User> optuser = userrepo.findById(cartitemdto.getUserId());
		if (optuser.isEmpty()) {
			throw new UserNotFoundException(UserConstant.USER_NOT_FOUND);
		}
		Cart cart = cartrepo.getCart(cartitemdto.getUserId(), CartConstant.CART);
		if (cart == null) {
			Cart newcart = new Cart();
			newcart.setCartId(LocalDateTime.now().toString() + cartitemdto.getUserId());
			newcart.setCartStatus(CartConstant.CART);
			newcart.setUser(optuser.get());
			newcart.setDateOfOrder(LocalDate.now());
			cart = cartrepo.save(newcart);
		}
		Optional<Medicine> optmedicine = medicinerepo.findById(cartitemdto.getMedicine_id());
		if (optmedicine.isEmpty())
			throw new MedicineNotFoundException(MedicineConstant.MEDICINE_NOT_FOUND);
		CartItem cartitem = new CartItem();

		cartitem.setCart(cart);
		cartitem.setMedicine(optmedicine.get());
		cartitem.setQuantity(cartitemdto.getQuantity());
		CartItem addedItem = cartitemrepo.save(cartitem);
		return addedItem;

	}

	@Override
	public CartItem editCartItem(int cartitemId, int quantity) throws CartItemException {
		// TODO Auto-generated method stub
		Optional<CartItem> optcartitem = cartitemrepo.findById(cartitemId);
		if (optcartitem.isEmpty())
			throw new CartItemException(CartConstant.CART_ITEM_NOT_FOUND);
		CartItem item = optcartitem.get();
		item.setQuantity(quantity);
		CartItem editedItem = cartitemrepo.save(item);
		return editedItem;
	}

	@Override
	public boolean removeCartItem(int cartitemId) throws CartItemException {
		// TODO Auto-generated method stub
		Optional<CartItem> optcartitem = cartitemrepo.findById(cartitemId);
		if (optcartitem.isEmpty())
			throw new CartItemException(CartConstant.CART_ITEM_NOT_FOUND);
		CartItem item = optcartitem.get();
		cartitemrepo.delete(item);
		return true;

	}

	@Override
	public List<CartItem> getCartItem(String cartId) throws CartException {
		// TODO Auto-generated method stub
		Optional<Cart> optcart = cartrepo.findById(cartId);
		if (optcart.isEmpty())
			throw new CartException(CartConstant.CART_NOT_FOUND);
		List<CartItem> cartitems = cartitemrepo.getCartItems(cartId);
		if (cartitems.isEmpty()) {
			throw new CartException(CartConstant.CART_EMPTY);
		}
		return cartitems;
	}

}