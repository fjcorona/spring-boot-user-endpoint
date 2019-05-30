package com.fjcorona.springboot.user.endpoint.springbootuserendpoint.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastnme")
	private String lastname;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "active")
	private Integer active;

	public User() {

	}

	public User(Integer id, String name, String lastname, Integer age, Integer active) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, lastname=%s, age=%s, active=%s]", id, name, lastname, age, active);
	}

}
