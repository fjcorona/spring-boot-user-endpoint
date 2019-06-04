package com.fjcorona.springboot.user.endpoint.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fjcorona.springboot.user.endpoint.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	// Retrieve a list of all existent "User"
	List<User> findAll();
	
	// Retrieve on "User" by id, in case is found
	Optional<User> findById(Integer id);
	
	// Retrive the list of active users: findByActive(1), or inactive: findByActive(0)
	public List<User> findByActive(Integer active);
	
	// Retrieve one Active User by Id findByActiveAndId(1, :id)
	Optional<User> findByActiveAndId(Integer active, Integer id);
	
	// Add/Update a User entity
	@SuppressWarnings("unchecked")
	User save(User user);
	
	// Delete user by Id
	void deleteById(Integer id);
}