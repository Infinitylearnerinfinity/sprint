package com.batch2.onlineshopping.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.batch2.onlineshopping.entity.User;
import com.batch2.onlineshopping.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController 

public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/registration")
	public User userRegistration(@RequestBody User user) {

		return userService.saveUserDetails(user);
	}
    
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value="hasRole('ROLE_ADMIN') || hasRole('ROLE_CUSTOMER')")
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id) {

		return userService.updateUser(user,id);
	}
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value="hasRole('ROLE_ADMIN') || hasRole('ROLE_CUSTOMER')")
	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		
		return userService.getUserDetails(id);	
	}
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value="hasRole('ROLE_ADMIN') || hasRole('ROLE_CUSTOMER')")
    @DeleteMapping("/user/{id}")
	public String  deleteUser(@PathVariable int id) {
		
		return userService.deleteUser(id);	
	}
	
	
	
	
}
