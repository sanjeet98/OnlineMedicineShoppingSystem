package com.medicineshopping.demo.dto;

public class PaymentDTO {
		
	private String cartId;
	
	private int userId;
	
	private String cardType;
	
	private String cardNo;
	
	private double paymentamount;


	public String getCartId() { //To get Cart ID
		return cartId;
	}



	public void setCartId(String cartId) { //Assign Cart ID value
		this.cartId = cartId;
	}



	public int getUserId() { //To get User ID
		return userId;
	}



	public void setUserId(int userId) { //Assign User ID value
		this.userId = userId;
	}



	public String getCardType() { //To get Cart Type
		return cardType;
	}



	public void setCardType(String cardType) { //Assign Card Type 
		this.cardType = cardType;
	}



	public String getCardNo() { //To get Card Number
		return cardNo;
	}



	public void setCardNo(String cardNo) { //Assign Cart No with value
		this.cardNo = cardNo;
	}



	public double getPaymentamount() { //To get the payment amount
		return paymentamount;
	}



	public void setPaymentamount(double paymentamount) { //Assign value for payment amount
		this.paymentamount = paymentamount;
	}



	public PaymentDTO() {
		// TODO Auto-generated constructor stub
	}

}