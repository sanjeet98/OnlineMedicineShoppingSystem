package com.medicineshopping.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * @author Kaul's
 *
 */
@SuppressWarnings("unused")
public class UserDTO {

	private int userId;
	private String userName;
	private String userAddress;
	private long userPhno;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public long getUserPhno() {
		return userPhno;
	}

	public void setUserPhno(long userPhno) {
		this.userPhno = userPhno;
	}

	public UserDTO() {

	}
}