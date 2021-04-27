package com.medicineshopping.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicineshopping.demo.constant.CartConstant;
import com.medicineshopping.demo.constant.UserConstant;
import com.medicineshopping.demo.dao.CartRepo;
import com.medicineshopping.demo.dao.PaymentRepo;
import com.medicineshopping.demo.dao.UserRepo;
import com.medicineshopping.demo.dto.PaymentDTO;
import com.medicineshopping.demo.entity.Cart;
import com.medicineshopping.demo.entity.Payment;
import com.medicineshopping.demo.entity.User;
import com.medicineshopping.demo.exceptions.CartException;
import com.medicineshopping.demo.exceptions.UserNotFoundException;

@Service("paymentservice")
@Transactional
public class PaymentSerImpl implements PaymentSer  {
	
	
	@Autowired
	private PaymentRepo paymentrepo;
	@Autowired
	private CartRepo cartrepo;
	@Autowired
	private UserRepo userrepo; 
	
	

	@Override
	public Payment addPayment(PaymentDTO paymentdto) throws CartException, UserNotFoundException  {
		// TODO Auto-generated method stub
		Optional<Cart> optcart=cartrepo.findById(paymentdto.getCartId());
		if(optcart.isEmpty()) throw new CartException(CartConstant.CART_NOT_FOUND);
		Cart cart=optcart.get();
		
		Optional<User> optuser=userrepo.findById(paymentdto.getUserId());
		if(optuser.isEmpty()) throw new UserNotFoundException(UserConstant.USER_NOT_FOUND);
		Payment payment=new Payment();
		
		payment.setCart(cart);
		payment.setUser(optuser.get());
		payment.setCardType(paymentdto.getCardType());
		payment.setCardNo(paymentdto.getCardNo());
		payment.setPaymentamount(paymentdto.getPaymentamount());
		Payment addedpayment=paymentrepo.save(payment);
		
		
		return addedpayment;
	}
	
	

}