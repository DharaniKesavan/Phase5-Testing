package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.model.UserCredentials;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService services;
	
	@PostMapping("/login")
	public String login(@RequestParam String email,@RequestParam String pass) {
		return services.login(email, pass);
	}
	
	@PostMapping("/register")
	public String register(@RequestBody UserCredentials uCred) {
		return services.register(uCred);
	}
	
	@PostMapping("/applyCard")
	public long applyCard(@RequestBody UserCredentials userCred) {
		return services.applyAadhar(userCred);
	}
	
	@PostMapping("/sendRequest")
	public boolean sendRequest(@RequestBody UserCredentials userCred,@RequestParam String reqName) {
		return services.sendRequest(userCred, reqName);
	}

}
