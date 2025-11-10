package com.example.rest.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Product")

public class Product {
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	@Column(name="name")
    private String name;
	@Column(name="description")
    private String description;
	@Column(name="price")
    private double price;
    
	@Column(name="category")
	private String category;
	@Column(name="stock")
    private String stock;
	@Column(name="createdAt")
    private LocalDateTime createdAt;
    
    public Product() {
    	
    }
    public Product(int id, String name, String description, double price, String category, String stock,
    		LocalDateTime createdAt) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.stock = stock;
		this.createdAt = createdAt;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
    

}
