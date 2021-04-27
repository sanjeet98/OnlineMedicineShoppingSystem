package com.medicineshopping.demo.dto;

public class CartItemDTO {
	
	private int userId;
	private int medicine_id;
	private int quantity;
	
	

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getMedicine_id() {
		return medicine_id;
	}



	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public CartItemDTO() {
		// TODO Auto-generated constructor stub
	}

}