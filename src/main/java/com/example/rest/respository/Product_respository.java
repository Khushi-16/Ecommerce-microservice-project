package com.example.rest.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.model.Product;

@Repository
public  interface Product_respository extends JpaRepository<Product,Integer> {

}
