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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.Product;
import com.example.rest.service.ProductService;

@RestController
@RequestMapping("/website")
public class Productcontroller {

	    @Autowired
		private ProductService productservice;

		
		@PostMapping("/product")
		public Product addProduct(@RequestBody Product product) {
			productservice.addproduct(product);
			return product;
		}
		
		@GetMapping("/product/{Id}")
		public ResponseEntity<?> GetProductById(@PathVariable Integer Id){
			Optional<Product> product= productservice.GetProductById(Id);
			
			if(product.isPresent()) {
				return ResponseEntity.ok(product.get());
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found "+Id);
			}
			
		}
		//Handled exception through controller
//		@GetMapping("/product/list")
//		public ResponseEntity<?> FetchAllProductById(){
//			Optional<List<Product>> product= productservice.FetchAllproduct();
//			
//			if(product.isPresent()) {
//				return ResponseEntity.ok(product.get());
//			}
//			else {
//				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found ");
//			}
//			
//		}
		@GetMapping("/product/list")
		public ResponseEntity<?> FetchAllProductById(){
			Optional<List<Product>> product=productservice.FetchAllproduct();
			
			return ResponseEntity.ok(product.get());
			
		}
		//Handled exception through controller
//		@DeleteMapping("/product/{Id}")
//		public ResponseEntity<?> DeleteProductById(@PathVariable Integer Id){
//			
//			boolean isdelete=productservice.DeleteProductByid(Id);
//			
//			if(isdelete) {
//				return ResponseEntity.ok(new HashMap<>());
//			}
//			else {
//				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found "+Id);
//			}
//		}
		//Handled exception through service layer
		@DeleteMapping("/product/{Id}")
		public ResponseEntity<?> DeleteProductById(@PathVariable Integer Id){
			
			productservice.DeleteProductByid(Id);
			return ResponseEntity.ok(new HashMap<>());
			
		}
	

}
