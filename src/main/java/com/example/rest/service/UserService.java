package com.example.rest.service;

import java.util.List;
import java.util.Optional;

import com.example.dto.Request;
import com.example.dto.Response;
import com.example.rest.model.User;

public interface UserService {

	
	public String adduser(Request rq);
	
	public List<User> fetchalluser();

}
