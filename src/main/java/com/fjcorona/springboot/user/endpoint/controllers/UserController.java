package com.fjcorona.springboot.user.endpoint.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fjcorona.springboot.user.endpoint.models.User;
import com.fjcorona.springboot.user.endpoint.repositories.UserRepository;

/**
 * 
 * @author Francisco Javier Corona Sánchez
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		// Get all users entities
		List<User> users = repository.findAll();
		// Return found users
		return users;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/users/{id}")
	public User retriveOneUserById(@PathVariable Integer id) {
		// Look for the specific User
		Optional<User> user = repository.findById(id);
		// Return user if it was found, otherwise return an empty instance
		return (user.isPresent()) ? user.get() : new User();
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		// By default a new user is active
		user.setActive(1);
		// Insert the new user and save it
		User savedUser = repository.save(user);
		// Return the inserted user
		return savedUser;
	}

	/**
	 * 
	 * @param user
	 * @param id
	 * @return
	 */
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Integer id) {
		// Look for the user we want to update
		Optional<User> userOptional = repository.findById(id);

		// In case User doesn't exist, return an empty instance
		if (!userOptional.isPresent()) {
			new User();
		}

		// Set received user with the received id
		user.setId(id);
		// Set received user with the status from the found user
		user.setActive(userOptional.get().getActive());

		// Save user
		User savedUser = repository.save(user);

		// Return saved user
		return savedUser;
	}

	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/users/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		// Look for the user we want to update
		Optional<User> userOptional = repository.findById(id);

		// In case User exists delete it
		if (userOptional.isPresent()) {
			// Delete user
			repository.deleteById(id);
		}
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/users-active")
	public List<User> retriveAllActiveUsers() {
		// Send 1 to get all active users
		List<User> users = repository.findByActive(1);
		// Return all active users
		return users;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/users-active/{id}")
	public User retriveOneActiveUserById(@PathVariable Integer id) {
		// Look for the active user related wit the received id
		Optional<User> user = repository.findByActiveAndId(1, id);
		// Return user if it was found, otherwise return an empty instance
		return (user.isPresent()) ? user.get() : new User();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@PutMapping("/users/active/{id}")
	public User activeUser(@PathVariable Integer id) {
		// Active user with the received id
		return this.activeDeactiveUser(id, 1);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@PutMapping("/users/deactive/{id}")
	public User deactiveUser(@PathVariable Integer id) {
		// Deactive user with the received id
		return this.activeDeactiveUser(id, 0);
	}

	/**
	 * 
	 * @param id
	 * @param active
	 * @return
	 * 
	 * Depending on value of active param, the metod actives or deactives
	 * the user with id param
	 */
	private User activeDeactiveUser(Integer id, Integer active) {
		// Look for the user we want to update
		Optional<User> userOptional = repository.findById(id);

		// In case User doesn't exist, return an empty instance
		if (!userOptional.isPresent()) {
			return new User();
		}

		// Get user found
		User user = userOptional.get();

		// Set found user with the received id
		user.setId(id);
		// Set found user with the received active
		user.setActive(active);

		// Save user
		User savedUser = repository.save(user);

		// Return saved user
		return savedUser;
	}

}
