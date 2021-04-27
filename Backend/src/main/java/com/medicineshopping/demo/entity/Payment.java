package com.medicineshopping.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity //Entity is a group of states associated together in a single unit
@Table(name="medicine_payment") //Creates table with a table name
public class Payment {
	
	@Id //Specifies primary key of entity
	@GeneratedValue(strategy=GenerationType.AUTO) //Generates automatic object ID's for entity objects
	private int paymentId;
	@ManyToOne //Many to one relationship
	@JoinColumn(name="user_id",referencedColumnName = "user_id") //user_id is primary key of User class and foreign key of Payment class
	private User user;
	@ManyToOne //Many to one relationship
    @JoinColumn(name="cart_id",referencedColumnName = "cart_id") //cart_id is primary key of Cart class and foreign key of Payment class
	private Cart cart;
	@NotNull(message="cardType cannot be null")
	private String cardType;
	@Pattern(regexp="[A-Za-z0-9]{16}")
	private String cardNo;
	@Column(name="paymentamount",nullable=true) //Names the column 
	private double paymentamount;
	
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public double getPaymentamount() {
		return paymentamount;
	}

	public void setPaymentamount(double paymentamount) {
		this.paymentamount = paymentamount;
	}

	public Payment()
	{
		
	}

	public Payment(int paymentId, User user, Cart cart, @NotNull(message = "cardType cannot be null") String cardType,
			@Pattern(regexp = "[A-Za-z0-9]{16}") String cardNo, double paymentamount) {
		super();
		this.paymentId = paymentId;
		this.user = user;
		this.cart = cart;
		this.cardType = cardType;
		this.cardNo = cardNo;
		this.paymentamount = paymentamount;
	}

}