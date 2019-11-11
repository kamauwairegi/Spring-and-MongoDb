package com.spring.mongo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.models.Address;
import com.spring.mongo.models.User;
import com.spring.mongo.repositories.UserRepository;
import com.spring.mongo.utils.Constants;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void createUsers() {
		for (int i = 0; i < 2; i++) {
			User user = new User();
			user.setId("" + i);
			user.setFirstName("Test" + i);
			user.setLastName("User" + i);
			user.setAddress(generateRandomAddresses());

			userRepository.save(user);
		}
	}

	private List<Address> generateRandomAddresses() {
		List<Address> addresses = new ArrayList<Address>();
		for (int i = 0; i < 2; i++) {
			Address address = new Address();
			address.setCity("City" + i);
			address.setHouseNumber(i);
			address.setState("State" + i);
			address.setStreetAddress("Street Address" + i);
			if (i < 1)
				address.setType(Constants.HOME);
			else
				address.setType(Constants.WORK);

			address.setZipCode("Code" + i);

			addresses.add(address);

		}
		return addresses;
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByFirstName(String name) {
		return userRepository.findByFirstName(name);
	}

	@Override
	public List<User> findByLastName(String name) {
		return userRepository.findByLastName(name);
	}

	@Override
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}

}
