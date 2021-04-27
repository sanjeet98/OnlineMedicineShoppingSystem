package com.medicineshopping.demo.dto;

import java.util.List;

public class ErrorMessageDTO {
	
	private String msg;
	private String errorcode;
	public List<String> messages;
	public ErrorMessageDTO(String msg, String errorcode) {
		super();
		this.msg = msg;
		this.errorcode = errorcode;
	}
	public ErrorMessageDTO()
	{
		
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public ErrorMessageDTO(String msg) {
		super();
		this.msg = msg;
	}
	public ErrorMessageDTO(List<String> messages) {
		super();
		this.messages = messages;
	}
	
	
	

}