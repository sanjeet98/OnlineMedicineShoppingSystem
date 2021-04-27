package com.medicineshopping.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // It defines that a class can be mapped to a table
@Table(name = "medicine_cart") // It specifies the name of the database table to be used for mapping
public class Cart {

	@Id // It specifies the primary key of an entity
	@Column(name = "cart_id") // It is used to specify the mapped column for a persistent property or field
	private String cartId;
	private LocalDate dateOfOrder;
	private String cartStatus;
	@ManyToOne // One cart can have many items
	@JoinColumn(name = "user_id", referencedColumnName = "user_id") /* used to specify a column for joining 
	an entity association or element collection */
	
	private User user;

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

	public String getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart() {

	}

}