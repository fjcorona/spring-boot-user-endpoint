package com.fjcorona.springboot.user.endpoint.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Francisco Javier Corona Sánchez
 *
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id", nullable = false)
	private Integer id;

	@Column(name = "usr_name", nullable = false)
	private String name;

	@Column(name = "usr_lastname", nullable = false)
	private String lastname;

	@Column(name = "usr_age", nullable = false)
	private Integer age;

	@Column(name = "usr_active", nullable = false)
	private Integer active;

	/**
	 * 
	 */
	public User() {
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param lastname
	 * @param age
	 * @param active
	 */
	public User(Integer id, String name, String lastname, Integer age, Integer active) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.active = active;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * 
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getActive() {
		return active;
	}

	/**
	 * 
	 * @param active
	 */
	public void setActive(Integer active) {
		this.active = active;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, lastname=%s, age=%s, active=%s]", id, name, lastname, age, active);
	}

}
