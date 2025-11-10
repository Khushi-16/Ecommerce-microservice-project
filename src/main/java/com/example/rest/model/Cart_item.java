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
@Table(name="Cart_item")

public class Cart_item {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int Id;
  @Column(name="user_id")
  private int userId;
  @Column(name="product_id")
  private int productId;
  @Column(name="quantity")
  private int quantity;
  @Column(name="addedAt")
  private LocalDateTime addedAt;
  public Cart_item() {
	  
  }
public Cart_item(int cartItemId, int userId, int productId, int quantity, LocalDateTime addedAt) {
	super();
	this.Id = cartItemId;
	this.userId = userId;
	this.productId = productId;
	this.quantity = quantity;
	this.addedAt = addedAt;
}
public int getCartItemId() {
	return Id;
}
public void setCartItemId(int cartItemId) {
	this.Id = cartItemId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public LocalDateTime getAddedAt() {
	return addedAt;
}
public void setAddedAt(LocalDateTime addedAt) {
	this.addedAt = addedAt;
}
@Override
public String toString() {
	return "Cart_item [cartItemId=" + Id + ", userId=" + userId + ", productId=" + productId + ", quantity="
			+ quantity + ", addedAt=" + addedAt + "]";
}
}
