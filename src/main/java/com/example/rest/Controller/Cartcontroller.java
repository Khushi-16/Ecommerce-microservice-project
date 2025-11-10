package com.example.rest.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import com.example.dto.AddToCartReq;
import com.example.dto.AddToCartReq2;
import com.example.dto.CartResponse;
import com.example.dto.Request;
import com.example.dto.Response;
import com.example.dto.deletecart;
import com.example.rest.model.User;
import com.example.rest.service.CartService;
import com.example.rest.service.UserService;

@RestController
@RequestMapping("/Cart")
public class Cartcontroller {

	    @Autowired
		private CartService cartservice;

		
		@PostMapping("/addcart")
		public String addtocart(@RequestHeader int user_id,@RequestBody  AddToCartReq addcart ) {
			String result =cartservice.additem(user_id, addcart);
		return result;
		}
		
		@GetMapping("/item")
		public ResponseEntity<CartResponse> getcart(@RequestHeader int user_id ) {
			CartResponse result =cartservice.viewcart(user_id);
		return ResponseEntity.ok(result);
		}
		
		@PutMapping("/update/{productId}")
		public ResponseEntity<AddToCartReq2> updatecart(@RequestHeader int user_id ,@PathVariable int productId,@RequestBody AddToCartReq2 addcart){
			AddToCartReq2 updatecartitem=cartservice.updateitem(user_id,productId,addcart);
			return ResponseEntity.ok(updatecartitem);
		}
		
		@DeleteMapping("/remove/{productId}")
		public ResponseEntity<deletecart> removecart(@RequestHeader int user_id ,@PathVariable int productId){
			deletecart deltcart=cartservice.removecart(user_id,productId);
			return ResponseEntity.ok(deltcart);
		}
	
	

}
