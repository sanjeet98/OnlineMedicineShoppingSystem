package com.medicineshopping.demo.dto;

import java.time.LocalDate;

public class CartDTO {
	
	private String cartId;
	private LocalDate dateOfOrder;
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

}