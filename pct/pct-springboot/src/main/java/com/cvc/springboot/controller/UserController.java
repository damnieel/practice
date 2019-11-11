package com.cvc.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvc.springboot.domain.User;
import com.cvc.springboot.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/helloworld")
	public String helloworld() {
		User user = userService.findUser();
		System.out.println(user.toString());
		return "helloworld";
	}
}
