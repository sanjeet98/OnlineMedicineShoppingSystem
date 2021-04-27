package com.medicineshopping.demo.service;

import com.medicineshopping.demo.dto.PaymentDTO;
import com.medicineshopping.demo.entity.Payment;
import com.medicineshopping.demo.exceptions.CartException;
import com.medicineshopping.demo.exceptions.UserNotFoundException;

public interface PaymentSer {
	
	public Payment addPayment(PaymentDTO paymentdto) throws CartException, UserNotFoundException;
	
	
	

}