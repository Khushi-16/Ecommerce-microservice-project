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

import com.example.dto.Request;
import com.example.dto.Response;
import com.example.rest.model.User;
import com.example.rest.service.UserService;

@RestController
@RequestMapping("/User")
public class Usercontroller {

	    @Autowired
		private UserService userservice;

		
		@PostMapping("/register")
		public String adduser(@RequestBody Request rq ) {
		String check=userservice.adduser(rq);
			return  check;
		}
		
		@GetMapping("/user-list")
		public List<User> fetchalluser(){
			List<User>result=userservice.fetchalluser();
			return result;
		}
		
	
	

}
