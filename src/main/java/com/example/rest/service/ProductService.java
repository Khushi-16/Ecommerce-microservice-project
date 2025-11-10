package com.example.rest.service;

import java.util.List;
import java.util.Optional;

import com.example.rest.model.Product;

public interface ProductService {
	
	public Product addproduct(Product product);
	
	public Optional<List<Product>>FetchAllproduct();
	
	public Optional<Product> GetProductById(Integer Id);
	public void DeleteProductByid(Integer Id);
	
	

}
