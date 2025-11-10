package com.example.rest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.AddToCartReq;
import com.example.dto.AddToCartReq2;
import com.example.dto.CartItemResponse;
import com.example.dto.CartResponse;
import com.example.dto.deletecart;
import com.example.rest.model.User;
import com.example.rest.ExceptionHandler.ResourceNotFoundException;
import com.example.rest.model.Cart_item;
import com.example.rest.model.Product;
import com.example.rest.respository.CartItem_respository;
import com.example.rest.respository.Product_respository;
import com.example.rest.respository.User_respository;

import jakarta.transaction.Transactional;
@Service
public class CartServiceImp implements CartService{
 
	
	@Autowired
	private CartItem_respository cartitem_repo;
	@Autowired
	private Product_respository product_repo;
	@Autowired
	private User_respository user_repo;
	@Override
	@Transactional
	public String additem(int user_id, AddToCartReq addtocart) {
		// TODO Auto-generated method stub
		Optional<User> existbyuserid=user_repo.findById(user_id);
		Optional<Product> existbyproductid=product_repo.findById(addtocart.getProductid());
		Optional<Cart_item> existitem=cartitem_repo.findByUserIdAndProductId(user_id,addtocart.getProductid());
		if(existitem.isPresent()) {
			Cart_item item=existitem.get();
			int update_quantity=item.getQuantity()+addtocart.getQuantity();
			item.setQuantity(update_quantity);
			cartitem_repo.save(item);
			
			return "Product quantity is updated in cart";
					
		}
		else {
			Cart_item item =new Cart_item();
			item.setUserId(user_id);
			item.setProductId(addtocart.getProductid());
			item.setQuantity(addtocart.getQuantity());
			LocalDateTime currentdate=LocalDateTime.now();
			item.setAddedAt(currentdate);
			cartitem_repo.save(item);
			return "Product is added to the cart";
		}
		
		
	}
	@Override
	public CartResponse viewcart(int user_id) {
		List<Cart_item> cartitemres = cartitem_repo.findByUserId(user_id);
		if(cartitemres.isEmpty()) {
			throw new ResourceNotFoundException("Cart is empty");
		}
		
		List<CartItemResponse> cartres=new ArrayList<>();
		double total =0;
		for(int i=0;i<cartitemres.size();i++) {
			Optional<Product> p = product_repo.findById(cartitemres.get(i).getProductId());
			Product product=p.get();
			CartItemResponse res=new CartItemResponse();
			res.setProductid(p.get().getId());
			res.setName(product.getName());
			res.setPrice(product.getPrice());
			res.setQuantity(cartitemres.get(i).getQuantity());
			double subtotal = cartitemres.get(i).getQuantity()*product.getPrice();
			res.setSubtotal(subtotal);
			total+=subtotal;
			cartres.add(res);
		}
		
		CartResponse cartresponse= new CartResponse();
		cartresponse.setCartitemresponse(cartres);
		cartresponse.setTotal(total);
		return cartresponse;
	}
	@Override
	@Transactional
	public deletecart removecart(int user_id,int productId) {
		Cart_item cartitemres = cartitem_repo.findByUserIdAndProductId1(user_id, productId);
		cartitem_repo.delete(cartitemres);
		deletecart dlct=new deletecart();
		dlct.setProductId(productId);
		dlct.setMessage("The "+productId+"  is remove from the cart");
		return dlct;
	}
	@Override
	@Transactional
	public AddToCartReq2 updateitem(int user_id, int productId,AddToCartReq2 request) {
		Cart_item cartitemres = cartitem_repo.findByUserIdAndProductId1(user_id, productId);
		
		if(cartitemres==null) {
			throw new ResourceNotFoundException("product not found");
		}
		AddToCartReq2 updatecart=new AddToCartReq2();
		System.out.println(request.getQuantity());
		if(request.getQuantity()==0) {
			cartitem_repo.delete(cartitemres);
			 AddToCartReq2 response = new AddToCartReq2();
		        response.setProductid(productId);
		        response.setQuantity(0);
		        System.out.println("Product removed from cart as quantity = 0");
		        return response;
		}
		cartitemres.setQuantity(request.getQuantity());
		cartitem_repo.save(cartitemres);
		updatecart.setProductid(productId);
		updatecart.setQuantity(cartitemres.getQuantity());
		
		
		return updatecart;
	}
	
	
	
}
