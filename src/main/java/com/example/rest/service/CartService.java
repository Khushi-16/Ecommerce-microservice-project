package com.example.rest.service;

import java.util.List;
import java.util.Optional;

import com.example.dto.AddToCartReq;
import com.example.dto.AddToCartReq2;
import com.example.dto.CartResponse;
import com.example.dto.deletecart;
import com.example.rest.model.Cart_item;

public interface CartService {

	

	String additem(int user_id, AddToCartReq addtocart);
	
	CartResponse viewcart(int user_id);

	deletecart removecart(int user_id,int productId);


	AddToCartReq2 updateitem(int user_id, int productId, AddToCartReq2 addtocartreq);

}
