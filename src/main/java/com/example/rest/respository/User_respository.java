package com.example.rest.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.model.User;

@Repository
public  interface User_respository extends JpaRepository<User,Integer> {
	
	Optional<User> findByEmail(String email);

}
