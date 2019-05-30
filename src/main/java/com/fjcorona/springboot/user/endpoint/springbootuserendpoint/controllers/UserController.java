package com.fjcorona.springboot.user.endpoint.springbootuserendpoint.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public User retriveOneUserById(@PathVariable Integer id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		user.setActive(1);
		User savedUser = repository.save(user);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Integer id) {
		Optional<User> userOptional = repository.findById(id);

		if (!userOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		user.setId(id);

		repository.save(user);

		return ResponseEntity.noContent().build();
	}

}
