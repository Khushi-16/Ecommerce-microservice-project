package com.example.dto;

public class CartItemResponse {

	
private int productid;
private double price;
private String name;
private double subtotal;
private int quantity;

public CartItemResponse(int productid, double price, String name, int subtotal, int quantity) {
	super();
	this.productid = productid;
	this.price = price;
	this.name = name;
	this.subtotal = subtotal;
	this.quantity = quantity;
}

public CartItemResponse() {
	
}

public int getProductid() {
	return productid;
}

public void setProductid(int productid) {
	this.productid = productid;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getSubtotal() {
	return subtotal;
}

public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
