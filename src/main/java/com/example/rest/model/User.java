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
@Table(name="User")
public class User {
	

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	@Column(name="name")
    private String name;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	@Column(name="createdAt")
    private LocalDateTime createdAt;
	public User() {
		
	}
	public User(int id, String name, String email, String password, String role, LocalDateTime createdAt) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", createdAt=" + createdAt + "]";
	}
	
	

}
