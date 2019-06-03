# _Menu_

* [Introduction](#introduction)
* [Port](#port)
* [Dependencies](#dependencies)
* [Database](#database)
* [Bean](#bean)
* [Repository](#repository)
* [User Controller](#user-controller)
	* [Create User](#create-user)
	* [Get All Users](#get-all-users)
	* [Get User By Id](#get-user-by-id)
	* [Get All Active](#get-all-active-users)
	* [Get Active By Id](#get-active-user-by-id)
	* [Update User](#update-user)
	* [Delete User](#delete-user)
	* [Activate User](#activate-user)
	* [Deactivate User](#deactivate-user)
* [Postman](#postman)


# _Introduction_

This project is especially focused on beginners, for all those who just want to know a quick and simple way to create microservices in spring boot.

Here you will find a small example in which you will be able to perform CRUD oepraciones for users, as well as activate and deactivate them. All this in a very isolated way to a graphical interface, the way it will be done through endpoints that rest requests, which can be consumed from Postman or any other client that has the capacity to consume them.

[![go up](pictures/go-up.png)](#menu)

# _Port_

When we are working with Spring Boot, the default port in which our application runs is ___8080___. In case this we want to change this default port, we have to take in account the [_application.properties_](src/main/resources/application.properties) file, here we can made some important configurations.

![application.properties](pictures/port/properties.png)

```properties
spring.application.name=user-endpoint-service
server.port=8888
```
I've selected the ___8888___ port, this way, my microservice will run in the next urL:

[_http://localhost:8888_](http://localhost:8888)

[![go up](pictures/go-up.png)](#menu)

# _Dependencies_

This projects has been

[![go up](pictures/go-up.png)](#menu)

# _Database_

[![go up](pictures/go-up.png)](#menu)

# _Bean_

[![go up](pictures/go-up.png)](#menu)

# _Repository_

[![go up](pictures/go-up.png)](#menu)

# _User Controller_

[![go up](pictures/go-up.png)](#menu)

## _Create User_

[![go up](pictures/go-up.png)](#menu)

## _Get All Users_

[![go up](pictures/go-up.png)](#menu)

## _Get User By Id_

[![go up](pictures/go-up.png)](#menu)

## _Get All Active Users_

[![go up](pictures/go-up.png)](#menu)

## _Get Active User By Id_

[![go up](pictures/go-up.png)](#menu)

## _Update User_

[![go up](pictures/go-up.png)](#menu)

## _Delete User_

[![go up](pictures/go-up.png)](#menu)

## _Activate User_

[![go up](pictures/go-up.png)](#menu)

## _Deactivate User_

[![go up](pictures/go-up.png)](#menu)

# _Postman_

[![go up](pictures/go-up.png)](#menu)