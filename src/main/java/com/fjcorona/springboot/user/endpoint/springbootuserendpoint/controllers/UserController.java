package com.fjcorona.springboot.user.endpoint.springbootuserendpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fjcorona.springboot.user.endpoint.springbootuserendpoint.models.User;
import com.fjcorona.springboot.user.endpoint.springbootuserendpoint.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private UserRepository repository;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		List<User> users = repository.findAll();
		
		/*
		users.stream().map(user ->{
			user.setPort(Integer.parseInt(environment.getProperty("local.server.pot")));
			return user;
		});
		*/

		return users;
	}
}
