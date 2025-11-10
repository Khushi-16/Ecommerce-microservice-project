package com.example.dto;

public class deletecart {
private String message;
private int productId;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public deletecart(String message, int productId) {
	super();
	this.message = message;
	this.productId = productId;
}

public deletecart() {
	
}
}
