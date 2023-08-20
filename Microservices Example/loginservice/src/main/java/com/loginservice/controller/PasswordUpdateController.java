package com.loginservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passUpdate")
public class PasswordUpdateController {

	
	@GetMapping
	public String get() {
		return "Password Update Working";
	}
}
