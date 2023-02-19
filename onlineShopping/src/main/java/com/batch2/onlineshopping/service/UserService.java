package com.batch2.onlineshopping.service;

import java.util.Optional;

import com.batch2.onlineshopping.entity.User;

public interface UserService {
	User saveUserDetails(User user);

	User updateUser(User user, int id);

	Optional<User> getUserDetails(int id);

	String deleteUser(int id);
	String login(User  user);

}
