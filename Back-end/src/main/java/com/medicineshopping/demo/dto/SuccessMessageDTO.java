package com.medicineshopping.demo.dto;

/**
 * @author Kaul's
 *
 */
public class SuccessMessageDTO {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public SuccessMessageDTO() {

	}

	public SuccessMessageDTO(String msg) {
		super();
		this.msg = msg;
	}

}