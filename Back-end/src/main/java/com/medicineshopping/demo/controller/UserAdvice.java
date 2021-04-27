package com.medicineshopping.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.medicineshopping.demo.constant.UserConstant;
import com.medicineshopping.demo.dto.ErrorMessageDTO;
import com.medicineshopping.demo.exceptions.UserNotFoundException;
import com.medicineshopping.demo.exceptions.ValidateException;

/**
 * @author Kaul's
 *
 */
@SuppressWarnings("unused")
@RestControllerAdvice
public class UserAdvice {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDTO handleNotFoundException(UserNotFoundException exception) {
		return new ErrorMessageDTO(UserConstant.USER_NOT_FOUND, HttpStatus.NOT_FOUND.toString());
	}

	// @ExceptionHandler(ValidateException.class)
	// @ResponseStatus(HttpStatus.FORBIDDEN)
	// public ErrorMessageDTO handleValidateException(ValidateException exception)
	// {
	// List<String>
	// lstmesagges=exception.getLserror().stream().map(m->m.getDefaultMessage().toString()).collect(Collectors.toList());
	// return new ErrorMessageDTO(lstmesagges);
	// }

}