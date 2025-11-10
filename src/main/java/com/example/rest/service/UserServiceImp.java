package com.example.rest.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.LoginReq;
import com.example.dto.Request;
import com.example.dto.Response;
import com.example.rest.model.User;
import com.example.rest.respository.User_respository;
@Service
public  class UserServiceImp implements UserService {

	@Autowired
	private User_respository user_repo;
	
	@Override
	public String adduser(Request rq) {

		User user= new User();
		Optional<User> existuser= user_repo.findByEmail(rq.getEmail());
		if(existuser.isPresent()) {
			return "User is already there";
		}
		else {
		user.setName(rq.getName());
		user.setEmail(rq.getEmail());
		user.setPassword(rq.getPassword());
		user.setCreatedAt(LocalDateTime.now());
		
		user.setRole("Customer");
		User saved=user_repo.save(user);
		return "User added";
//		Response rs= new Response();
//		rs.setName(saved.getName());
//		rs.setEmail(saved.getEmail());
//		rs.setRole(saved.getRole());
//		rs.setCreatedAt(saved.getCreatedAt());
//		rs.setId(saved.getId());
//		
//		return rs;
		}
		
		
		
		
	}

	public List<User> fetchalluser(){
		List<User> user=user_repo.findAll();
		return user;
	}
}
