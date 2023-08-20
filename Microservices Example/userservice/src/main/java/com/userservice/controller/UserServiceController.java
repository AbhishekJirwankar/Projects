package com.userservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entity.User;
import com.userservice.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserServiceController {

	@Autowired
	private UserRepo userRepo;
	
	@GetMapping
	public String get() {
		return "User Working";
	}
	
	@PostMapping
	public User save( @RequestBody User user) {
		return userRepo.createUser(user);
	}
	
	@GetMapping("/{userId}")
	public User get(@PathVariable String userId) {
		return userRepo.getUserById(userId);
	}
	
	@DeleteMapping("/{userId}")
	public String delete(@PathVariable String userId) {
		return userRepo.deleteUser(userId);	
	}
	
	@PutMapping()
	public String update(@RequestBody User user) {
		return userRepo.updateCustomer(user);
	}
}
