package com.example.rest.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.ExceptionHandler.ResourceNotFoundException;
import com.example.rest.model.Product;
import com.example.rest.respository.Product_respository;

import jakarta.transaction.Transactional;
@Service
public class ProductServiceImp implements ProductService{
 
	
	@Autowired
	private Product_respository product_repo;
	@Override
	@Transactional
	public Product addproduct(Product product) {
		// TODO Auto-generated method stub
		LocalDateTime currentdatetime=LocalDateTime.now();
		product.setCreatedAt(currentdatetime);
		product_repo.save(product);
		return product;
	}
	@Override
	public Optional<List<Product>> FetchAllproduct() {
		// TODO Auto-generated method stub
		Optional<List<Product>> product =Optional.ofNullable(product_repo.findAll());
		if(product.isEmpty()) {
			throw new ResourceNotFoundException("No Data found");
		}
		else {
			return product;
		}
	}
	@Override
	public Optional<Product> GetProductById(Integer Id) {
		
		return product_repo.findById(Id);
		
		
	}
	@Override
	public void DeleteProductByid(Integer Id) {
		 Optional<Product> product=product_repo.findById(Id);
		 if(product.isPresent()) {
			 product_repo.deleteById(Id);
			
		 }
	
		 else {
		 throw new ResourceNotFoundException("Product Not Found" +Id);
		 }
	}
}
