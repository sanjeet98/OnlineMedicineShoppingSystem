package com.medicineshopping.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.medicineshopping.demo.dto.ErrorMessageDTO;
import com.medicineshopping.demo.exceptions.CartException;
import com.medicineshopping.demo.exceptions.CartItemException;

@RestControllerAdvice
public class CartAdvice {
	
	@ExceptionHandler(CartItemException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDTO handleNotItemException(CartItemException exception)
	{
		return new ErrorMessageDTO(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(CartException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDTO handleCartException(CartException exception)
	{
		return new ErrorMessageDTO(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	

}