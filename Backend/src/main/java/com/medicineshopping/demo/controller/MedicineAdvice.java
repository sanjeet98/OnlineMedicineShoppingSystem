package com.medicineshopping.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.medicineshopping.demo.constant.MedicineConstant;
import com.medicineshopping.demo.dto.ErrorMessageDTO;
import com.medicineshopping.demo.exceptions.MedicineNotFoundException;
import com.medicineshopping.demo.exceptions.ValidateException;

@RestControllerAdvice
public class MedicineAdvice {
	
	@ExceptionHandler(MedicineNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDTO handleNotFoundException(MedicineNotFoundException exception)
	{
		return new ErrorMessageDTO(MedicineConstant.MEDICINE_NOT_FOUND,HttpStatus.NOT_FOUND.toString());
	}
	@ExceptionHandler(ValidateException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorMessageDTO handleValidateException(ValidateException exception)
	{
		List<String> lstmesagges=exception.getLserror().stream().map(m->m.getDefaultMessage().toString()).collect(Collectors.toList());
		return new ErrorMessageDTO(lstmesagges);
	}
	

}