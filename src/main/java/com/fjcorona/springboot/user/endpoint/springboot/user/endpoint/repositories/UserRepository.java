package com.fjcorona.springboot.user.endpoint.springboot.user.endpoint.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fjcorona.springboot.user.endpoint.springboot.user.endpoint.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findAll();
	Optional<User> findById(Integer id);
	@SuppressWarnings("unchecked")
	User save(User user);
	void deleteById(Integer id);
}