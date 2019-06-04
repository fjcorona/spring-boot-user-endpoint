# _Menu_

* [_Introduction_](#introduction)
* [_Application Properties_](#application-properties)
	* [_Application Name_](#application-name) 
	* [_Port_](#port)
	* [_JPA Show SQL_](#jpa-show-sql)
	* [_JPA Format SQL_](#jpa-format-sql)
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

Here you will find a small example in which you will be able to perform CRUD oepraciones for users, as well as activate and deactivate them. All this in a very isolated way to a graphical interface, the way it will be done through endpoints with REST requests, which can be consumed From any application or client that has the capacity to consume them. We will test the endpoints with Postman.

# _Application Properties_

When we are working with Spring Boot, we have an [_application.properties_](src/main/resources/application.properties) file, here we can make some important configurations. There are some configurations which Spring Boot understand by default, but there are another ones that we have to explicity set in the file.

For this project we will set just four properties.

## _Application Name_

The variable `spring.application.nameset` the application name and indicates the name of the file in the GIT repository where the settings were sought.

This is the wey to set the property at file:

```properties
spring.application.name=user-endpoint-service
```

## _Port_

The default port in which a Spring Boot application runs is ___8080___. In the case we want to change this default port, we have to set `server.port` variable: 

```properties
server.port=8888
```

I've selected the ___8888___ port, this way, my microservice will run in the next urL:

[_http://localhost:8888_](http://localhost:8888)

## _JPA Show SQL_

When the project is executed, there is a log, in which the errors are shown as well as some relevant information about our application. Thanks to the property `spring.jpa.show-sql` we have the possibility to see the queries related to our temporary database.

```properties
spring.jpa.show-sql=true
```

We just set the property as true, if we don't set this property, by default is false and no query is going to be shown. Later we will see some examples

## _JPA Format SQL_

This property works complemtaria, with the previous property, because although, the previous property shows the cpnsultas, it does not make a nice format. That's where `spring.jpa.properties.hibernate.format_sql` comes into action to achieve that goal.

```properties
spring.jpa.properties.hibernate.format_sql=true
```

In the same way, this property by default is false, so we have to set as true.

Later we will see some examples of both properties working together.

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

	/*
	 * Insert Getters, Setters and Constructors Here
	 * /

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



