package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.entities.User;
import com.app.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/all")
	public List<User> getUser() {
		return userService.findUser();
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> saveUser(@RequestBody UserDto user) {
		System.out.println("User" + user);
		return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(user));
	}
	
	
	
}
