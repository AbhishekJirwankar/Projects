package com.loginservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginServiceController {

	public static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceController.class);
	
	@GetMapping
	public String get() {
		
		LOGGER.info("login working");
		
		return "Login Working";
	}
}
