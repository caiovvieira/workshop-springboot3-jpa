package com.myproject.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.course.entities.User;

@RestController    

@RequestMapping(value = "/users") 

public class UserResource {

	@GetMapping 
	
	public ResponseEntity<User> findAll() { 
		
		User user = new User(1L, "Caio", "caio@teste.com", "999999999", "12345");
		
		return ResponseEntity.ok().body(user);  
		
	}

}


