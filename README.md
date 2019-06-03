# _Menu_

* [_Introduction_](#introduction)
* [_Application Properties_](#application-properties)
* [_Dependencies_](#dependencies)
	* [_Spring Boot Data JPA Starter_](#spring-boot-data-jpa-starter)
	* [_Spring Boot Web Starter_](#spring-boot-web-starter)
	* [_Spring Boot Developer Tools_](#spring-boot-developer-tools)
	* [_H2 Database Engine_](#h2-database-engine)
	* [_Spring Boot Test Starter_](#spring-boot-test-starter)
	* [_JUnit_](#junit)
* [_Database_](#database)
* [_Bean_](#bean)
* [_Repository_](#repository)
* [_User Controller_](#user-controller)
	* [_Create User_](#create-user)
	* [_Get All Users_](#get-all-users)
	* [_Get User By Id_](#get-user-by-id)
	* [_Get All Active_](#get-all-active-users)
	* [_Get Active By Id_](#get-active-user-by-id)
	* [_Update User_](#update-user)
	* [_Delete User_](#delete-user)
	* [_Activate User_](#activate-user)
	* [_Deactivate User_](#deactivate-user)
* [_Postman_](#postman)

# _Introduction_

This project is especially focused on beginners, for all those who just want to know a quick and simple way to create microservices in spring boot.

Here you will find a small example in which you will be able to perform CRUD oepraciones for users, as well as activate and deactivate them. All this in a very isolated way to a graphical interface, the way it will be done through endpoints that rest requests, which can be consumed from Postman or any other client that has the capacity to consume them.

# _Application Properties_

When we are working with Spring Boot, the default port in which our application runs is ___8080___. In case this we want to change this default port, we have to take in account the [_application.properties_](src/main/resources/application.properties) file, here we can made some important configurations.

```properties
spring.application.name=user-endpoint-service
server.port=8888
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
I've selected the ___8888___ port, this way, my microservice will run in the next urL:

[_http://localhost:8888_](http://localhost:8888)

# _Dependencies_

As we can see at the structe, this project has been made under maven. That's why we need to add some dependencies to perform.

We can find those dependencies at [_pom.xml_](pom.xml)

## _Spring Boot Data JPA Starter_

Starter for using Spring Data JPA with Hibernate.

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

## _Spring Boot Web Starter_

Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

## _Spring Boot Developer Tools_

Spring Boot Developer Tools.

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<scope>runtime</scope>
</dependency>
```

## _H2 Database Engine_

H2 is a relational database management system written in Java. It can be embedded in Java applications or run in client-server mode.
It is possible to create both in-memory tables.

```xml
<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
```

## _Spring Boot Test Starter_

Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest and Mockito.

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```

## _JUnit_

JUnit is a regression testing framework written by Erich Gamma and Kent Beck. It is used by the developer who implements unit tests in Java.

```xml
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>
``` 

# _Database_

As it was mentioned before ___H2 Engine___ is the _RDBMS_ we will use to persist our information. Due to it supplies us with the advantaje to make in-memory tables. It means that we don't really need to install nothing because we will have a Runtime database, which will be deleted once the execution of the application finishes. What doesn't mean a problem for learning effects. You should easily change H2 for annother database management such as ***MySQL*** or ***PostgreSQL***.

We make the assumption we are working with JPA.

By default, spring boot reads the [_data.sql_](src/main/resources/data.sql) file located at ___resources___ folder to create our temporal database.

![data.sql](pictures/database/data.png)

It is as simple as declare insert queries with the table, the fields and the info we need:

```sql
INSERT INTO users (usr_id, usr_name, usr_lastname, usr_age, usr_active)
VALUES (10001, 'Javier', 'Corona', 30, 1);
INSERT INTO users (usr_id, usr_name, usr_lastname, usr_age, usr_active)
VALUES (10002, 'Francisco', 'Sánchez', 29, 1);
INSERT INTO users (usr_id, usr_name, usr_lastname, usr_age, usr_active)
VALUES (10003, 'Alejandra', 'López', 25, 0);
INSERT INTO users (usr_id, usr_name, usr_lastname, usr_age, usr_active)
VALUES (10004, 'Fernanda', 'Parra', 32, 1);
INSERT INTO users (usr_id, usr_name, usr_lastname, usr_age, usr_active)
VALUES (10005, 'Humberto', 'Lisboa', 22, 1);
INSERT INTO users (usr_id, usr_name, usr_lastname, usr_age, usr_active)
VALUES (10006, 'Paola', 'Duarte', 33, 1);
INSERT INTO users (usr_id, usr_name, usr_lastname, usr_age, usr_active)
VALUES (10007, 'Ernesto', 'Duarte', 33, 0);
INSERT INTO users (usr_id, usr_name, usr_lastname, usr_age, usr_active)
VALUES (10008, 'Filemón', 'Hernández', 25, 0);
INSERT INTO users (usr_id, usr_name, usr_lastname, usr_age, usr_active)
VALUES (10009, 'Pantaleón', 'Pérez', 23, 1);
INSERT INTO users (usr_id, usr_name, usr_lastname, usr_age, usr_active)
VALUES (10010, 'Serafino', 'Arriaga', 44, 1);
```


# _Bean_


```java
package com.fjcorona.springboot.user.endpoint.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

```

# _Repository_



# _User Controller_



## _Create User_



## _Get All Users_



## _Get User By Id_



## _Get All Active Users_



## _Get Active User By Id_



## _Update User_



## _Delete User_



## _Activate User_



## _Deactivate User_



# _Postman_



