package com.example.dto;

public class LoginReq {

	
	//private String name;
	private String password;
	private String email;
	/*
	 * public String getName() { return name; }
	 */

	/*
	 * public void setName(String name) { this.name = name; }
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LoginReq( String password, String email) {
		super();
	//	this.name = name;
		this.password = password;
		this.email = email;
	}
	public LoginReq() {
		
	}
}
