package com.fjcorona.springboot.user.endpoint.springbootuserendpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fjcorona.springboot.user.endpoint.springbootuserendpoint.models.User;
import com.fjcorona.springboot.user.endpoint.springbootuserendpoint.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		List<User> users = repository.findAll();
		return users;
	}

	@GetMapping("/users/{id}")
	public User retriveOneById(@PathVariable Integer id) {
		/*
		User user = repository.findOne(id);
		return user;
		*/
		return new User();
	}
}
