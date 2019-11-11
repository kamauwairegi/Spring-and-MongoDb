package com.spring.mongo.services;

import java.util.List;

import com.spring.mongo.models.User;

public interface UserService {

	public void createUsers();
	
	public List<User> findAll();
	
	public User findByFirstName(String name);
	
	public List<User> findByLastName(String name);
	
	public void deleteById(String id);

	public void deleteAll();
}
