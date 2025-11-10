package com.example.dto;

import java.util.List;

public class CartResponse {
	
	private List<CartItemResponse> cartitemresponse;
	private double total;
	public CartResponse(){
		
	}
	public CartResponse(List<CartItemResponse> cartitemresponse, double total) {
		super();
		this.cartitemresponse = cartitemresponse;
		this.total = total;
	}
	public List<CartItemResponse> getCartitemresponse() {
		return cartitemresponse;
	}
	public void setCartitemresponse(List<CartItemResponse> cartitemresponse) {
		this.cartitemresponse = cartitemresponse;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
