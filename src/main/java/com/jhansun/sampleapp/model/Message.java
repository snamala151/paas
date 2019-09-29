package com.jhansun.sampleapp.model;

public class Message {
	
	String messageType;
	String message;
	
	public Message(String messageType, String message) {
		this.messageType = messageType;
		this.message = message;
	}
	
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
