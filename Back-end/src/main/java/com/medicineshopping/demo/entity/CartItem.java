package com.medicineshopping.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Kaul's
 *
 */
@Entity
@Table(name = "medicine_cartitem")
public class CartItem {

	@Id
	@Column(name = "cart_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartitemId;
	@ManyToOne
	@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
	private Cart cart;
	@ManyToOne
	@JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
	private Medicine medicine;
	private int quantity;

	public int getCartitemId() {
		return cartitemId;
	}

	public void setCartitemId(int cartitemId) {
		this.cartitemId = cartitemId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartItem() {

	}

}