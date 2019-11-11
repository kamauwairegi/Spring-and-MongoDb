package com.spring.mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.models.User;
import com.spring.mongo.services.UserService;
import com.spring.mongo.utils.Constants;

@RestController
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@GetMapping(Constants.CREATE)
	public void createUsers() {
		userService.createUsers();
	}

	@GetMapping(Constants.DELETE_ALL)
	public void deleteAll() {
		userService.deleteAll();
	}
	
	@GetMapping(Constants.DELETE_ONE)
	public void deleteUser(@RequestParam(name = "id") String id) {
		userService.deleteById(id);
	}
	
	@GetMapping(Constants.VIEW_ALL)
	public List<User> viewAll() {
		return userService.findAll();
	}
	
	@GetMapping(Constants.VIEW_BY_FIRST_NAME)
	public User viewByFirstName(@RequestParam(name = "name") String name) {
		return userService.findByFirstName(name);
	}
	
	@GetMapping(Constants.VIEW_BY_LAST_NAME)
	public List<User> viewByLastName(@RequestParam(name = "name") String name) {
		return userService.findByLastName(name);
	}
}
