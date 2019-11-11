package com.spring.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.mongo.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public User findByFirstName(String firstName);
	public List<User> findByLastName(String lastName);
}
