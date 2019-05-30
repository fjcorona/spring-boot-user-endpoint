package com.fjcorona.springboot.user.endpoint.springbootuserendpoint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fjcorona.springboot.user.endpoint.springbootuserendpoint.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAll();
	// User findOne(Integer id);
}